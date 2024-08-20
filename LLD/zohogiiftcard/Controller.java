package LLD.zohogiiftcard;

import java.util.Scanner;

public class Controller {
    private Service service;
    private Scanner scanner;
    public Controller(Service service,Scanner scanner) {
        this.service = service;
        this.scanner = scanner;
    }

    public void createCard(int cusId,double amount){
        GiftCard giftCard = service.createGiftCard(cusId,amount);
        if (giftCard == null){
            System.out.println("cannot create card for you");
        }
        else
            System.out.println("card created "+giftCard.getId()+" password : "+giftCard.getPassword());
    }
    public boolean login(int cusId,String password){
        boolean status = service.login(password,cusId);
        if (status){
            return true;
        }else System.out.println("Failed login");
        return false;
    }
    public void topUp(int cusId,double amount,int cardNo){
        boolean status = service.topUp(cusId,amount,cardNo);
        if (status) System.out.println("Top success");
        else System.out.println("top up failed");
    }

    public void purchase(int id,double amount,int cardPassword){
        boolean flag = true;
        do {
           Transaction transaction = service.purchase(id,cardPassword,amount);
            if (transaction == null){
            System.out.println("Transaction failed");
            flag = false;
        }
            else {
                System.out.println("Transaction completed "+transaction.getAmount()+"transaction id "+transaction.getId());
                System.out.println("you want to continue");
                String ans = scanner.next();
                if (ans.equalsIgnoreCase("no"))
                    flag = false;
            }
        }while (flag);
    }

    public void blockCard(int id,int cardNo){
        boolean status = service.blockCard(id,cardNo);
        if (status) System.out.println("blocked successfully");
        else System.out.println("Process failed");
    }
    public void printAll(){
        service.printAllTransaction();
    }
}
