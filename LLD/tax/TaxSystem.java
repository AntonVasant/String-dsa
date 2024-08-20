package LLD.tax;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaxSystem {
    String oldRegime = "C:\\Users\\Hp\\Desktop\\String\\LLD\\tax\\taxdetails";
    String newRegime = "C:\\Users\\Hp\\Desktop\\String\\LLD\\tax\\newregime";

    private TaxStrategy taxStrategy;
    private static TaxSystem instance;
    private static final FileHandling handling = FileHandling.getInstance();

    static private Map<String,User> userMap = new HashMap<>();

    static private  List<List<Integer>> taxList =handling.getDetails(getInstance().oldRegime) ;
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
        if (taxList.size() > 7) {
            taxStrategy = new NewRegime();
            return;
        }
        if (house == 0 && travel == 0 && invest == 0 && pension == 0)
            taxStrategy = new TaxWithoutAllowance();
        else if (invest == 0 && pension == 0) {
            taxStrategy = new TaxWithAllowanceForHouseTravel();
        }
        else taxStrategy = new TaxWithAllAllowance();
    }

    public void setTaxStrategy(String str){
        if (str.equalsIgnoreCase("new")){
            taxList = handling.getDetails(newRegime);
            taxStrategy = new NewRegime();
        }
        else taxList = handling.getDetails(oldRegime);
        taxStrategy = new OldRegime();
    }

    public  double calculateTax(double income,double house,double travel,double invest,double pension){
        decideStrategy(house, travel, invest, pension);
        return taxStrategy.calculate(income, house, travel, invest, pension);
    }
}
