package linkedList;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NextGreater {
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        ListNode temp = head;
        while (temp != null){
            list.add(temp.val);
            temp = temp.next;
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++){
            int n = list.get(i);
            while (!stack.isEmpty() && list.get(stack.peek()) < n)
                res[stack.pop()] = n;
            stack.push(i);
        }
        return res;
    }
}
