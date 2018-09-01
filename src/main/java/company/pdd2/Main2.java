package company.pdd2;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), m = in.nextInt();
        in.nextLine();
        char[][] tab = new char[n][m];
        for (int i = 0; i < n; i++) {
            String tmp = in.nextLine();
            for (int j = 0; j < tmp.length(); j++) {
                tab[i][j] = tmp.charAt(j);
            }
        }

        for (int j = 0; j < m; j++) {
            boolean barried = false;
            int row = n - 1;
            for (int i = n - 1; i >= 0; i--) {
                if (tab[i][j] == 'o') {
                    tab[i][j] = '.';
                    if (barried) {
                        tab[row--][j] = 'o';
                    }
                } else if (tab[i][j] == 'x') {
                    barried = true;
                    row = i - 1;
                }
            }
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(tab[i][j]);
            }
            System.out.println();
        }
    }
}
