package LLD.librarysystem;

public class Book {

    private static int idGen = 1;

    private String author;
    private String name;
    private int id;
    private boolean isAvailable;

    public Book(String author,String name){
        this.author = author;
        this.name = name;
        this.isAvailable = true;
        this.id = idGen++;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getId() {
        return id;
    }
}
