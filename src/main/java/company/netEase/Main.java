package company.netEase;

import java.util.*;

public class Main {
    //矩形重叠，AC
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // Scanner in = new Scanner("2\n" +
        //         "0 100\n" +
        //         "0 100\n" +
        //         "100 200\n" +
        //         "100 200\n");
        int maxn = 55;
        int n = in.nextInt(), x1[] = new int[maxn], y1[] = new int[maxn], x2[] = new int[maxn], y2[] = new int[maxn];
        Set<Integer> xset = new HashSet<>(), yset = new HashSet<>();
        for (int i = 0; i < n; i++) {
            x1[i] = in.nextInt();
            xset.add(x1[i]);
        }
        for (int i = 0; i < n; i++) {
            y1[i] = in.nextInt();
            yset.add(y1[i]);
        }
        for (int i = 0; i < n; i++) {
            x2[i] = in.nextInt();
            xset.add(x2[i]);
        }
        for (int i = 0; i < n; i++) {
            y2[i] = in.nextInt();
            yset.add(y2[i]);
        }

        int res = 0;
        for (int x : xset) {
            for (int y : yset) {
                int count = 0;
                for (int i = 0; i < n; i++) {
                    if (x1[i] < x && y1[i] < y && x2[i] > x && y2[i] > y) count++;
                }
                res = Math.max(res, count);
            }
        }
        System.out.println(res);
    }
}
