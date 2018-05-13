package company.netEase;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {
	static class Rect {
		int startX, startY, endX, endY;
		int count = 0;

		public Rect(int startX, int startY, int endX, int endY, int count) {
			this.startX = startX;
			this.startY = startY;
			this.endX = endX;
			this.endY = endY;
			this.count = count;
		}

		public Rect getOverlap(Rect rect) {
			int nStartX = Math.max(startX, rect.startX), nEndX = Math.min(endX, rect.endX);
			int nStartY = Math.max(startY, rect.startY), nEndY = Math.min(endY, rect.endY);
			if (nStartX >= nEndX || nStartY >= nEndY)
				return null;
			else
				return new Rect(nStartX, nStartY, nEndX, nEndY, 0);
		}
	}
	// 矩形重叠
	// 暴力：90%
	public static void main(String[] args) {
		// Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner("2\n" +
				"0 100\n" +
				"0 100\n" +
				"100 200\n" +
				"100 200\n");//这个用例没有过

		int n = sc.nextInt();
		int[][] rec = new int[n][4];
		List<Rect> rectA = new ArrayList<>(), rectB = new ArrayList<>();
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < n; j++) {
				rec[j][i] = sc.nextInt();
			}
		}

		for (int i = 0; i < n; i++) {
			rectA.add(new Rect(rec[i][0], rec[i][1], rec[i][2], rec[i][3], 0));
		}

		int max = 0;
		for (int i = 0; i < n; i++) {
			Rect cur = rectA.get(i);
			int count = rectB.size();
			for (int j = 0; j < count; j++) {
				Rect next = cur.getOverlap(rectB.get(j));
				if (next != null) {
					next.count = rectB.get(j).count + 1;
					max = Math.max(next.count, max);
					rectB.add(next);
				}
			}
			for (int j = i + 1; j < n; j++) {
				Rect next = cur.getOverlap(rectA.get(j));
				if (next != null) {
					next.count = 1;
					rectB.add(next);
					max = Math.max(next.count, max);
				}
			}
		}
		System.out.println(max);
	}
}