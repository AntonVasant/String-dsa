package dp;

public class Main {
    public static void main(String a[]){
       int[] arr = {1,17,5,10,13,15,10,5,16,8};
       WiggleSubsequence wiggleSubsequence = new WiggleSubsequence();
        System.out.println(wiggleSubsequence.wiggleMaxLength(arr));
    }
}
