package linkedList;

public class Main {
    public static void main(String a[]){
        LinkedList l = new LinkedList();
        int[] array = {1,2,0,2,0,1};
        Node head = l.create(array);
        CheckPalnidrome p = new CheckPalnidrome();
        p.isPalindrome(head);
        System.out.println();

    }
}
