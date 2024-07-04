package library;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Library {
     static List<String> books = new ArrayList<>();

     public static void read(String name)throws IOException {
          BufferedReader reader = new BufferedReader(new FileReader(name));
          String s;
          reader.readLine();
          while ((s = reader.readLine()) != null){
               books.add(s);
          }
          reader.close();
     }
}
