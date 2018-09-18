package company.didi;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int np = in.nextInt(), nq = in.nextInt(), nr = in.nextInt();
        int res = dfs(new char[np + nq + nr], 0, np, nq, nr);
        System.out.println(res);
    }
    
    private static int dfs(char[] pre, int count, int p, int q, int r) {
        if (p == 0 && q == 0 && r == 0) return 1;
        /*
        if (Math.abs(p - q - r) >= 2) return 0;
        if (Math.abs(q - p - r) >= 2) return 0;
        if (Math.abs(r - q - p) >= 2) return 0;
        
        if (p == 0 && Math.abs(q - r) >= 2) return 0;
        if (q == 0 && Math.abs(p - r) >= 2) return 0;
        if (r == 0 && Math.abs(p - q) >= 2) return 0;
        */
        
        int res = 0;
        
        if (p > 0 && (count == 0 || pre[count - 1] != 'p')) {
            pre[count] = 'p';
            res += dfs(pre, count + 1, p - 1, q, r);
        }
        if (q > 0 && (count == 0 || pre[count - 1] != 'q')) {
            pre[count] = 'q';
            res += dfs(pre, count + 1, p, q - 1, r);
        }
        if (r > 0 && (count == 0 || pre[count - 1] != 'r')) {
            pre[count] = 'r';
            res += dfs(pre, count + 1, p, q, r - 1);
        }
        return res;
    }
}
