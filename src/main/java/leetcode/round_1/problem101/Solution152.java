package leetcode.round_1.problem101;

/**
 * Created by joffre on 2017/11/27.
 * 152. Maximum Product Subarray
 * idea:
 * ans一定在一串连续非零数字中产生（i~j），否则ans=0。
 * 那么有三种情况：i~j乘积最大，i+k~j乘积最大，i~j-k乘积最大。
 * 所以在i~j上进行倒序和正序遍历就可以找到最大乘积。
 */
public class Solution152 {
    public static int maxProduct(int[] nums) {
        int backPro = 1, frontPro = 1, res = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            frontPro *= nums[i];
            backPro *= nums[nums.length - 1 - i];
            res = Math.max(res, Math.max(frontPro, backPro));
            if (frontPro == 0) frontPro = 1;
            if (backPro == 0) backPro = 1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{2, 3, -2, 4}));
        System.out.println(maxProduct(new int[]{-2}));
        System.out.println(maxProduct(new int[]{-2, 0, -1}));
        System.out.println(maxProduct(new int[]{0, 2}));
        System.out.println(maxProduct(new int[]{0}));
    }
}
