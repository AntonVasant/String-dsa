package LLD.foodDelivery;

public class OrderResponse {
    private int bookingId;
    private String availableExecutive;

    public String getAvailableExecutive() {
        return availableExecutive;
    }

    public OrderResponse(int id, String availableExecutive) {
        this.availableExecutive = availableExecutive;
        this.bookingId = id;
    }

    public void setAvailableExecutive(String availableExecutive) {
        this.availableExecutive = availableExecutive;
    }
}
