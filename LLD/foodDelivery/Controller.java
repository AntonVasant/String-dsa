package LLD.foodDelivery;

public class Controller {

    private Service service;

    public Controller(Service service) {
        this.service = service;
    }

    public OrderResponse placeOrder(OrderPlaceRequest request){
        return service.placeOrder(request);
    }
}
