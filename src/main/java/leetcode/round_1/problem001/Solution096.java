package leetcode.round_1.problem001;

/**
 * 96. Unique Binary Search Trees
 */
public class Solution096 {
    /**
     * 把1~n依次当做root
     * 当root = i时，用1 ~ i-1 构建left，用i+1 ~ n 构建right。分割成了子问题。
     */
    // 直接DP
    public static int numTreesDP(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }

    // 递归+缓存
    private static int[] cache;

    public static int numTrees(int n) {
        if (n == 1 || n == 2) return n;
        cache = new int[n];
        return recursive(n);
    }

    private static int recursive(int n) {
        if (n == 0) return 1;
        else if (n == 1 || n == 2) return n;
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (cache[i - 1] == 0) cache[i - 1] = recursive(i - 1);
            if (cache[n - i] == 0) cache[n - i] = recursive(n - i);
            sum += cache[i - 1] * cache[n - i];
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(numTrees(3));
        System.out.println(numTreesDP(3));

        System.out.println(numTrees(10));
        System.out.println(numTreesDP(10));
    }
}
