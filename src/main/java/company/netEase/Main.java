package company.netEase;

import java.util.*;

public class Main {
	private static class Foo {
		int cover;
		int x1, y1, x2, y2;
		
		public Foo() {
			cover = 1;
		}
		
		public Foo(int x1, int y1, int x2, int y2, int cover) {
			this.cover = cover + 1;
			this.x1 = x1;
			this.y1 = y1;
			this.x2 = x2;
			this.y2 = y2;
		}
	}
	
	public static void main(String[] args) {
//		Scanner in = new Scanner(System.in);
		Scanner in = new Scanner("2\n" +
				                         "0 90\n" +
				                         "0 90\n" +
				                         "100 200\n" +
				                         "100 200\n");
		int n = in.nextInt();
		Foo[] list = new Foo[n];
		
		for (int i = 0; i < n; i++) {
			list[i] = new Foo();
			list[i].x1 = in.nextInt();
		}
		for (int i = 0; i < n; i++) {
			list[i].y1 = in.nextInt();
		}
		for (int i = 0; i < n; i++) {
			list[i].x2 = in.nextInt();
		}
		for (int i = 0; i < n; i++) {
			list[i].y2 = in.nextInt();
		}
		Arrays.sort(list, (a, b) -> {
			if (a.x1 == b.x1) {
				return a.y1 - b.y1;
			} else return a.x1 - b.x1;
		});
		
		Set<Foo> set = new HashSet<>();
		set.add(list[0]);
		for (int i = 1; i < n; i++) {
			for (Foo foo : set) {
				Foo cover = cover(list[i], foo);
				if (cover != null) {
					set.clear();
					set.add(cover);
				} else {
					set.add(list[i]);
				}
			}
		}
		
		int res = 1;
		for (Foo foo : set) {
			res = Math.max(foo.cover, res);
		}
		System.out.println(res);
	}
	
	private static Foo cover(Foo a, Foo b) {
		if (a.x2 > b.x1 && a.y2 > b.y1 && b.y2 > a.y2) {
			return new Foo(b.x1, b.y1, a.x2, a.y2, Math.max(a.cover, b.cover));
		} else if (b.x1 < a.x2 && b.y2 > a.y1 && b.y1 < a.y1) {
			return new Foo(b.x1, a.y1, a.x2, b.y2, Math.max(a.cover, b.cover));
		} else return null;
	}
}
