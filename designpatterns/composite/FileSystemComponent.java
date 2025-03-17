package designpatterns.composite;

import java.util.Date;

public abstract class FileSystemComponent {

    private String name;
    private boolean isDeleted;
    private Date lastModified;

    public FileSystemComponent(String name){
        lastModified = new Date();
        this.name = name;
        isDeleted = false;
    }


    public abstract void ls();
    public abstract void delete();
    public abstract void restore();
    public abstract void update(String content);
    public abstract void rename(String name);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }


}
