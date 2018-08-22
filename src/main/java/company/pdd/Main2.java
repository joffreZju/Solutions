package company.pdd;

import java.util.Scanner;

public class Main2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String num = sc.nextLine();
		int res = 0;
		for (int i = num.length() - 1; i >= 1; i--) {
			String left = num.substring(0, i), right = num.substring(i, num.length());
			res += (countCase(left) * countCase(right));
		}
		
		System.out.println(res);
	}
	
	private static int countCase(String num) {
		int res = 0, len = num.length();
		
		if (num.length() > 1 && num.charAt(len - 1) != '0') {
			if (num.charAt(0) == '0') res = 1;
			else res = len - 1;
		}
		
		if (num.length() == 1 || num.charAt(0) != '0') {
			res++;
		}
		return res;
	}
	
}