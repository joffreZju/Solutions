package leetcode.round_1.problem401;

import java.util.Stack;

/**
 * 402. Remove K Digits
 */
public class Solution402 {
    // 用数组模拟 stack
    public String removeKdigits(String num, int k) {
        if (num.length() == k) return "0";

        int top = -1, sum = num.length() - k;
        char stack[] = new char[sum];
        for (int i = 0; i < num.length(); i++) {
            // 当前字符比栈顶字符小，而且前面 i 个元素经过筛选后剩下 top 个，要满足 i - top <= k, 因为最多只能去掉 k 个字符。
            while (top >= 0 && num.charAt(i) < stack[top] && i - top <= k) {
                top--;
            }
            // 栈中字符不足 sum 才会 push 进去
            if (top + 1 < sum) stack[++top] = num.charAt(i);
        }

        // 抹掉 leading zeros
        int i = 0;
        while (i < sum && stack[i] == '0') i++;
        return i == sum ? "0" : new String(stack, i, sum - i);
    }

    // 用 StringBuilder 模拟栈，效率较低
    // public String removeKdigits(String num, int k) {
    //     if (num.length() == k) return "0";
    //
    //     StringBuilder sb = new StringBuilder();
    //     for (int i = 0; i < num.length(); i++) {
    //         for (int last = sb.length() - 1; last >= 0; last--) {
    //             if (num.charAt(i) < sb.charAt(last) && i - last <= k) {
    //                 sb.deleteCharAt(last);
    //             }
    //         }
    //         if (sb.length() < num.length() - k) sb.append(num.charAt(i));
    //     }
    //
    //     for (int i = 0; i < sb.length(); i++) {
    //         if (sb.charAt(i) != '0' || i == sb.length() - 1) return sb.substring(i);
    //     }
    //     return "";
    // }
}
