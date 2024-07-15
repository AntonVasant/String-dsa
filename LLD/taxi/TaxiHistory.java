package LLD.taxi;

public class TaxiHistory {
    private char start;
    private char des;
    private int totalMoney;


    public TaxiHistory(char start,char des,int totalMoney){
        this.des = des;
        this.start = start;
        this.totalMoney = totalMoney;
    }
    public char getDes() {

        return des;
    }

    public void setDes(char des) {

        this.des = des;
    }

    public char getStart() {

        return start;
    }

    public void setStart(char start)
    {
        this.start = start;
    }

    public int getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(int totalMoney) {
        this.totalMoney = totalMoney;
    }
}
