package machinecoding.files;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Directory implements Component{
    String name;
    List<Component> children;
    Date lastModified;

    public Directory(String name){
        this.name = name;
        children = new ArrayList<>();
        lastModified = new Date();
    }
    @Override
    public void ls() {
        System.out.println(lastModified.toString()+"   Dir   "+name);
        for (Component component : children){
            component.ls();
        }
    }

    @Override
    public void mkdir(String name) {
        Directory directory = new Directory(name);
        children.add(directory);
    }

    @Override
    public void cd(String path) {
        for (Component component : children){
            if (component instanceof Directory && ((Directory)component).getName().equals(path)){
                System.out.println("Directory changed " + ((Directory) component).getName());
            }
        }
    }

    @Override
    public void delete() {
        for (Component component : children)
            component.delete();
    }

    @Override
    public void addContent(String content) {
        System.out.println("Cannot add content");
    }

    @Override
    public void modifyContent(String content) {
        System.out.println("Cannot modify");
    }

    @Override
    public void restore(Component component) {

    }

    public String getName() {
        return name;
    }

    public List<Component> getChildren() {
        return children;
    }

    public Date getLastModified() {
        return lastModified;
    }
}
