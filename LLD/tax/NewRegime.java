package LLD.tax;

import java.util.List;

public class NewRegime implements TaxStrategy{
    @Override
    public double calculate(double income, double houseRent, double travel, double investment, double pension) {
        System.out.println("new regime");
        List<List<Integer>> taxList = TaxSystem.getTaxList();
        income = getTaxableIncome(income,houseRent,pension);
        double tax = 0;
        System.out.println("Taxable Income = "+income);
        for (List<Integer> list1 : taxList){
            if (income <= 0) break;
            int money = list1.get(0);
            int percent = list1.get(1);
            double amount = Math.min(money,income);
            tax += amount * (percent/100.0);
            income -= amount;
        }
        return tax;
    }

    private double getTaxableIncome(double income,double house,double pension){
        double hra = income/2;
        double ta = income/10;
        return income+hra+ta - (house+ pension);
    }
}
