package library;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String a[]){

        ServiceImp serviceImp = new ServiceImp();
        Controller controller = new Controller(serviceImp);
        String file1 = "C:\\Users\\Hp\\Desktop\\String\\library\\LibraryBooks";
        String file2 = "C:\\Users\\Hp\\Desktop\\String\\library\\UserDetails";
        try {
            serviceImp.readFile(file2);
            Library.read(file1);
        }catch (IOException e){
            e.printStackTrace();
        }
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while (flag){
            System.out.println("Enter 1 for register");
            System.out.println("Enter 2 for barrow book");
            System.out.println("Enter 3 for return book");
            System.out.println("Enter 4 for user details");
            System.out.println("Enter 5 for exit");
            int n = scanner.nextInt();
            switch (n){
                case 1:{
                    System.out.println("Enter user name");
                    String name = scanner.next();
                    controller.registerUser(name);
                    break;
                }
                case 2:{
                    System.out.println("Enter book name");
                    String bookName = scanner.next();
                    System.out.println("Enter id");
                    long id = scanner.nextLong();
                    controller.barrowBook(bookName,id);
                    break;
                }
                case 3:{
                    System.out.println("Enter book name");
                    String bookName = scanner.next();
                    System.out.println("Enter id");
                    long id = scanner.nextLong();
                    controller.returnBook(bookName,id);
                    break;
                }
                case 4:{
                    System.out.println("Enter id");
                    long id = scanner.nextLong();
                    controller.getUserDetails(id);
                    break;
                }
                case 5:{
                    try {
                        serviceImp.updateFile(file2);
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                    flag=false;
                    break;
                }
            }
        }
    }
}
