package designpatterns.composite;

import java.util.Date;

public class File extends FileSystemComponent{


    private String content;
    public File(String name, String content){
        super(name);
        this.content = content;
    }
    @Override
    public void ls() {
        System.out.println("Filename "+ getName());
    }

    @Override
    public void delete() {
        setDeleted(true);
    }

    @Override
    public void restore() {
        if (isDeleted()){
            setDeleted(false);
        }
    }

    @Override
    public void update(String content) {
        if (!isDeleted()){

            setLastModified(new Date());
        }
    }

    @Override
    public void rename(String name) {
        setName(name);
        setLastModified(new Date());
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
