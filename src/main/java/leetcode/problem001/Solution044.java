package leetcode.problem001;

public class Solution044 {
    public static boolean isMatch(String s, String p) {
        int sl = s.length(), pl = p.length();
        //dp[i][j]表示s[0 ~ i-1]和p[0 ~ j-1]是否匹配。i和j分别表示s和p中参与匹配的字符个数。
        boolean[][] dp = new boolean[sl + 1][pl + 1];
        dp[0][0] = true;

        //检测 p 的所有前缀是否可以匹配空串
        for (int i = 0; i < pl; i++) {
            if (p.charAt(i) == '*' && dp[0][i]) dp[0][i + 1] = true;
        }

        for (int i = 0; i < sl; i++) {
            for (int j = 0; j < pl; j++) {
                if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') dp[i + 1][j + 1] = dp[i][j];
                if (p.charAt(j) == '*') {
                    // 只要下面三个任意一个为 true, dp[i + 1][j + 1] = true;
                    // 策略如下:
                    // dp[ i ][ j ]: 当前 * 第一次使用，前面没有参与过匹配
                    // dp[i][j + 1]: 当前 * 在前面已经参与过匹配，这里继续匹配
                    // dp[i + 1][j]: 当前 * 将被忽略掉
                    dp[i + 1][j + 1] = dp[i][j] || dp[i][j + 1] || dp[i + 1][j];
                }
            }
        }
        return dp[sl][pl];
    }


    public static void main(String[] args) {
        System.out.println(isMatch("a", "a*"));
    }
}

