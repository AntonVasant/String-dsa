package LLD.parking;

public class Controller {
   private Service service;

    public Controller(Service service) {
        this.service = service;
    }

    public void parkVehicle(String number,VehicleType type){
        Vehicle vehicle = new Vehicle(number,type);
        try {
            Ticket ticket = service.parkVehicle(vehicle);
            System.out.println("spot booked successfully your ticket id is "+ticket.getId());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void unParkVehicle(String id){
        try{
            service.unParkVehicle(id);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
