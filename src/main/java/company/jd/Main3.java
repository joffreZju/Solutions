package company.jd;

import java.util.Scanner;

public class Main3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		for (int i = 0; i < t; i++) {
			char[] chars = scanner.next().toCharArray();
			if (valid(chars)) {
				System.out.println("Yes");
			} else {
				System.out.println("No");
			}
		}
	}
	
	static boolean valid(char[] chars) {
		int openCount = 0, firstRight = -1, lastLeft = -1;
		for (int i = 0; i < chars.length; i++) {
			char c = chars[i];
			if (c == '(') {
				openCount++;
				lastLeft = i;
			} else {
				openCount--;
				if (firstRight == -1) firstRight = i;
			}
		}
		if (openCount != 0) return false;
		
		chars[firstRight] = '(';
		chars[lastLeft] = ')';
		for (char c : chars) {
			if (c == '(') {
				openCount++;
			} else {
				openCount--;
			}
			if (openCount < 0) return false;
		}
		return true;
	}
	
	static boolean canSwap(char[] chars) {
		int openCount = 0;
		int lastOpenIndex = -1;
		for (int i = 0; i < chars.length; i++) {
			char c = chars[i];
			if (c == '(') {
				openCount++;
				lastOpenIndex = i;
			} else {
				openCount--;
				
			}
		}
		if (openCount != 0) {
			return false;
		}
		
		int firstConflictIndex = -1;
		for (int i = 0; i < chars.length; i++) {
			char c = chars[i];
			if (c == '(') {
				openCount++;
			} else {
				openCount--;
			}
			if (openCount < 0) {
				firstConflictIndex = i;
				break;
			}
		}
		if (firstConflictIndex == -1) return true;
		
		chars[lastOpenIndex] = ')';
		chars[firstConflictIndex] = '(';
		
		openCount = 0;
		for (char c : chars) {
			if (c == '(') {
				openCount++;
			} else {
				openCount--;
			}
			if (openCount < 0) {
				return false;
			}
		}
		return true;
	}
}
