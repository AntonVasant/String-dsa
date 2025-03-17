package LLD.tax;

public interface TaxStrategy {

    double calculate(double income, double houseRent, double travel,double investment,double pension);

     default int getAmount(int num){
         System.out.println("default");
        return num;
    }
}
