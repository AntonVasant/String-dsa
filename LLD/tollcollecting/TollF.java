package LLD.tollcollecting;

public class TollF extends Toll{
    public TollF(char location, int tollId) {
        super(location, tollId);
    }

    @Override
    double calculateToll(String vehicle) {
        switch (vehicle){
            case "two wheeler" -> {
                return 20;
            }
            case "truck" -> {
                return 135;
            }
            case "family van" -> {
                return 200;
            }
            case "Jeep" -> {
                return 80;
            }
        }
        return 0;
    }
}
