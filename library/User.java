package library;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private long id;
    public List<String> booksDetails = new ArrayList<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User(String name,long id) {
        this.name = name;
        this.id = id;
    }

    public User(String name) {
        this.name = name;
        this.id = IdGenerator.getNextId();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public  List<String> getBooksDetails() {
        return booksDetails;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
