package inplace;

public class FindDuplicate {

    public static int findDuplicate(int[] array){
        int tortoise = array[0];
        int hare = array[0];

        do{
            tortoise = array[tortoise];
            hare = array[array[hare]];
        }
        while (tortoise != hare);

        tortoise = array[0];
        while (tortoise != hare){
            tortoise = array[tortoise];
            hare = array[hare];
        }
        return hare;
    }

    public static void main(String[] args) {
        System.out.println(findDuplicate(new int[]{1,3,4,2,2}));
    }
}
