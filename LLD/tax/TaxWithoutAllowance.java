package LLD.tax;

import java.util.List;

public class TaxWithoutAllowance implements TaxStrategy{
    @Override
    public double calculate(double income, double houseRent, double travel, double investment, double pension) {
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
}
