package leetcode.round_1.problem701;

/**
 * 746. Min Cost Climbing Stairs
 */
public class Solution746 {
    public static int minCostClimbingStairs(int[] cost) {
        // minCost[i]表示爬到第i各台阶的最小花费
        int[] minCost = new int[cost.length + 1];
        minCost[0] = cost[0];
        minCost[1] = cost[1];
        for (int i = 2; i <= cost.length; i++) {
            int cur = i == cost.length ? 0 : cost[i];
            minCost[i] = Math.min(cur + minCost[i - 1], cur + minCost[i - 2]);
        }
        return minCost[minCost.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(minCostClimbingStairs(new int[]{10, 15, 20}));
        System.out.println(minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
    }
}
