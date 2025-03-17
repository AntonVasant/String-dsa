package LLD.tax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class FileHandling {


    String userDetails = "C:\\Users\\Hp\\Desktop\\String\\LLD\\tax\\userdetails";

    private static FileHandling instance;

    private  final TaxSystem system = TaxSystem.getInstance();
    public static FileHandling getInstance(){
        if (instance == null)
            instance = new FileHandling();
        return instance;
    }

    public List<List<Integer>> getDetails(String name){
        List<List<Integer>> list = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(name));
            String line;
            while ((line = reader.readLine()) != null){
                List<Integer> list1 = parse(line);
                list.add(list1);
            }
            reader.close();
        }catch (IOException e){
            System.out.println("File not found");
        }
        list.sort(Comparator.comparingInt(a -> a.get(0)));
        return list;
    }

    public void loadData(){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(userDetails));
            String line;
            while ((line = reader.readLine()) != null){
                User user = convertUser(line);
                system.saveUser(user.getName(),user);
            }
            reader.close();
        }catch (IOException e){
            System.out.println("File not found");
        }

    }

    private List<Integer> parse(String s){
        String[] arr  = s.split("\\s+");
        int amount = Integer.parseInt(arr[0]);
        int percent = Integer.parseInt(arr[1]);
        return new ArrayList<>(Arrays.asList(amount,percent));
    }

    private User convertUser(String s){
        String[] arr = s.split("\\s+");
        User user = AccountCreationFactory.createUser(arr[0],arr[1],arr[2]);
        return user;
    }
}
