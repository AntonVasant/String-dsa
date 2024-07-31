package linkedList;

public class Main {
    public static void main(String[] a){
        LinkedList linkedList = new LinkedList();
        linkedList.create(5);
        linkedList.create(3);
       Node head =  linkedList.create(4);
        DoubleNumber d = new DoubleNumber();
        d.doubleIt(head);
    }
}
