package LLD.metro;

import java.io.*;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class MetroDepartment {
    static Map<String,User> users = new LinkedHashMap<>();


    public void travelManagement(String cardNo,char startLocation,char destination,String fileName){
       try {
           users = readUsers(fileName);
           manageTravel(cardNo,startLocation,destination);
           updateDetails(fileName);
       }catch (IOException e){
           System.out.println("oops error");;
       }
    }

    private void updateDetails(String fileName) throws IOException{
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        writer.write("Name  Card Number  Balance  LastLocation\n");
        for (User user : users.values()){
            writer.write(user.getName()+"  "+user.getCardNo()+"  "+user.getBalance()+"  "+user.getLastDestination()+"\n");
        }
        writer.close();
    }
    private void manageTravel(String cardNo,char startLocation,char destination){
        User user = users.get(cardNo);
        if (user == null){
            System.out.println("user not found");
            return;
        }
        if (user.getBalance() < 100){
            System.out.println("not enough balance");
            return;
        }
        user.setBalance(user.getBalance()-calculateFare(startLocation,destination));
        user.setLastDestination(startLocation+" to "+destination);
    }

    private int calculateFare(char start,char end){
        int distance = Math.abs(start-end);
        if (distance < 3) return distance*10;
        return 30 + 30 *(distance-3);
    }
        private Map<String, User> readUsers(String fileName) throws IOException {
            Map<String, User> users = new HashMap<>();
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            reader.readLine();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                if (parts.length < 3) {
                    continue;
                }
                try {
                    String name = parts[0];
                    String cardNo = parts[1];
                    int balance = Integer.parseInt(parts[2]);
                    users.put(cardNo, new User(name, cardNo, balance));
                } catch (NumberFormatException e) {
                    System.out.println("Skipping line due to invalid number format: " + line);
                }
            }
            reader.close();
            return users;
        }
}
