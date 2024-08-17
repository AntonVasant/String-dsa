package LLD.tax;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaxSystem {

    private TaxStrategy taxStrategy;
    private static TaxSystem instance;
    private static final FileHandling handling = FileHandling.getInstance();

    static private Map<String,User> userMap = new HashMap<>();

    static private  List<List<Integer>> taxList =handling.getDetails() ;
    public static List<List<Integer>> getTaxList(){
        return taxList;
    }
    public static TaxSystem getInstance(){
        if (instance == null)
            instance = new TaxSystem();
        return instance;
    }

    public void saveUser(String name,User user){
        userMap.put(name,user);
    }
    public User getUserByName(String name){
        if (userMap.containsKey(name))
            return userMap.get(name);
        return null;
    }

    public void decideStrategy(double house,double travel,double invest,double pension){
        if (house == 0 && travel == 0 && invest == 0 && pension == 0)
            taxStrategy = new TaxWithoutAllowance();
        else if (invest == 0 && pension == 0) {
            taxStrategy = new TaxWithAllowanceForHouseTravel();
        }
        else taxStrategy = new TaxWithAllAllowance();
    }

    public void setTaxStrategy(String str){
        if (str.equalsIgnoreCase("new"))
            taxStrategy = new NewRegime();
    }

    public  double calculateTax(double income,double house,double travel,double invest,double pension){
        decideStrategy(house, travel, invest, pension);
        return taxStrategy.calculate(income, house, travel, invest, pension);
    }
}
