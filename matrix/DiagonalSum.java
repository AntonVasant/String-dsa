package matrix;

public class DiagonalSum {
    public int sum(int[][] array){
        int len=array.length;
        int sum=0;
        for(int i=0;i<len;i++){
            sum+=array[i][i];
        }
        for (int i=0;i<len;i++){
            sum+=array[i][len-1-i];
        }
        if(len%2==1){
            sum-=array[len/2][len/2];
        }
        return sum;
    }
}
