package company.ali;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Map<String, Integer> m = new HashMap<>();
		m.put("NORTH", 0);
		m.put("EAST", 1);
		m.put("SOUTH", 2);
		m.put("WEST", 3);
		Scanner in = new Scanner("0 0 NORTH\n" +
				                         "0 2 SOUTH\n" +
				                         "2 3\n" +
				                         "0 1 0\n" +
				                         "0 0 0\n");
		int x0 = in.nextInt(), y0 = in.nextInt(), f0 = m.get(in.next());
		int x1 = in.nextInt(), y1 = in.nextInt(), f1 = m.get(in.next());
		int r = in.nextInt(), c = in.nextInt();
		int map[][] = new int[r][c];
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				map[i][j] = in.nextInt();
			}
		}
		int dp[][][] = new int[r][c][4];
		dp[x0][y0][f0] = 1;
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[]{x0, y0, f0});
		while (!queue.isEmpty()) {
			int tmp[] = queue.poll(), x = tmp[0], y = tmp[1], f = tmp[2], cur = dp[x][y][f];
			if (x == x1 && y == y1 && f == f1) {
				System.out.println(cur - 1);
				return;
			}
			if (dp[x][y][(f + 1) % 4] == 0) {
				dp[x][y][(f + 1) % 4] = cur + 1;
				queue.offer(new int[]{x, y, (f + 1) % 4});
			}
			if (dp[x][y][(f + 3) % 4] == 0) {
				dp[x][y][(f + 3) % 4] = cur + 1;
				queue.offer(new int[]{x, y, (f + 3) % 4});
			}
			boolean forward = false;
			if (f == 0 && x - 1 >= 0 && map[x - 1][y] == 0 && dp[x - 1][y][f] == 0) {
				x--;
				forward = true;
			} else if (f == 1 && y + 1 < c && map[x][y + 1] == 0 && dp[x][y + 1][f] == 0) {
				y++;
				forward = true;
			} else if (f == 2 && x + 1 < r && map[x + 1][y] == 0 && dp[x + 1][y][f] == 0) {
				x++;
				forward = true;
			} else if (f == 3 && y - 1 >= 0 && map[x][y - 1] == 0 && dp[x][y - 1][f] == 0) {
				y--;
				forward = true;
			}
			if (forward) {
				dp[x][y][f] = cur + 1;
				queue.offer(new int[]{x, y, f});
			}
		}
		System.out.println(65535);
	}
}
