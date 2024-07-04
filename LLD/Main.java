package LLD;

import java.util.Scanner;

public class Main {
    public static void main(String a[]){
        String file = "C:\\Users\\Hp\\Desktop\\String\\LLD\\metro\\details";
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter card number");
        String cardNo = sc.next();
        System.out.println("enter start location");
        char start = sc.next().charAt(0);
        System.out.println("enter destination");
        char end = sc.next().charAt(0);
        MetroDepartment department = new MetroDepartment();
        department.travelManagement(cardNo,start,end,file);
    }
}
