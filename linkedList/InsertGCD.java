package linkedList;

public class InsertGCD {
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode current = head;
        ListNode next = current.next;
        while (next != null){
            int gcd = gdc(current.val,next.val);
            ListNode cur = new ListNode(gcd);
            current.next = cur;
            cur.next = next;
            current = next;
            next = next.next;
        }
        return dummy.next;
    }

    private int gdc(int i,int j){
        int m = Math.min(i,j);
        for (int k = m; k >0; k--){
            if (i %k == 0 && j % k == 0) return k;
        }
        return -1;
    }
}
