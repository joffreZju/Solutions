package leetcode.problem101;

/**
 * Created by joffre on 2017/11/25.
 * 121. Best Time to Buy and Sell Stock
 */
public class Solution121 {
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
    }
}
