package machinecoding.gift;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

public class FileHandler {

    public static <T> void write(Path path, List<T> items, Function<T, String> function){
        try {
            try(BufferedWriter writer = Files.newBufferedWriter(path)){
                for (T type : items){
                    writer.write(function.apply(type));
                }
            }
        }
        catch (IOException io){
            System.out.println("io e");
        }
    }

    public static <T> List<T> read(Path path, Function<String, T> function){
        try {
            List<T> list = new ArrayList<>();
            try(BufferedReader reader = Files.newBufferedReader(path)){
                String line;
               while ((line = reader.readLine()) != null){
                   list.add(function.apply(line));
               }

            }
            return list;
        }
        catch (IOException e){
            System.out.println("io");
        }
        return Collections.emptyList();
    }
}
