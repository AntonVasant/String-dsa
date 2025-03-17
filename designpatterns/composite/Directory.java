package designpatterns.composite;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Directory extends FileSystemComponent{

    List<FileSystemComponent> subDirectories;
    public Directory(String name) {
        super(name);
        subDirectories = new ArrayList<>();
    }

    @Override
    public void ls() {
        if (!isDeleted()){
            System.out.println("Directory Name "+ getName());
            for (FileSystemComponent component : subDirectories){
                component.ls();
            }
        }

    }

    @Override
    public void delete() {
        for (FileSystemComponent component : subDirectories){
            component.setDeleted(true);
        }
    }

    @Override
    public void restore() {
        if (isDeleted()){
            setDeleted(false);
            for (FileSystemComponent component : subDirectories){
                component.setDeleted(false);
            }
        }
    }

    @Override
    public void update(String content) {

    }

    @Override
    public void rename(String name) {
        setName(name);
        setLastModified(new Date());
    }

    public void add(FileSystemComponent component){
        subDirectories.add(component);
    }

    public void removeComponent(FileSystemComponent component){
        subDirectories.remove(component);
    }
}
