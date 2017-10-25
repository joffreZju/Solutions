package leetcode.problem051_100;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by joffre on 2017/10/16.
 * 60. Permutation Sequence
 */
public class Solution060 {
    public static String getPermutation(int n, int k) {
        k--;
        int factorial = 1, div = n;
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            factorial *= i;
            nums.add(i);
        }
        // k/factorial等于几，那么就从候选集选择该位置的数字同时将其从候选集移除，然后更新k。注意候选集下标从0开始。
        StringBuilder sb = new StringBuilder();
        while (true) {
            factorial /= div;
            div--;

            sb.append(nums.get(k / factorial));
            nums.remove(k / factorial);
            k %= factorial;
            if (nums.size() == 0) break;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 6; i++) {
            System.out.println(getPermutation(3, i));
        }
        System.out.println(getPermutation(1, 1));
    }
}
