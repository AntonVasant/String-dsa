package stack;

import java.util.Stack;

class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    public void pop() {
        if (!stack.isEmpty()) {
            int removed = stack.pop();
            if (removed == minStack.peek()) {
                minStack.pop();
            }
        }
    }

    public int top() {
        if (stack.isEmpty()) return -1;
        return stack.peek();
    }

    public int getMin() {
        if (minStack.isEmpty()) return -1;
        return minStack.peek();
    }
}
