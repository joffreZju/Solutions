package leetcode.problem701;

/**
 * 740. Delete and Earn
 */
public class Solution740 {
	public static int deleteAndEarn(int[] nums) {
		int[] counter = new int[10001];
		for (int i : nums) counter[i]++;
		
		int dp_1 = 0, dp_2 = 0, tmp;
		for (int i = 0; i < counter.length; i++) {
			tmp = dp_1;
			dp_1 = Math.max(dp_1, dp_2 + counter[i] * i);
			dp_2 = tmp;
		}
		return Math.max(dp_1, dp_2);
	}
	
	public static void main(String[] args) {
		System.out.println(deleteAndEarn(new int[]{2, 2, 3, 3, 3, 4}));
	}
}
