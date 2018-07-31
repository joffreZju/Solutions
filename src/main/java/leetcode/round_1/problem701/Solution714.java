package leetcode.round_1.problem701;

/**
 * Created by joffre on 2017/11/27.
 * 714. Best Time to Buy and Sell Stock with Transaction Fee
 */
public class Solution714 {
    /**
     * https://discuss.leetcode.com/topic/30431/easiest-java-solution-with-explanations
     */
    public static int maxProfitDP(int[] prices, int fee) {
        if (prices.length <= 1) return 0;
        int N = prices.length;
        int[] buy = new int[N], sell = new int[N];
        buy[0] = 0 - prices[0] - fee;
        sell[0] = 0;
        for (int i = 1; i < N; i++) {
            buy[i] = Math.max(buy[i - 1], sell[i - 1] - prices[i] - fee);
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
        }
        return sell[N - 1];
    }

    public static void main(String[] args) {
        System.out.println(maxProfitDP(new int[]{1, 3, 2, 8, 4, 9}, 2));
    }
}
