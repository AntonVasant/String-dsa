package linkedList;

public class Main {
    public static void main(String[] a){
        LinkedList linkedList = new LinkedList();
        int[] array = {5,4,64,34,6,1};
        Node head = linkedList.arrayToList(array);
        MergeSort mergeSort = new MergeSort();
        Node sorted = mergeSort.sorting(head);
        while (sorted != null){
            System.out.println(sorted.value);
            sorted = sorted.next;
        }

    }
}
