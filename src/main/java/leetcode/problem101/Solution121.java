package leetcode.problem101;

/**
 * Created by joffre on 2017/11/25.
 * 121. Best Time to Buy and Sell Stock
 */
public class Solution121 {
    /**
     * https://discuss.leetcode.com/topic/4766/a-clean-dp-solution-which-generalizes-to-k-transactions
     */
    public static int maxProfitDP(int[] prices) {
        if (prices.length <= 1) return 0;
        int N = prices.length, K = 1;
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

    public static int maxProfit(int[] prices) {
        int maxProfit = 0, maxCur = 0;
        for (int i = 1; i < prices.length; i++) {
            maxCur += prices[i] - prices[i - 1];
            if (maxCur < 0) maxCur = 0;
            maxProfit = Math.max(maxProfit, maxCur);
        }
        return maxProfit;
    }

    public static int maxProfitAnother(int[] prices) {
        int minDay = Integer.MAX_VALUE, maxProfit = 0;
        for (int p : prices) {
            minDay = Math.min(minDay, p);
            maxProfit = Math.max(maxProfit, p - minDay);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(maxProfit(new int[]{7, 6, 4, 3, 1}));

        System.out.println(maxProfitAnother(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(maxProfitAnother(new int[]{7, 6, 4, 3, 1}));

        System.out.println(maxProfitDP(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(maxProfitDP(new int[]{7, 6, 4, 3, 1}));
    }
}
