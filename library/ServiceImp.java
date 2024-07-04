package library;

import java.io.*;
import java.util.*;

public class ServiceImp implements Service{

    static Map<Long,User> usersMap = new HashMap<>();
    static List<User> usersList = new ArrayList<>();
    @Override
    public void registerUser(String userName) {
        if (userName.isEmpty() || userName.trim().isEmpty()){
            System.out.println("user name cannot be empty");
            return;
        }
        if (!userName.matches("^[a-zA-Z0-9]*$")){
            System.out.println("Invalid username");
            return;
        }
        User user = new User(userName);
        usersList.add(user);
        usersMap.put(user.getId(),user);
    }

    @Override
    public void barrowBook(String bookName, long id) {
        if (!Library.books.contains(bookName)){
            System.out.println("Book not found");
            return;
        }
        if (!usersMap.containsKey(id)){
            System.out.println("not a valid user");
            return;
        }
        User user = usersMap.get(id);
        Library.books.remove(bookName);
        user.booksDetails.add(bookName);
    }

    @Override
    public void returnBook(String bookName, long id) {
        if (!usersMap.containsKey(id)) {
            System.out.println("not a valid user");
            return;
        }
        User user = usersMap.get(id);
        user.booksDetails.remove(bookName);
        Library.books.add(bookName);
    }

    @Override
    public User showDetails(long id) {
        if (!usersMap.containsKey(id)){
            System.out.println("user not found");
            return null;
        }
        return usersMap.get(id);
    }

    public void readFile(String fileName)throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        reader.readLine();
        String line;
        while (( line = reader.readLine()) != null){
            String[] parts = line.split(" ");
            String name = parts[0];
            long id = Long.parseLong(parts[1]);
            User user = new User(name,id);
            usersMap.put(id,user);
            usersList.add(user);
        }
        reader.close();
    }
    public void updateFile(String name)throws IOException{
        BufferedWriter writer = new BufferedWriter(new FileWriter(name));
        writer.write("Name   Id   Books Barrow\n");
        for (User user : usersList){
            writer.write(user.getName()+"   "+user.getId()+"  ");
            List<String> list = user.getBooksDetails();
            if (!list.isEmpty()){
                for (String s : list){
                    writer.write(s+" ");
                }
            }
            writer.write("\n");
        }
        writer.close();
    }

}
