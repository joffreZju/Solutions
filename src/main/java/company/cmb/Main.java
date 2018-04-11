package company.cmb;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int m = in.nextInt();
		m = Math.abs(m);
		
		Queue<Integer> queue = new LinkedList<>();
		Set<Integer> set = new HashSet<>();
		queue.add(0);
		int res = 0;
		
		flag:
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				int pos = queue.poll();
				if (pos == m) break flag;
				
				if (pos * 2 <= m && !set.contains(pos * 2)) {
					queue.offer(pos * 2);
					set.add(pos * 2);
				}
				if (pos > m && !set.contains(pos - 1)) {
					queue.offer(pos - 1);
					set.add(pos - 1);
				}
				if (pos < m && !set.contains(pos + 1)) {
					queue.offer(pos + 1);
					set.add(pos + 1);
				}
			}
			res++;
		}
		System.out.println(res);
	}
}
