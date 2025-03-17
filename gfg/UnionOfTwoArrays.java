package gfg;

import java.util.ArrayList;

public class UnionOfTwoArrays {
    public static ArrayList<Integer> findUnion(int a[], int b[]) {
        ArrayList<Integer> list = new ArrayList<>();
        int i = 0;
        int j = 0;
        int n = a.length;
        int m = b.length;
        while (i < n && j < m) {
            while (i > 0 && i < n && a[i] == a[i-1]) i++;
            while (j > 0 && j < m && b[j] == b[j-1]) j++;

            if (i >= n || j >= m) break;
            if (a[i] < b[j])
                list.add(a[i++]);
            else if (b[j] < a[i])
                list.add(b[j++]);
            else {
                list.add(b[j]);
                i++;
                j++;
            }
        }

        while (i > 0 && i < n){
            if (a[i] != a[i-1])
                list.add(a[i]);
            i++;
        }

        while (j > 0 && j < m){
            if (b[j] != b[j-1])
                list.add(b[j]);
            j++;
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(findUnion(new int[]{1, 2, 3, 4, 5}, new int[]{1, 2, 3, 6, 7}));
    }
}
