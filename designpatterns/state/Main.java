package designpatterns.state;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ATMMachine machine = new ATMMachine(20000);
        machine.insertCard();
        System.out.println("Enter pin");
        int pin = scanner.nextInt();
        if(!machine.enterPin(pin)){
            System.out.println("Wrong pin");
            return;
        }
        System.out.println("Enter amount");
        int amount = scanner.nextInt();
        machine.enterAmount(amount);
        machine.dispenseCash();
    }


}
