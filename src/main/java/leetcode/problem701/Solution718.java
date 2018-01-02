package leetcode.problem701;

/**
 * 718. Maximum Length of Repeated Subarray
 */
public class Solution718 {
    public static int findLength(int[] A, int[] B) {
        int alen = A.length, blen = B.length, maxLen = 0;
        // dp[i][j] 表示以A[i]和B[j]结尾的最长子串（included Ai and Bj）
        int[][] dp = new int[alen][blen];
        for (int i = 0; i < alen; i++) {
            for (int j = 0; j < blen; j++) {
                if (A[i] != B[j]) dp[i][j] = 0;
                else {
                    if (i == 0 || j == 0) dp[i][j] = 1;
                    else dp[i][j] = dp[i - 1][j - 1] + 1;
                    maxLen = Math.max(maxLen, dp[i][j]);
                }
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(findLength(new int[]{1, 2, 3, 2, 1}, new int[]{3, 2, 1, 4, 7}));
    }
}
