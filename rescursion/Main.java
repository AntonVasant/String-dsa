package rescursion;

public class Main {
    public static void main(String a[]) {
        int[] arr = {4,3,2,3,5,2,1};
        boolean b = PartitionToKEqualSubSet.partition(arr,4);
        System.out.println(b);
    }
}
