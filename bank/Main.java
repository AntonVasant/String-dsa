package bank;

import java.io.IOException;

public class Main {
    public static void main(String a[]){
        CustomerFileHandler fileHandler = new CustomerFileHandler();
        try{
            fileHandler.initialize();
            System.out.println(Bank.list.get(0).getName());
        }catch (IOException e){
            System.out.println("file not found");;
        }

    }
}
