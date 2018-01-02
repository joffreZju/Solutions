package leetcode.problem101;

/**
 * Created by joffre on 2017/11/27.
 * 122. Best Time to Buy and Sell Stock II
 */
public class Solution122 {
    /**
     * https://discuss.leetcode.com/topic/4766/a-clean-dp-solution-which-generalizes-to-k-transactions
     * Time limit exceeded
     */
    public static int maxProfitDPTLE(int[] prices) {
        if (prices.length <= 1) return 0;
        int N = prices.length, K = N / 2;
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

    /**
     * https://discuss.leetcode.com/topic/30431/easiest-java-solution-with-explanations
     */
    public static int maxProfitDP(int[] prices) {
        if (prices.length <= 1) return 0;
        int N = prices.length;
        int[] buy = new int[N], sell = new int[N];
        buy[0] = 0 - prices[0];
        sell[0] = 0;
        for (int i = 1; i < N; i++) {
            buy[i] = Math.max(buy[i - 1], sell[i - 1] - prices[i]);
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
        }
        return sell[N - 1];
    }

    /**
     * 思路：只要当前价格比前一天的股价高，就假设前一天已买股票，然后今天售出，然后将差价累加到sum。
     */
    public int maxProfit(int[] prices) {
        int sum = 0;
        for (int i = 1; i < prices.length; i++)
            sum += Math.max(0, prices[i] - prices[i - 1]);
        return sum;
    }
}
