package linkedList;

public class LongestLinkedListPalindrome {
    public  int maxPalindrome(Node head) {
        Node cur = head;
        Node prev = null;
        int len = 0;
        while (cur != null){
            int odd = 2 * helper(prev,cur.next)+1;
            int even = 2 * helper(prev,cur);
            len = Math.max(len,Math.max(odd,even));

            Node nxt = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nxt;
        }
        return len;
    }


    private int helper(Node left,Node right){
        int count = 0;
        while (left != null && right != null && left.value == right.value){
            count++;
            left = left.next;
            right = right.next;
        }
        return count;
    }
}
