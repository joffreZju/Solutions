package leetcode.round_1.problem101;

import java.util.Stack;

/**
 * 150. Evaluate Reverse Polish Notation
 */
public class Solution150 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            switch (token) {
                case "+":
                    int num2 = stack.pop();
                    stack.push(stack.pop() + num2);
                    break;
                case "-":
                    num2 = stack.pop();
                    stack.push(stack.pop() - num2);
                    break;
                case "*":
                    num2 = stack.pop();
                    stack.push(stack.pop() * num2);
                    break;
                case "/":
                    num2 = stack.pop();
                    stack.push(stack.pop() / num2);
                    break;
                default:
                    stack.push(Integer.parseInt(token));
            }
        }
        return stack.peek();
    }
}
