package array;

public class BuySellStocks {
    public int stocks(int[]array){
        int maxProfit=0;
        int min=0;
        for(int i=0;i<array.length;i++){

            if(array[i]<min)
                min=array[i];
            else if (array[i]-min>maxProfit) {
                maxProfit=array[i]-min;
            }
        }
        return maxProfit;
    }
}
