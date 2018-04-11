package company.jd;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.next();
		int len = s.length();
		int[][] dp = new int[len][len];
		for (int j = 0; j < len; j++) {
			dp[j][j] = 1;
			for (int i = j - 1; i >= 0; i--) {
				dp[i][j] = dp[i + 1][j] + dp[i][j - 1] - dp[i + 1][j - 1];
				if (s.charAt(j) == s.charAt(i)) {
					dp[i][j] += dp[i + 1][j - 1] + 1;
				}
			}
		}
		System.out.println(dp[0][len - 1]);
	}
}
