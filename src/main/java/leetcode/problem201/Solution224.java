package leetcode.problem201;

import java.util.Stack;

/**
 * 224. Basic Calculator
 */
public class Solution224 {
    public static int calculate(String s) {
        Stack<Integer> nums = new Stack<>();
        Stack<Character> ops = new Stack<>();

        for (int i = 0; i < s.length(); ) {
            if (s.charAt(i) == ' ') {
                i++;
                continue;
            } else if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                ops.push(s.charAt(i));
                i++;
                continue;
            }

            int cur = 0;
            if (s.charAt(i) == '(') {
                int count = 1;
                for (int j = i + 1; j < s.length(); j++) {
                    if (s.charAt(j) == '(') count++;
                    if (s.charAt(j) == ')') count--;
                    if (count == 0) {
                        cur = calculate(s.substring(i + 1, j));
                        i = j + 1;
                        break;
                    }
                }
            } else {
                int j = i;
                while (j < s.length() && s.charAt(j) >= '0' && s.charAt(j) <= '9') {
                    cur = cur * 10 + s.charAt(j++) - '0';
                }
                i = j;
            }

            if (nums.isEmpty() || ops.isEmpty()) nums.push(cur);
            else {
                int top = nums.pop();
                char op = ops.pop();
                if (op == '+') nums.push(top + cur);
                else nums.push(top - cur);
            }
        }
        return nums.pop();
    }

    public static void main(String[] args) {
        System.out.println(calculate("1+1"));
        System.out.println(calculate("10 +1"));
        System.out.println(calculate("4 - (1+1)"));
        System.out.println(calculate("(1+(4+5+2)-3)+(6+8)"));
    }
}
