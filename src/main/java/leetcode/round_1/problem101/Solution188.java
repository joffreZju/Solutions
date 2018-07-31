package leetcode.round_1.problem101;

/**
 * Created by joffre on 2017/11/27.
 * 188. Best Time to Buy and Sell Stock IV
 */
public class Solution188 {
    /**
     * https://discuss.leetcode.com/topic/4766/a-clean-dp-solution-which-generalizes-to-k-transactions
     * k > N / 2 时：相当于可以交易无限次，等价于problem122
     */
    public static int maxProfitDP(int k, int[] prices) {
        if (prices.length <= 1) return 0;
        int N = prices.length;
        if (k > N / 2) {
            int profit = 0;
            for (int i = 1; i < prices.length; i++) {
                profit += Math.max(0, prices[i] - prices[i - 1]);
            }
            return profit;
        }

        int[][] profit = new int[k + 1][N];
        for (int kk = 1; kk <= k; kk++) {
            int preMax = profit[kk - 1][0] - prices[0];
            for (int i = 1; i < N; i++) {
                profit[kk][i] = Math.max(profit[kk][i - 1], preMax + prices[i]);
                preMax = Math.max(preMax, profit[kk - 1][i] - prices[i]);
            }
        }
        return profit[k][N - 1];
    }

}
