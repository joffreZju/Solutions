package leetcode.round_1.problem601;

/**
 * 647. Palindromic Substrings
 */
public class Solution647 {
	private static int count;
	
	public static int countSubstrings(String s) {
		if (s == null || s.length() == 0) return 0;
		
		count = 0;
		for (int i = 0; i < s.length(); i++) { // i is the mid point
			extendPalindrome(s, i, i); // odd length;
			extendPalindrome(s, i, i + 1); // even length
		}
		
		return count;
	}
	
	private static void extendPalindrome(String s, int left, int right) {
		while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			count++;
			left--;
			right++;
		}
	}
	
	/**
	 * Solution2:DP
	 * 从主对角线向右上角方向每次计算一个斜行，因为dp[i][j]的计算依赖dp[i+1][j-1]
	 * 上面循环解决了长度为1和2的回文串的计算，下面循环解决长度为3-len的子串。
	 * [1, 1, 1, 1, 1]
	 * [0, 1, 1, 1, 1]
	 * [0, 0, 1, 1, 1]
	 * [0, 0, 0, 1, 1]
	 * [0, 0, 0, 0, 1]
	 */
	//	public static int countSubstrings(String s) {
	//		int len = s.length(), count = len;
	//		int[][] dp = new int[len][len];
	//		for (int i = 0; i < len; i++) {
	//			if (i < len - 1 && s.charAt(i) == s.charAt(i + 1)) {
	//				dp[i][i + 1] = 1;
	//				count++;
	//			}
	//			dp[i][i] = 1;
	//		}
	//		for (int start = 2; start < len; start++) {
	//			int i = 0, j = start;
	//			while (i < len - 1 && j < len) {
	//				if (dp[i + 1][j - 1] == 1 && s.charAt(i) == s.charAt(j)) {
	//					dp[i][j] = 1;
	//					count++;
	//				}
	//				i++;
	//				j++;
	//			}
	//		}
	//		return count;
	//	}
	public static void main(String[] args) {
		System.out.println(countSubstrings("abc"));
		System.out.println(countSubstrings("aaa"));
		System.out.println(countSubstrings("aaaaa"));
	}
}
