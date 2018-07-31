package leetcode.round_1.problem001;

import java.util.Arrays;

/**
 * Created by joffre on 2017/11/3.
 * 88. Merge Sorted Array
 */
public class Solution088 {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, k = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) nums1[k--] = nums1[i--];
            else nums1[k--] = nums2[j--];
        }
        while (j >= 0) nums1[k--] = nums2[j--];
        // System.out.println(Arrays.toString(nums1));
    }

    public static void main(String[] args) {
        merge(new int[1], 0, new int[]{2}, 1);
        merge(new int[]{2}, 1, new int[]{}, 0);
    }
}
