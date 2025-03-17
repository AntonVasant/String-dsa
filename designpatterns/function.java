package designpatterns;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

public class function {

    public static void main(String[] args) {

        System.out.println("❌ No seats available. Added to RAC or Waitlist.");
        function function = new function();
        Path path = Paths.get("C:\\Users\\Hp\\Desktop\\String\\designpatterns\\user");
        Function<String, User> function1 = (user -> {
            String[] line = user.split(" ");
            return new User(Integer.parseInt(line[0]), line[1], Integer.parseInt(line[2]));
        });


       List<User> list = function.read(path,function1);
       for (User user : list){
           System.out.println(user.getAge()+" "+ user.getName());
       }

       User user = new User(3, "Vinayan", 24);
       User user1 = new User(4,"Me", 3);
       list.add(user1);
       list.add(user);


       Function<User, String> function2 = (user2 -> user2.getId()+" "+user2.getName()+" "+user2.getAge()+"\n");
       function.write(path, list, function2);
    }


    private <T> List<T> read(Path path, Function<String, T> function){
        try {
            List<T> list = new ArrayList<>();
            try(BufferedReader reader = Files.newBufferedReader(path)){
                String line;
                while ((line = reader.readLine()) != null)
                    list.add(function.apply(line));

            }
            return list;
        }
        catch (IOException e){
            System.out.println("d");
        }
        return Collections.emptyList();
    }

    private <V> void write(Path path, List<V> list, Function<V, String> function){
        try {
            try(BufferedWriter writer = Files.newBufferedWriter(path,StandardOpenOption.APPEND)){
                for (V type : list){
                    writer.write(function.apply(type));
                }
            }
        }
        catch (IOException e){
            System.out.println("do");
        }
    }
}
