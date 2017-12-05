package leetcode.problem101;

import java.util.Arrays;
import java.util.List;

/**
 * Created by joffre on 2017/11/23.
 * 120. Triangle
 */
public class Solution120 {
    public static int minimumTotal(List<List<Integer>> triangle) {
        int len = triangle.size();
        int[] dp = new int[len + 1];
        Arrays.fill(dp, 0);
        List<Integer> tmp;
        for (int i = len - 1; i >= 0; i--) {
            tmp = triangle.get(i);
            for (int j = 0; j < tmp.size(); j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + tmp.get(j);
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        System.out.println(minimumTotal(Arrays.asList(Arrays.asList(2), Arrays.asList(3, 4), Arrays.asList(6, 5, 7), Arrays.asList(4, 1, 8, 4))));
    }
}
