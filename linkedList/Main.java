package linkedList;

public class Main {
    public static void main(String a[]){
        LinkedList linkedList = new LinkedList();
        int[] array = {5,4,64,34,6,1};
        Node head = linkedList.arrayToList(array);
        Node sorted = SortList.sorting(head);
        System.out.println(sorted.next.value);
    }
}
