package linkedList;

public class SwapNKNode {
    public Node swapNodes(Node head, int k) {
        Node cur = head;
        int length = 0;
        while (cur != null){
            cur = cur.next;
            length++;
        }
        Node first = head;
        Node second = head;
        for(int i = 1; i < k; i++){
            first = first.next;
        }
        for(int i = 1; i < length-k+1;i++){
            second = second.next;
        }
        int t = first.value;
        first.value = second.value;
        second.value = t;
        return head;
    }
}
