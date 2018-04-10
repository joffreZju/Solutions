package leetcode.problem201;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class MyQueue {
    private static LinkedList<Integer> in, out;

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
        in = new LinkedList<>();
        out = new LinkedList<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        in.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        if (out.size() == 0) {
            while (in.size() > 0) {
                out.push(in.pop());
            }
        }
        return out.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        if (out.size() == 0) {
            while (in.size() > 0) {
                out.push(in.pop());
            }
        }
        return out.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return in.size() == 0 && out.size() == 0;
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        System.out.println(queue.peek());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.empty());

        Queue<Integer> qq = new LinkedList<>();

    }
}
