package LLD.pharmacy;

public class Controller {
    private Service service;
    private static int idGen = 1;
    public Controller(Service service) {
        this.service = service;
    }

    public void addPharmacy(String branch,long contact){
        Pharmacy pharmacy = new Pharmacy(branch, contact);
        int n = service.addBranch(pharmacy);
        System.out.println("successfully added pharmacy id "+n);
    }

    public void addStock(String name,String brand,String alternative,double price,int count,int pharmacyId) {
        Medicine medicine = new Medicine(name, price, alternative, brand);
        boolean res = service.addStockToPharmacy(medicine, pharmacyId, count);
        if (res)
            System.out.println("SuccessFully Added");
        System.out.println("Pharmacy with the id "+pharmacyId+" not found");
    }

    public void addCustomer(String name,String address,long contact){
        Customer customer = new Customer(idGen++,name,contact,address);
        service.addCustomer(customer);
    }

    public void purchase(String medName,int cusId,int quantity,int branchId){
        service.puchaseMed(medName,cusId,quantity,branchId);
    }
}
