package LLD.pharmacy;

public class Purchase {
    private int id;
    private String medName;
    private int quantity;
    private double cost;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getMedName() {
        return medName;
    }

    public void setMedName(String medName) {
        this.medName = medName;
    }

    public Purchase(int quantity, double cost, String medName) {
        this.medName = medName;
        this.quantity = quantity;
        this.cost = cost;
    }
}
