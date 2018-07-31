package company.huawei;

import java.util.Scanner;

public class Main3 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		String[] strs = input.split(" +");
		int[] prices = new int[strs.length];
		for (int i = 0; i < strs.length; i++) {
			int index1 = strs[i].indexOf('Y');
			int index2 = strs[i].indexOf('S');
			if (index1 != -1) {
				prices[i] = Integer.valueOf(strs[i].substring(0, index1));
			} else if (index2 != -1) {
				prices[i] = Integer.valueOf(strs[i].substring(0, index2)) * 7;
			}
		}
		int n = prices.length;
		int sum = 0;
		int prev = prices[0];
		for (int i = 1; i < n; i++) {
			if (prices[i] < prices[i - 1]) {
				sum += prices[i - 1] - prev;
				prev = prices[i];
			}
		}
		if (prices[n - 1] > prev) {
			sum += prices[n - 1] - prev;
		}
		System.out.println(sum);
	}
}
