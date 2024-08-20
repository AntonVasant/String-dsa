package LLD.pharmacy;

import java.util.*;

public class Pharmacy {

    private int pharmacyId;
    private String branch;
    private long contact;
    private List<Stock> stocks;

    public int getPharmacyId() {
        return pharmacyId;
    }

    public void setPharmacyId(int pharmacyId) {
        this.pharmacyId = pharmacyId;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public long getContact() {
        return contact;
    }

    public void setContact(long contact) {
        this.contact = contact;
    }

    public boolean isStockAvailable(String medName,int count){
        for (Stock stock : stocks){
            if (stock.getMedicine().getName().equals(medName)){
                if (stock.getQuantity() >= count) return true;
            }
        }
        return false;
    }

    public Medicine getMedicineByname(String meName){
        for (Stock stock : stocks){
            if (stock.getMedicine().getName().equals(meName))
                return stock.getMedicine();
        }
        return null;
    }

    public Pharmacy(String branch, long contact) {
        this.branch = branch;
        this.contact = contact;
        stocks = new ArrayList<>();
    }
    public List<Stock> getStocks(){
        return stocks;
    }
}
