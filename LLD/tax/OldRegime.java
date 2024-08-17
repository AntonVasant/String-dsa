package LLD.tax;

public class OldRegime implements  TaxStrategy{
    @Override
    public double calculate(double income, double houseRent, double travel, double investment, double pension) {
        return 2;
    }
}
