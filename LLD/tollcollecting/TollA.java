package LLD.tollcollecting;
public class TollA extends Toll {


    public TollA(char location, int tollId) {
        super(location, tollId);
    }

    @Override
    double calculateToll(String vehicle) {
       switch (vehicle){
           case "two wheeler" -> {
               return 5;
           }
           case "truck" -> {
               return 10;
           }
           case "family van" -> {
               return 500;
           }
           case "Jeep" -> {
               return 50;
           }
       }
       return 0;
    }
}
