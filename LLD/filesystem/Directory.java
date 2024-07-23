package LLD.filesystem;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Directory {
    private String name;
    private List<String> permissions;
    private List<File> files;
    private Date created;
    private Date modified;
    private List<Directory> directories;

    public Directory(String name,List<String> permissions) {
        this.name = name;
        this.permissions = permissions;
        files  = new ArrayList<>();
        created = new Date();
        modified = new Date();
    }

    public List<Directory> getDirectories() {
        return directories;
    }

    public void removeFile(String path){
        for (int i = 0; i < files.size(); i++){
            if (files.get(i).getPath().equals(path)){
                files.remove(i);
            }
        }
    }

    public void setDirectories(List<Directory> directories) {
        this.directories = directories;
    }

    public List<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<String> permissions) {
        this.permissions = permissions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public List<File> getFiles() {
        return files;
    }

    public void setFiles(List<File> files) {
        this.files = files;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
