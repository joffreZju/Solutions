package company.pdd;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main3_2 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String[] row = in.nextLine().split(" ");
		int N = Integer.parseInt(row[0]), k = Integer.parseInt(row[1]);
		if (N <= 1) {
			System.out.println(-1);
			return;
		}
		Set<Integer>[] sets = new Set[N];
		for (int i = 0; i < N; i++) {
			sets[i] = new HashSet<>();
			for (String s : in.nextLine().split(" ")) {
				sets[i].add(Integer.valueOf(s));
			}
		}
		int max = 0, cur, resIndex = -1;
		for (int i = 0; i < N; i++) {
			if (i == k || sets[i].contains(k)) continue;
			cur = 0;
			for (int tmp : sets[k]) {
				if (sets[i].contains(tmp)) cur++;
			}
			if (cur > max) {
				max = cur;
				resIndex = i;
			}
		}
		System.out.println(resIndex);
	}
}
