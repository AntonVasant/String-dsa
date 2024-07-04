package linkedList;

public class SortList {
    public static Node sorting(Node head){
        if (head == null || head.next == null) return head;
        Node left = head;
        Node middle = findMiddle(head);
        Node temp = middle.next;
        middle.next = null;

        Node list1 = sorting(left);
        Node list2 = sorting(temp);

        return merge(list1,list2);
    }

    private static Node merge(Node list1,Node list2){
        Node dummy = new Node(-1);
        Node tail = dummy;
        while (list1 != null && list2 != null){
            if (list1.value <= list2.value){
                tail.next = list1;
                list1 = list2.next;
            }else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }
        if (list1 != null) tail.next = list1;
        if (list2 != null) tail.next = list2;
        return dummy.next;
    }

    private static Node findMiddle(Node head){
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
