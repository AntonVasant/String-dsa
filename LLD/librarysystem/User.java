package LLD.librarysystem;

public class User {

    private String name;
    private int id;
    private int contact;


    public User(String name,int contact){
        this.name= name;
        this.contact = contact;
    }

    public String getName() {
        return name;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getContact(){
        return contact;
    }

    public int getId(){
        return id;
    }
}
