package designpatterns.composite;

public class FileSystem {

    private Directory root;

    public FileSystem(String name){
        root = new Directory(name);
    }


    public void add(FileSystemComponent component, String dirName){
        root.add(component);
    }

//    private Directory getDirectoryByName(String name){
//
//    }

}
