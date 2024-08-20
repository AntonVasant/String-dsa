package stack;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {

    Queue<Integer> queue1;
    Queue<Integer> queue2;
    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(int x) {
        queue2.add(x);
        while (!queue1.isEmpty())
            queue2.add(queue1.remove());
        Queue<Integer> temp = new LinkedList<>();
        queue1 = queue2;
        queue2 = temp;
    }

    public int pop() {
        if (queue1.isEmpty())
            return -1;
        return queue1.remove();
    }

    public int top() {
        if (!queue1.isEmpty()) return queue1.peek();
        throw new IllegalArgumentException();
    }

    public boolean empty() {
        return queue1.isEmpty();
    }
}
