package leetcode.problem301;

/**
 * 338. Counting Bits
 */
public class Solution338 {
    //Solution1
    public int[] countBits(int num) {
        int dp[] = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            dp[i] = dp[i >>> 1] + (i & 1);
        }
        return dp;
    }

    // Solution2
    // public int[] countBits(int num) {
    //     int dp[] = new int[num + 1], sum, tmp;
    //     for (int n = 0; n <= num; n++) {
    //         tmp = n;
    //         sum = 0;
    //         while (tmp != 0) {
    //             if (tmp < n) sum += dp[tmp];
    //             else sum++;
    //             tmp &= (tmp - 1);
    //         }
    //         dp[n] = sum;
    //     }
    //     return dp;
    // }
}
