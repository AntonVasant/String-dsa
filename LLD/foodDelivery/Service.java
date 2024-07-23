package LLD.foodDelivery;

import java.util.List;

public class Service {

    private Repository repository;
    private static int idGen = 0;

    public Service(Repository repository) {
        this.repository = repository;
    }

    public OrderResponse placeOrder(OrderPlaceRequest request) {
        DeliveryExecutive executive = getAvailableExecutive();
        if (executive != null){
            OrderResponse response = generateResponse(request,executive.getName());
            return  response;
        }
        return null;
    }

    private OrderResponse generateResponse(OrderPlaceRequest request,String executive){
        OrderResponse response = new OrderResponse(idGen++,executive);
        return response;
    }

    private DeliveryExecutive getAvailableExecutive(){
        List<DeliveryExecutive> list = repository.getDeliveryExecutiveList();
        for (DeliveryExecutive executive : list){
            if (executive.isAvailable()){
                return  executive;
            }
        }
        return null;
    }
}
