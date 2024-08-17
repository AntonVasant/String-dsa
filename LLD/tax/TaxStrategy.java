package LLD.tax;

public interface TaxStrategy {

    double calculate(double income, double houseRent, double travel,double investment,double pension);
}
