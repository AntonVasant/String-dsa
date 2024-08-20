package LLD.pharmacy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Service {
    private Repository repository;
    private Scanner scanner;

    public Service(Repository repository,Scanner scanner) {
        this.repository = repository;
        this.scanner = scanner;
    }
    private static int idGen =  1;
    private static int medicineIdEnd = 1;
    public int addBranch(Pharmacy pharmacy){
        pharmacy.setPharmacyId(idGen++);
        repository.savePharmacy(pharmacy);
        return pharmacy.getPharmacyId();
    }

    public boolean addStockToPharmacy(Medicine medicine,int pharmacyId,int count){
        Pharmacy pharmacy = repository.findPharmacyById(pharmacyId);
        if (pharmacy == null) return false;
        medicine.setId(medicineIdEnd++);
        Stock stock = new Stock(medicine,count);
        pharmacy.getStocks().add(stock);
        return true;
    }

    public void addCustomer(Customer customer){
        repository.addCustomer(customer);
    }

    public void puchaseMed(String medName, int cusId, int quantity, int branchId) {
        if (!repository.customerExist(cusId)) {
            System.out.println("Customer not exist");
            return;
        }
        if (!repository.branchExist(branchId)) {
            System.out.println("Branch not exist");
            return;
        }
        Pharmacy pharmacy = repository.findPharmacyById(branchId);
        List<Purchase> purchases = handlePurchase(pharmacy,medName,quantity);
        printPurchase(purchases);
    }

    private void printPurchase(List<Purchase> purchases){
        System.out.println("----------------------------------------------------------------------------");
        String format = "%s-15%s-15%s-15%d-15%d-15";
        System.out.printf(format,"Med Name","Branch","Quantity","Amount");
        System.out.println();
        System.out.println("----------------------------------------------------------------------------");
        for (Purchase purchase : purchases){
            System.out.printf(format,purchase.getMedName(),purchase.getMedName(),purchase.getQuantity(),purchase.getCost());
            System.out.println();
        }
    }

    private List<Purchase> handlePurchase(Pharmacy pharmacy,String medName,int count){
        List<Purchase> list = new ArrayList<>();
        Medicine medicine = pharmacy.getMedicineByname(medName);
        double amount = count* medicine.getPrice();
        Purchase purchase = new Purchase(count,amount,medName);
        list.add(purchase);
        boolean flag = true;
        while (flag){
            System.out.println("you want to continue ? yes/no");
            String ans = scanner.next();
            if (ans.equalsIgnoreCase("no"))
                flag = false;
            else {
                System.out.println("Enter med name");
                String name = scanner.next();
                System.out.println("Enter count");
                int quantity = scanner.nextInt();
                if (pharmacy.isStockAvailable(name,quantity)){
                    Medicine medicine1 = pharmacy.getMedicineByname(name);
                    double cost = quantity*medicine1.getPrice();
                    Purchase purchase1 = new Purchase(quantity,cost,name);
                    list.add(purchase1);
                }
                else findOther(name,quantity);
            }
        }
        return list;
    }

    private void findOther(String medname,int count){
        List<Pharmacy> pharmacies = repository.getPharmacies();
        for (Pharmacy pharmacy : pharmacies){
            if (pharmacy.isStockAvailable(medname,count)){
                System.out.println("Available in branch "+pharmacy.getBranch());
                return;
            }
        }
        System.out.println("Not available");
    }
}

