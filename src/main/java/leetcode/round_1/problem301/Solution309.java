package leetcode.round_1.problem301;

/**
 * Created by joffre on 2017/11/27.
 * 309. Best Time to Buy and Sell Stock with Cooldown
 */
public class Solution309 {
    /**
     * https://discuss.leetcode.com/topic/30431/easiest-java-solution-with-explanations
     */
    public static int maxProfitDP(int[] prices) {
        if (prices.length <= 1) return 0;
        int N = prices.length;
        int[] buy = new int[N], sell = new int[N];
        buy[0] = 0 - prices[0];
        sell[0] = 0;
        buy[1] = Math.max(buy[0], 0 - prices[1]);
        sell[1] = Math.max(sell[0], buy[0] + prices[1]);
        for (int i = 2; i < N; i++) {
            buy[i] = Math.max(buy[i - 1], sell[i - 2] - prices[i]);
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
        }
        return sell[N - 1];
    }

    public static void main(String[] args) {
        System.out.println(maxProfitDP(new int[]{1, 2, 3, 0, 2}));
    }
}
