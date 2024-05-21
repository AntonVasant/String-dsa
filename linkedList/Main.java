package linkedList;

public class Main {
    public static void main(String a[]){
        LinkedList l = new LinkedList();
        int[] array = {3,5,6,2,6,8};
         Node head = l.create(array);
        OddEven o = new OddEven();
        o.oddEven(head);
    }
}
