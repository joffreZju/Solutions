package leetcode.problem101;

/**
 * Created by joffre on 2017/11/27.
 * 123. Best Time to Buy and Sell Stock III
 */
public class Solution123 {
    /**
     * https://discuss.leetcode.com/topic/4766/a-clean-dp-solution-which-generalizes-to-k-transactions
     */
    public static int maxProfitDP(int[] prices) {
        if (prices.length <= 1) return 0;
        int N = prices.length, K = 2;
        int[][] profit = new int[K + 1][N];
        for (int k = 1; k <= K; k++) {
            int preMax = profit[k - 1][0] - prices[0];
            for (int i = 1; i < N; i++) {
                profit[k][i] = Math.max(profit[k][i - 1], preMax + prices[i]);
                preMax = Math.max(preMax, profit[k - 1][i] - prices[i]);
            }
        }
        return profit[K][N - 1];
    }

}
