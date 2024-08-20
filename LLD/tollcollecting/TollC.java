package LLD.tollcollecting;

public class TollC extends Toll{

    public TollC(char location, int tollId) {
        super(location, tollId);
    }

    @Override
    double calculateToll(String vehicle) {
        switch (vehicle){
            case "two wheeler" -> {
                return 80;
            }
            case "truck" -> {
                return 30;
            }
            case "family van" -> {
                return 50;
            }
            case "Jeep" -> {
                return 501;
            }
        }
        return 0;
    }
}
