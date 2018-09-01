package company.pdd2;

import java.util.*;

public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt(), b = in.nextInt();
        if (b == 0) {
            System.out.println("0 0");
        } else {
            a %= b;
            int len = 0;
            Map<Integer, Integer> map = new HashMap<>();
            map.put(a, len);
            while (a != 0) {
                a *= 10;
                a %= b;
                len++;
                if (map.containsKey(a)) {
                    int index = map.get(a);
                    System.out.println(index + " " + (len - index));
                    return;
                } else {
                    map.put(a, len);
                }
            }
            System.out.println(len + " 0");
        }
    }
}

