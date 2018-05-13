package leetcode.problem001;

/**
 * 10. Regular Expression Matching
 */
public class Solution010 {
    // Solution DP
    public boolean isMatch(String s, String p) {
        int sl = s.length(), pl = p.length();
        //dp[i][j]表示s[0 ~ i-1]和p[0 ~ j-1]是否匹配。i和j分别表示s和p中参与匹配的字符个数。
        boolean dp[][] = new boolean[sl + 1][pl + 1];
        dp[0][0] = true;

        // 检测p是否可以匹配空串
        for (int i = 1; i < pl; i++) {
            if (p.charAt(i) == '*' && dp[0][i - 1]) {
                dp[0][i + 1] = true;
            }
        }
        for (int i = 0; i < sl; i++) {
            for (int j = 0; j < pl; j++) {
                if (j > 0 && p.charAt(j) == '*') {
                    if (s.charAt(i) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
                        dp[i + 1][j + 1] =
                                dp[i + 1][j - 1] //当前x*被跳过
                                        || dp[i][j + 1];//当前x*已经参与过匹配
                    } else {
                        dp[i + 1][j + 1] = dp[i + 1][j - 1];
                    }
                }
                if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
                    dp[i + 1][j + 1] = dp[i][j];
                }
            }
        }
        return dp[sl][pl];
    }

    // Solution 递归
    // public boolean isMatch(String s, String p) {
    //     return match(s.toCharArray(), 0, p.toCharArray(), 0);
    // }

    private static boolean match(char[] str, int i, char[] pattern, int j) {
        int len1 = str.length, len2 = pattern.length;
        if (i >= len1 && j >= len2) return true;
        if (i < len1 && j >= len2) return false;

        if (j < len2 - 1 && pattern[j + 1] == '*') {//pattern的第二个字符是 *：然后对应匹配和不匹配两种情况。
            if (i < len1 && (str[i] == pattern[j] || pattern[j] == '.')) {
                //当前str和pattern位置匹配时有三种选择：
                return match(str, i, pattern, j + 2)//str不动，pattern后移一步跳过x*
                        || match(str, i + 1, pattern, j);//str后移一步，pattern不动继续使用x*
                //|| match(str, i+1, pattern, j+2);上面第二种情况的下一层递归就会覆盖这种情况，所以会导致程序更加耗时。
            } else {
                //不匹配时只有一种选择，str不动，pattern后移将x*跳过。
                return match(str, i, pattern, j + 2);
            }
        } else {//pattern的第二个字符不是*：然后对应匹配和不匹配两种情况。
            //当前位置匹配，那么同时向后移动一个位置。
            if (i < len1 && j < len2 && (pattern[j] == '.' || str[i] == pattern[j]))
                return match(str, i + 1, pattern, j + 1);
                //当前位置不匹配，返回false。
            else return false;
        }
    }
}