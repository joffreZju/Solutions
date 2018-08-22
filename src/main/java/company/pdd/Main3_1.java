package company.pdd;

import java.util.Scanner;

public class Main3_1 {
	public static void main(String[] args) {
		//		Scanner in = new Scanner("5 0\n" +
		//				                         "1 2 3\n" +
		//				                         "0 4\n" +
		//				                         "0 4\n" +
		//				                         "0 4\n" +
		//				                         "1 2 3\n");
		Scanner in = new Scanner(System.in);
		String[] row = in.nextLine().split(" ");
		int N = Integer.parseInt(row[0]), k = Integer.parseInt(row[1]);
		if (N <= 1) {
			System.out.println(-1);
			return;
		}
		
		long graph[][] = new long[N][2];
		
		for (int i = 0; i < N; i++) {
			for (String s : in.nextLine().split(" ")) {
				int friend = Integer.parseInt(s);
				graph[i][friend / 60] |= (1 << (friend % 60));
			}
		}
		
		int max = 0, cur, resIndex = -1;
		for (int i = 0; i < N; i++) {
			if (i == k || (graph[i][k / 60] & (1 << (k % 60))) > 0) continue;
			cur = countOne(graph[i][0] & graph[k][0]) + countOne(graph[i][1] & graph[k][1]);
			if (cur > max) {
				max = cur;
				resIndex = i;
			}
		}
		System.out.println(resIndex);
	}
	
	private static int countOne(long n) {
		int sum = 0;
		while (n != 0) {
			sum++;
			n &= (n - 1);
		}
		return sum;
	}
}
