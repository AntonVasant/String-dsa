package linkedList;

import java.util.ArrayList;
import java.util.List;

public class Leader {
    public ListNode removeNodes(ListNode head) {
        List<Integer> list1 = new ArrayList<>();
        while (head != null){
            list1.add(head.val);
            head = head.next;
        }
        int n = list1.size()-1;
        int max = Integer.MIN_VALUE;
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        for (int i = n; i >= 0; i--){
            if (list1.get(i) >= max){
                max = list1.get(i);
                ListNode cur = new ListNode(max);
                current.next = cur;
                current = current.next;
            }
        }
        return reverse(dummy.next);
    }

    private ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode current = head;
        while (current != null){
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}
