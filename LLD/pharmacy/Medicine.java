package LLD.pharmacy;

public class Medicine {
    private int id;
    private String name;
    private double price;
    private String alternative;
    private String brand;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAlternative() {
        return alternative;
    }

    public void setAlternative(String alternative) {
        this.alternative = alternative;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Medicine( String name, double price, String alternative, String brand) {
        this.name = name;
        this.price = price;
        this.alternative = alternative;
        this.brand = brand;
    }

}
