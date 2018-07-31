package leetcode.round_1.problem201;

import java.util.LinkedList;

public class MyStack {
    private static LinkedList<Integer> queue;

    /**
     * Initialize your data structure here.
     */
    public MyStack() {
        queue = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        queue.offer(x);
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        for (int i = 0; i < queue.size() - 1; i++) {
            queue.offer(queue.poll());
        }
        return queue.poll();
    }

    /**
     * Get the top element.
     */
    public int top() {
        for (int i = 0; i < queue.size() - 1; i++) {
            queue.offer(queue.poll());
        }
        int top = queue.poll();
        queue.offer(top);
        return top;
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return queue.size() == 0;
    }
}
