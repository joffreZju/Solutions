package leetcode.problem001;

/**
 * Created by joffre on 2017/10/19.
 * 70. Climbing Stairs
 * 到达第i个台阶的方法等于到达i-1和i-2的相加，所以只需要长度为三的dp数组即可。
 */
public class Solution070 {
    public static int climbStairs(int n) {
        int[] dp = new int[]{0, 1, 2};
        for (int i = 3; i <= n; i++) {
            dp[i % 3] = dp[(i - 1) % 3] + dp[(i - 2) % 3];
        }
        return dp[n % 3];
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(3));
    }
}
