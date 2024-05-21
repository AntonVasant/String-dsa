package array;

public class ProductOfTop3 {
    public int product(int[] array){
        int greater1=Integer.MIN_VALUE;
        int greater2=Integer.MIN_VALUE;
        int greater3=Integer.MIN_VALUE;
        int temp=0;
        for (int num : array){
            if(num>greater1){
                temp=greater1;
                greater1=num;
                greater3=greater2;
                greater2=temp;
            } else if (num>greater2 && num<greater1) {
                greater3=greater2;
                greater2=num;
            } else if (num > greater3 && (num < greater2 && num<greater1)) {
                greater3=num;
            }
        }
        return greater1*greater2*greater3;
    }
}
