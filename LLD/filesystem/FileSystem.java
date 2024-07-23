package LLD.filesystem;

import java.util.*;

public class FileSystem {
    Directory root;
    Map<String,File> fileMap;
    Map<String,Directory> directoryMap;
    Stack<File> deletedFiles;

    public FileSystem(){
        root = new Directory("/",List.of("a","x","y"));
        fileMap = new HashMap<>();
        directoryMap = new HashMap<>();
        deletedFiles = new Stack<>();
        directoryMap.put("/",root);
    }

    public File createFile(String name,String path,String type,List<String> permissions){
        Directory directory = directoryMap.get(path);
        if (directory == null){
            System.out.println("No directory found");
            return null;
        }
        File file = new File(name,path,type,permissions);
        directory.getFiles().add(file);
        fileMap.put(path+"/"+name,file);
        return file;
    }

    public Directory createDirectory(String name,String path,List<String> permissions){
        Directory directory = directoryMap.get(path);
        if (directory == null){
            System.out.println("no such directory");
            return null;
        }
        Directory newDir = new Directory(name, permissions);
        directory.getDirectories().add(newDir);
        directoryMap.put(path+"/"+name,newDir);
        return newDir;
    }

    public void updateContent(String path,byte[] content){
        File file = fileMap.get(path);
        if (file == null){
            System.out.println("file not found");
            return;
        }
        file.setContent(content);
    }

    public void updateName(String path,String newName){
        File file = fileMap.get(path);
        if (file != null){
            fileMap.remove(file);
            file.setName(newName);
            fileMap.put(path.substring(0,path.lastIndexOf('/')+1)+newName,file);
        }else if(directoryMap.containsKey(path)){
            Directory directory = directoryMap.get(path);
            directoryMap.remove(path);
            directory.setName(newName);
            directoryMap.put(path.substring(0,path.lastIndexOf('/')+1)+newName,directory);
        }else System.out.println("not  found to update");
    }

    public void removeFile(String path){
        File file = fileMap.get(path);
        if (file != null){
            deletedFiles.push(file);
            String dirPath = path.substring(0,path.lastIndexOf('/'));
            Directory directory = directoryMap.get(dirPath);
            directory.removeFile(path);
            fileMap.remove(path);
        }else System.out.println("nothing found");
    }

    public void removeDirectory(String path){
        Directory directory = directoryMap.get(path);
        if (directory != null){
            String dir = path.substring(0,path.lastIndexOf('/'));
            Directory dirs = directoryMap.get(dir);
            if (dirs != null)
                directoryMap.remove(dir);
            else System.out.println("not found");
        }else System.out.println("not found");
    }
}
