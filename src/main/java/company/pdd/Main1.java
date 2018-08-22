package company.pdd;


import java.util.Arrays;
import java.util.Scanner;

public class Main1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String line = sc.nextLine();
		int n = line.length() / 4 + 1, k = 0;
		
		char[][] matrix = new char[n][n];
		for (int i = 1; i <= n - 2; i++) {
			Arrays.fill(matrix[i], ' ');
		}
		
		for (int j = 0; j < n; j++) {
			matrix[0][j] = line.charAt(k++);
		}
		
		for (int i = 1; i <= n - 2; i++) {
			matrix[i][n - 1] = line.charAt(k++);
		}
		
		for (int j = n - 1; j >= 0; j--) {
			matrix[n - 1][j] = line.charAt(k++);
		}
		
		for (int i = n - 2; i >= 1; i--) {
			matrix[i][0] = line.charAt(k++);
		}
		
		for (int i = 0; i < n; i++) {
			System.out.println(new String(matrix[i]));
		}
	}
	
}
