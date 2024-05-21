package array;

public class SumCloseToZero {
    public int sum(int[] array){
        int minSum=0;
        int diff=0;
        int right= array.length-1;
        int left=0;
        while (left<right){
            int sum=array[left]+array[right];
            int currentDif =Math.abs(sum);
            if (currentDif<minSum){
                minSum=sum;
                diff=currentDif;

            }
            if (sum<0)
                left++;
            else if (sum>0) {
                right--;
            }else break;
        }
        return minSum;
    }
}
