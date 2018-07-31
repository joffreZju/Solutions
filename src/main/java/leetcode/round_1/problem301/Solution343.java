package leetcode.round_1.problem301;

/**
 * 343. Integer Break
 */
public class Solution343 {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1]; // dp[i]表示整数i分割取得的最大值。
        dp[1] = 1;
        for (int i = 2; i <= n; i++) { // 对 i 进行分割，赋值给dp[i]
            for (int j = 1; j < i; j++) { // 从 i 分割出来一个 j, 然后计算cur max，并更新dp[i]
                int cur = Math.max(dp[i - j], i - j) * j;
                dp[i] = Math.max(dp[i], cur);
            }
        }
        return dp[n];
    }
}
