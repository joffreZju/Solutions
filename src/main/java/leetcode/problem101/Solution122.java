package leetcode.problem101;

/**
 * Created by joffre on 2017/11/27.
 * 122. Best Time to Buy and Sell Stock II
 * 思路：只要当前价格比前一天的股价高，就假设前一天已买股票，然后今天售出，然后将差价累加到sum。
 */
public class Solution122 {
    public int maxProfit(int[] prices) {
        int sum = 0;
        for (int i = 1; i < prices.length; i++)
            sum += Math.max(0, prices[i] - prices[i - 1]);
        return sum;
    }
}
