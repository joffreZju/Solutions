package leetcode.round_1.problem701;

import java.util.*;

public class Solution739 {
    public static int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.empty() && temperatures[i] > temperatures[stack.peek()]) {
                int preIndex = stack.pop();
                res[preIndex] = i - preIndex;
            }
            stack.push(i);
        }
        return res;
    }

    public static int[] dailyTemperaturesAgain(int[] temperatures) {
        int[] map = new int[101], res = new int[temperatures.length];
        for (int i = temperatures.length - 1; i >= 0; i--) {
            int minIndex = Integer.MAX_VALUE;
            for (int j = temperatures[i] + 1; j < 101; j++) {
                if (map[j] != 0) {
                    minIndex = Math.min(minIndex, map[j]);
                }
            }
            if (minIndex != Integer.MAX_VALUE) res[i] = minIndex - i;
            map[temperatures[i]] = i;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));

        System.out.println(Arrays.toString(dailyTemperaturesAgain(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
    }
}
