package LLD.pharmacy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Repository {
    private static Map<Integer,Pharmacy> pharmacyMap;
    private static Map<Integer,Customer> customerMap;
    private FieHandling fieHandling;

    public Repository(FieHandling fieHandling) {
        this.fieHandling = fieHandling;
    }

    public Repository(){

    }

    public void addCustomer(Customer customer){
        customerMap.put(customer.getId(),customer);
    }

    public void savePharmacy(Pharmacy pharmacy) {
        pharmacyMap.put(pharmacy.getPharmacyId(), pharmacy);
    }

    public Pharmacy findPharmacyById(int id){
        if (pharmacyMap.containsKey(id))
            return pharmacyMap.get(id);
        return null;
    }

    public boolean customerExist(int cusId) {
        return customerMap.containsKey(cusId);
    }
    public List<Pharmacy> getPharmacies(){
        return new ArrayList<>(pharmacyMap.values());
    }

    public boolean branchExist(int branchId) {
        return pharmacyMap.containsKey(branchId);
    }
}
