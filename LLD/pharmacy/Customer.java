package LLD.pharmacy;

public class Customer {
    private int id;
    private String name;
    private long contact;
    private String address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getContact() {
        return contact;
    }

    public void setContact(long contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Customer(int id, String name, long contact, String address) {
        this.id = id;
        this.name = name;
        this.contact = contact;
        this.address = address;
    }
}
