package company.indeed;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong(), count = 0;
        while (n > 1) {
            if (n % 2 == 0) n /= 2;
            else n--;
            count++;
        }
        System.out.println(count);
    }
}
