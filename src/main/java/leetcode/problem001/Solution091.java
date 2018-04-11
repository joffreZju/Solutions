package leetcode.problem001;

/**
 * 91. Decode Ways
 */
public class Solution091 {
	public static int numDecodings(String s) {
		if (s.length() == 0) return 0;
		int[] dp = new int[s.length()];
		dp[0] = s.charAt(0) == '0' ? 0 : 1;
		
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) != '0') dp[i] = dp[i - 1];
			else dp[i] = 0;
			
			int tmp = Integer.valueOf(s.substring(i - 1, i + 1));
			if (s.charAt(i - 1) != '0' && tmp <= 26 && tmp >= 1) {
				if (i - 2 < 0) dp[i] += 1;
				else dp[i] += dp[i - 2];
			}
		}
		return dp[s.length() - 1];
	}
	
	public static void main(String[] a) {
		System.out.println(numDecodings("12"));
	}
}
