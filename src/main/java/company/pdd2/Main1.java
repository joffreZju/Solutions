package company.pdd2;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int hp = in.nextInt(), na = in.nextInt(), ba = in.nextInt();
        int res = 0;
        if (na * 2 > ba) {
            res += hp % na == 0 ? hp / na : hp / na + 1;
            System.out.println(res);
        } else {
            if (hp % ba == 0) System.out.println(2 * hp / ba);
            else {
                res += 2 * (hp / ba);
                hp %= ba;
                if (hp <= na) res++;
                else res += 2;
                System.out.println(res);
            }
        }
    }
}
