package machinecoding.gift;

import array.SquareCheck;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        AccountManager manager = new AccountManager();
        GiftCardManager giftManager = new GiftCardManager(manager);
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while (flag){
            System.out.println("1. Login\n3. Close");
            int choice = scanner.nextInt();
            switch (choice){
                case 1 -> {
                    System.out.println("Enter id");
                    int idd = scanner.nextInt();
                    System.out.println("Enter password");
                    String pass = scanner.next();
                    if (!manager.handleLogin(idd, pass)){
                        System.out.println("Wrong credentials");
                        break;
                    }
                    boolean nested=  true;
                    while (nested){
                        System.out.println("1. Create card\n2. Topup\n3. Transaction History\n4. BlockGiftCard\n5. Back");
                        int choic = scanner.nextInt();
                        switch (choic){
                            case 1 -> {
                                System.out.println("Enter customer id");
                                int id = scanner.nextInt();
                                GiftCardResponse response = giftManager.createGiftCard(id);
                                if (response != null){
                                    System.out.println("Card number "+ response.getCardNumber());
                                    System.out.println("Password number "+ response.getCardPassword());
                                }
                            }

                            case 2 -> {
                                System.out.println("Enter id");
                                int id = scanner.nextInt();
                                System.out.println("Enter card password");
                                String password = scanner.next();
                                boolean res = giftManager.verifyUser(id, password);
                                if (!res){
                                    System.out.println("Error: data not found");
                                    return;
                                }
                                System.out.println("Enter amount");
                                double amount = scanner.nextDouble();
                                boolean hasBalance = manager.hasSufficientBalance(amount, id);
                                if (!hasBalance){
                                    System.out.println("No balance "+ amount);
                                    return;
                                }
                                manager.lowerBalance(id, amount);
                                giftManager.topUp(id, amount);
                            }
                            case 3 -> {
                                System.out.println("Enter customer id");
                                int id = scanner.nextInt();
                                giftManager.printTransaction(id);
                            }
                            case 4 -> {
                                System.out.println("Enter your id");
                                int id = scanner.nextInt();
                                System.out.println("Enter card password");
                                String password = scanner.next();
                                if (giftManager.verifyUser(id, password)){
                                    giftManager.blockCard(id);
                                    System.out.println("Blocked");
                                    return;
                                }
                                System.out.println("Not found");
                            }
                            case 5 -> nested = false;
                        }
                    }
                }
                case 3 -> flag = false;
            }
        }
    }
}
