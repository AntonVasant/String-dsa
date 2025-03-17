package designpatterns.composite;

import java.util.Date;

public class Main {

    public static void main(String[] args) {
        FileSystem system = new FileSystem("root");
        System.out.println(new Date());
    }
}
