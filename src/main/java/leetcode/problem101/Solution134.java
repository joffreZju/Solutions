package leetcode.problem101;

import java.util.Arrays;

/**
 * 134. Gas Station
 */
public class Solution134 {
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        // if (Arrays.stream(gas).sum() - Arrays.stream(cost).sum() < 0) return -1;
        // 如果 total > 0 那么一定有解。证明？？
        int total = 0;
        for (int i = 0; i < gas.length; i++) {
            total += gas[i] - cost[i];
        }
        if (total < 0) return -1;

        // sum < 0 时，说明上一个 start 开始不能到 i ,将start换为 i+1，可以累积
        int sum = 0, start = 0;
        for (int i = 0; i < gas.length; i++) {
            sum += gas[i] - cost[i];
            if (sum < 0) {
                start = i + 1;
                sum = 0;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        System.out.println(canCompleteCircuit(new int[]{5}, new int[]{4}));
        System.out.println(canCompleteCircuit(new int[]{4}, new int[]{5}));
        System.out.println(canCompleteCircuit(new int[]{383, 521, 491, 907, 871, 705}, new int[]{96, 197, 592, 67, 77, 641}));
    }
}
