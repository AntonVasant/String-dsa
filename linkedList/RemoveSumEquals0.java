package linkedList;

public class RemoveSumEquals0 {
    /*

Definition for singly-linked list.

public class ListNode {

    int val;

    ListNode next;

    ListNode(){}

    ListNode(int val){

        this.val = val;
    }

    ListNode(int val , ListNode next){

        this.val = val;

        this.next = next;
    }
}

*/

    class Solution {

        public ListNode depth_first_search(ListNode head_node){

            if(head_node == null){
                return head_node;
            }

            int sum_value = 0;

            for(ListNode node = head_node ; (node != null) ; node = node.next){

                sum_value += node.val;

                if(sum_value == 0){
                    head_node = node.next;
                }
            }

            if(head_node != null){
                head_node.next = depth_first_search(head_node.next);
            }

            return head_node;
        }

        public ListNode removeZeroSumSublists(ListNode head_node){

            return depth_first_search(head_node);
        }
    }
}
