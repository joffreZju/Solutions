package leetcode.round_1.problem201;

import java.util.Stack;

/**
 * 227. Basic Calculator II
 */
public class Solution227 {
    // Solution1
    // public int calculate(String s) {
    //     if (s == null || s.length() == 0) return 0;
    //     s = s.trim().replaceAll(" +", "");
    //     int res = 0;
    //     int preVal = 0;
    //     int i = 0;
    //     char sign = '+';
    //     while (i < s.length()) {
    //         int curVal = 0;
    //         while (i < s.length() && Character.isDigit(s.charAt(i))) {
    //             curVal = curVal * 10 + s.charAt(i) - '0';
    //             i++;
    //         }
    //         if (sign == '+') {
    //             res += preVal;
    //             preVal = curVal;
    //         } else if (sign == '-') {
    //             res += preVal;
    //             preVal = -curVal;
    //         } else if (sign == '*') {
    //             preVal = preVal * curVal;
    //         } else if (sign == '/') {
    //             preVal = preVal / curVal;
    //         }
    //         if (i < s.length()) {
    //             sign = s.charAt(i);
    //             i++;
    //         }
    //     }
    //     res += preVal;
    //     return res;
    // }


    // Solution2
    private static Stack<Long> nums;
    private static Stack<Character> ops;

    public static int calculate(String s) {
        nums = new Stack<>();
        ops = new Stack<>();
        int preIdx = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') continue;
            if (c < '0' || c > '9') {
                nums.push(Long.parseLong(s.substring(preIdx, i).trim()));
                preIdx = i + 1;
                while (!ops.isEmpty() && getPriority(c) <= getPriority(ops.peek())) calculate();
                ops.push(c);
            }
        }
        nums.push(Long.parseLong(s.substring(preIdx, s.length()).trim()));
        while (!ops.isEmpty()) calculate();
        return (int) (long) nums.peek();
    }

    private static void calculate() {
        char op = ops.pop();
        long num2 = nums.pop(), num1 = nums.pop();
        switch (op) {
            case '-':
                nums.push(num1 - num2);
                break;
            case '+':
                nums.push(num1 + num2);
                break;
            case '*':
                nums.push(num1 * num2);
                break;
            case '/':
                nums.push(num1 / num2);
        }
    }

    private static int getPriority(char op) {
        if (op == '-' || op == '+') return 1;
        else return 2;
    }


    public static void main(String[] args) {
        System.out.println(calculate("3+2*2"));
        System.out.println(calculate("3/2 + 1 - 5 / 2"));
        System.out.println(calculate("3+5/2"));
        System.out.println(calculate("1*2-3/4+5*6-7*8+9/10"));
    }
}
