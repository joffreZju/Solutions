package leetcode.round_1.problem301;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 322. Coin Change
 */
public class Solution322 {
    //迭代
    public int coinChange(int[] coins, int amount) {
        int counter[] = new int[amount + 1];
        Arrays.fill(counter, Integer.MAX_VALUE - 1);
        counter[0] = 0;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                counter[j] = Math.min(counter[j], counter[j - coins[i]] + 1);
            }
        }
        return counter[amount] == Integer.MAX_VALUE - 1 ? -1 : counter[amount];
    }


    // 递归
    // public int coinChange(int[] coins, int amount) {
    //     int[] counter = new int[amount + 1];
    //     return dfs(coins, amount, counter);
    // }
    //
    // private int dfs(int[] coins, int amount, int[] counter) {
    //     if (amount < 0) return -1;
    //     else if (amount == 0) return 0;
    //     else if (counter[amount] != 0) return counter[amount];
    //
    //     int min = Integer.MAX_VALUE;
    //     for (int i = coins.length - 1; i >= 0; i--) {
    //         int ret = dfs(coins, amount - coins[i], counter);
    //         if (ret >= 0) min = Math.min(min, ret + 1);
    //     }
    //     counter[amount] = min == Integer.MAX_VALUE ? -1 : min;
    //     return counter[amount];
    // }
}
