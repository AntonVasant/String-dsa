package machinecoding.files;

import java.util.Date;

public class File implements Component{
    String name;
    String content;
    Date lastModified;


    @Override
    public void ls() {
        System.out.println("Cannot list in files");
    }

    @Override
    public void mkdir(String name) {
        lastModified = new Date();
        System.out.println("Cannot create directory inside files");
    }

    @Override
    public void cd(String path) {
        System.err.println("Cannot change directory");
    }

    @Override
    public void delete() {
        System.out.println("Deleted "+ name);
    }

    @Override
    public void addContent(String content) {
        lastModified = new Date();
        this.content = content;
        System.out.println("Content added " + name);
    }

    @Override
    public void modifyContent(String content) {
        lastModified  = new Date();
        this.content = content;
        System.out.println("File content modified "+name);
    }

    @Override
    public void restore(Component component) {
        System.out.println("Restored "+ name);
    }
}
