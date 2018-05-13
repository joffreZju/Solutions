package toutiao;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main4 {
	public static void main(String[] args) {
		Scanner in = new Scanner("1\n" +
				                         "3 1 2 3 5\n");
		int N = Integer.valueOf(in.nextLine());
		for (int i = 0; i < N; i++) {
			String[] line = in.nextLine().split(" ");
			int k = Integer.valueOf(line[0]);
			int[] nums = new int[line.length - 1];
			for (int j = 0; j < line.length - 1; j++) {
				nums[j] = Integer.valueOf(line[j + 1]);
			}
			PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> nums[a[0]] * nums[b[1]] - nums[a[1]] * nums[b[0]]);
			int[][] used = new int[nums.length][nums.length];
			
			queue.add(new int[]{0, nums.length - 1});
			while (k > 0) {
				int[] cur = queue.poll();
				k--;
				if (k == 0) {
					System.out.println(nums[cur[0]] + " " + nums[cur[1]]);
					break;
				}
				if (used[cur[0] + 1][cur[1]] == 0) {
					used[cur[0] + 1][cur[1]] = 1;
					queue.offer(new int[]{cur[0] + 1, cur[1]});
				}
				if (used[cur[0]][cur[1] - 1] == 0) {
					used[cur[0]][cur[1] - 1] = 1;
					queue.offer(new int[]{cur[0], cur[1] - 1});
				}
			}
		}
	}
}
