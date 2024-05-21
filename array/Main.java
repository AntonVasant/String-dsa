package array;

import string.CheckPangram;

public class Main {
    public static void main(String a[]) {
        int[] array = {5,7,2,1,8};
        ProductOfTop3 p = new ProductOfTop3();
        System.out.println(p.product(array));
    }
}