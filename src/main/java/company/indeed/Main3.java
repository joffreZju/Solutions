package company.indeed;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt(), target = in.nextInt(), maxIndex = 0;
        long position[] = new long[t];

        position[0] = in.nextInt();
        for (int i = 1; i < t; i++) {
            position[i] = position[i - 1] + in.nextInt();
            if (position[i] >= target) {
                System.out.println(i + 1);
                return;
            } else if (position[i] > position[maxIndex]) {
                maxIndex = i;
            }
        }

        long move = position[t - 1];
        if (move <= 0) {
            System.out.println(-1);
        } else {
            long rows = 1, cur = position[maxIndex];
            while (cur < target) {
                cur += move;
                rows++;
            }
            System.out.println(t * (rows - 1) + maxIndex + 1);
        }
    }
}
