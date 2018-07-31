package company.huawei;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main2 {
	public static void main(String[] args) {
		Scanner in = new Scanner("1.5*2");
		StringBuilder sb = new StringBuilder(in.nextLine());
		Set<Character> set = new HashSet<>(Arrays.asList('+', '-', '*', '/'));
		char op = ' ';
		int i;
		for (i = 1; i < sb.length(); i++) {
			if (set.contains(sb.charAt(i))) {
				op = sb.charAt(i);
				break;
			}
		}
		Double first = Double.parseDouble(sb.substring(0, i)),
				second = Double.parseDouble(sb.substring(i + 1, sb.length()));
		double res = 0;
		switch (op) {
			case '+':
				res = first + second;
				break;
			case '-':
				res = first - second;
				break;
			case '*':
				res = first * second;
				break;
			case '/':
				res = first / second;
		}
		StringBuilder str = new StringBuilder(String.valueOf(res));
		int dot = str.indexOf(".");
		if (dot == -1) {
			System.out.println(res);
		} else {
			for (i = str.length() - 1; i > dot; i--) {
				if (str.charAt(i) == '0') {
					str.deleteCharAt(i);
				}
			}
			if (str.charAt(dot) == '.') str.deleteCharAt(dot);
			System.out.println(str);
		}
	}
}
