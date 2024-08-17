package linkedList;

import javax.management.StringValueExp;

public class DoubleNumber {
    public ListNode doubleIt(ListNode head) {
       StringBuilder sb = new StringBuilder();
        if (head == null || head.val == 0) return head;
        while (head != null){
           sb.append(head.val);
            head = head.next;
        }

        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        String str = doubleStr(sb.toString());
        for (int i = 0; i < str.length(); i++){
            ListNode node = new ListNode(Integer.parseInt(String.valueOf(str.charAt(i))));
            current.next = node;
            current = current.next;
        }
        return dummy.next;
    }


    private String doubleStr(String s){
        StringBuilder sb = new StringBuilder();
        int i = s.length()-1;
        int carry  =0;
        int n = 0;
        while (i >= 0){
            n = Integer.parseInt(String.valueOf(s.charAt(i)));
            n += n;
            n += carry;
            carry = n/10;
            sb.append(n%10);
            i--;
        }
        if (carry > 0)
            sb.append(carry);
        return sb.reverse().toString();
    }
}
