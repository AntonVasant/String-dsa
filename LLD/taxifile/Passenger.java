package LLD.taxifile;

import graph.SurroundedRegion;

public class Passenger {
    private String name;
    private String cardNo;
    private String routesTravelled;
    private double balance;

    public Passenger(String name, String cardNo,double balance){
        this.balance = balance;
        this.name = name;
        this.cardNo = cardNo;
    }

    public String getCardNo() {
        return cardNo;
    }

    public String getName() {
        return name;
    }

    public String getRoutesTravelled() {
        return routesTravelled;
    }

    public void setRoutesTravelled(String routesTravelled) {
        this.routesTravelled = routesTravelled;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
