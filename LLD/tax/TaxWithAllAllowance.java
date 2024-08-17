package LLD.tax;

import java.util.List;

public class TaxWithAllAllowance implements TaxStrategy{
    @Override
    public double calculate(double income, double houseRent, double travel, double investment, double pension) {
       income = getTaxableIncome(income, houseRent, travel, investment, pension);
        List<List<Integer>> list = TaxSystem.getTaxList();
        double tax = 0;
        for (List<Integer> list1 : list){
            if (income <= 0) break;
            int money = list1.get(0);
            int percent = list1.get(1);
            double amount = Math.min(money,income);
            tax += amount * (percent/100.0);
            income -= amount;
        }
        return tax;
    }

    private double getTaxableIncome(double income,double house,double travel,double invest,double pension){
        double hra = income/2;
        double TA = income/10;
        double ans = (income + hra + TA) - (house + travel + invest + pension);
        return ans;
    }
}
