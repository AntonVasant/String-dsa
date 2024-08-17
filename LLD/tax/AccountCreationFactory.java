package LLD.tax;

public class AccountCreationFactory {
    public static User createUser(String type, String name,String password){
        if (type.equalsIgnoreCase("customer"))
            return new Customer(name, password);
        else return new Admin(name, password);
    }
}
