package linkedList;

public class MaxTwinSum {
    public int pairSum(ListNode head) {
        int max = 0;
        ListNode fast = head;
        ListNode slow = head;
        while (fast!= null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode secHalf = reverse(slow);
        ListNode first = head;
        while (secHalf != null){
            max = Math.max(secHalf.val+ first.val,max);
            secHalf = secHalf.next;
            first = first.next;
        }
        return max;
    }

    private ListNode reverse(ListNode head){
        ListNode cur  = head;
        ListNode prev = null;
        ListNode nxt = null;
        while (cur != null){
             nxt = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nxt;
        }
        return prev;
    }
}
