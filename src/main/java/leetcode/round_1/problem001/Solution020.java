package leetcode.round_1.problem001;

import java.util.*;

/**
 * Created by joffre on 2017/9/17.
 * 20. Valid Parentheses
 */
public class Solution020 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (map.containsKey(cur)) {
                stack.push(cur);
            } else {
                if (stack.empty() || map.get(stack.pop()) != cur)
                    return false;
            }
        }
        if (!stack.empty()) {
            return false;
        }
        return true;
    }


    public static void main(String[] args) {
        Solution020 solution020 = new Solution020();
        System.out.println(solution020.isValid("["));
        System.out.println(solution020.isValid("[)"));
        System.out.println(solution020.isValid("()"));
        System.out.println(solution020.isValid("{()}"));
        System.out.println(solution020.isValid("{}()[]"));
    }
}
