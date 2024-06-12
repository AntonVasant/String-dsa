package bank;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CustomerFileHandler {
    static final String fileName = "C:\\Users\\Hp\\Desktop\\String\\bank\\bank.txt";
    public void initialize() throws IOException {

        FileReader file = new FileReader(fileName);
        BufferedReader reader = new BufferedReader(file);
        String line;
        while((line = reader.readLine()) != null){
            String[] details = line.split("\\s+");
            Bank.list.add(stringToCustomer(details));
        }
    }
    public int updateResult(char source,char destination,int id){
        int totalAmount = destination - source;
        Bank.list.get(id).setBalance(Bank.list.get(id).getBalance() - fare(totalAmount));
        return Bank.list.get(id).balance;

    }
    private int fare(int number){
        if (number <= 3) return number*10;
        else return 30+(number-3)*20;
    }
    private Customer stringToCustomer(String[] details){
        return new Customer(Integer.parseInt(details[0]),
                Integer.parseInt(details[1]),details[2],details[3],Integer.parseInt(details[4]));
    }
}
