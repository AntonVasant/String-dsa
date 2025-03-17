package machinecoding.files;

import java.util.ArrayList;
import java.util.List;

public class RecycleBin {

    private static List<Component> list;

    public RecycleBin(){
        list = new ArrayList<>();
    }

    public void add(Component component){
        list.add(component);
    }

    public Component restore(Component component){
        if (list.contains(component)){
            return component;
        }
        System.out.println("Not exist");
        return null;
    }
}
