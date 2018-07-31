package leetcode.round_1.problem801;

import java.util.*;

/**
 * 805 Split Array With Same Average
 */
public class Solution805 {
    /**
     * exist[i][j]: A 中的某 j 个数累加和等于 i
     * 取出 A 中的每一个 a，然后更新exist的状态，注意要倒序，否则，前面的更新会被后面的更新看到，导致同一个数重复累加。
     */
    // public static boolean splitArraySameAverage(int[] A) {
    //     int sum = 0, len = A.length;
    //     for (int i : A) sum += i;
    //     boolean[][] exist = new boolean[sum + 1][len + 1];
    //
    //     for (int a : A) {
    //         for (int i = sum - a; i >= 0; i--) { // 必须倒序
    //             for (int j = 1; j < len; j++) {
    //                 if (exist[i][j]) {
    //                     exist[i + a][j + 1] = true;
    //                 }
    //             }
    //         }
    //         exist[a][1] = true;
    //     }
    //
    //     for (int i = 0; i < sum + 1; i++) {
    //         for (int j = 1; j < len; j++) {
    //             // i / j = sum / len
    //             if (exist[i][j] && i * len == j * sum) {
    //                 return true;
    //             }
    //         }
    //     }
    //     return false;
    // }
    public static boolean splitArraySameAverage(int[] A) {
        int len = A.length, sum = 0;
        for (int a : A) sum += a;

        // sum / len = x / l = (sum - x) / (len - l), 所以 l 从 1 ~ len/2 即可，不需要从 1~len
        for (int l = 1; l <= len / 2; l++) {
            // sum / len == x / l, 然后检测 A 中取出 l 个数累加和等于 x，即满足条件。
            if (sum * l % len == 0) {
                // sum * l / len 一定会是整数
                if (checkSum(A, 0, sum * l / len, l)) return true;
            }
        }
        return false;
    }

    private static boolean checkSum(int[] nums, int start, int tmpSum, int tmpSize) {
        if (tmpSize == 0 && tmpSum == 0) return true;
        else if (tmpSize < 0 || tmpSum < 0) return false;

        for (int i = start; i < nums.length; i++) {
            if (checkSum(nums, i + 1, tmpSum - nums[i], tmpSize - 1)) return true;
        }
        return false;
    }


    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        int[] nums2 = new int[]{1, 2, 3};
        int[] nums3 = new int[]{1, 3};
        int[] nums4 = new int[]{10, 29, 13, 53, 33, 48, 76, 70, 5, 5};
        int[] nums5 = new int[]{33, 86, 88, 78, 21, 76, 19, 20, 88, 76, 10, 25, 37, 97, 58, 89, 65, 59, 98, 57, 50, 30, 58, 5, 61, 72, 23, 6};
        int[] nums6 = new int[]{17, 3, 7, 12, 1};
        System.out.println(splitArraySameAverage(nums1));
        System.out.println(splitArraySameAverage(nums2));
        System.out.println(splitArraySameAverage(nums3));
        System.out.println(splitArraySameAverage(nums4));
        System.out.println(splitArraySameAverage(nums5));
        System.out.println(splitArraySameAverage(nums6));

    }
}
