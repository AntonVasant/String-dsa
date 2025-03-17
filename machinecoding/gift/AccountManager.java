package machinecoding.gift;

import LLD.elevator.Lift;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class AccountManager {

    private final String path = "machinecoding/gift/customer";

    private static Map<Integer, Customer> customerMap;


    public AccountManager(){
        initialize();
    }

    public boolean handleLogin(int id, String password){
        Customer customer = customerMap.get(id);
        if (customer == null) return false;
        String hash = customer.getPassword();
        return PasswordUtil.verifyPassword(password, hash);
    }

    public void addMoney(int customer, double amount){
        Customer customer1 = customerMap.get(customer);
        customer1.setBalance(customer1.getBalance() + amount);
    }

    public void printCustomers(){
        for (Customer customer : customerMap.values()){
            customer.print();
        }
    }

    public void lowerBalance(int id, double amount){
        Customer customer = customerMap.get(id);
        customer.setBalance(customer.getBalance() - amount);
    }

    public boolean hasSufficientBalance(double amount, int id){
        return (customerMap.containsKey(id) && customerMap.get(id).getBalance() >= amount);
    }

    private void initialize(){
        Path path1 = Paths.get(path);
        Function<String, Customer> function = string -> {
            String[] arr = string.split(" ");
            return new Customer(Integer.parseInt(arr[0]), arr[1], arr[2], Double.parseDouble(arr[3]));
        };
        List<Customer> customers = FileHandler.read(path1,function);
        customerMap = new HashMap<>();
        for (Customer customer :  customers){
            customerMap.put(customer.getId(), customer);
        }
    }
}
