package LLD.filesystem;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] a){
        FileSystem fileSystem = new FileSystem();
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while (flag){
            System.out.println("Enter 1 for creating file");
            System.out.println("Enter 2 for creating directory");
            System.out.println("Enter 1 for creating file");
            int n = scanner.nextInt();
            switch (n){
                case 1:{
                    System.out.println("Enter name,path,type and permission");
                    String name = scanner.next();
                    String path = scanner.next();
                    String type = scanner.next();
                    fileSystem.createFile(name,path,type,new ArrayList<>());
                    break;
                }
                case 2:{

                }
            }
        }
    }
}
