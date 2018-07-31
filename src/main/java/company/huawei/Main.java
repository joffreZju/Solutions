package company.huawei;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner("I am a hero");
		String s = in.nextLine();
		StringBuilder sb = new StringBuilder();
		for (String t : s.split(" ")) {
			sb.insert(0, t).insert(0, " ");
		}
		sb.deleteCharAt(0);
		System.out.println(sb.toString());
	}
}
