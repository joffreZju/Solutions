package leetcode.problem001;

import java.util.Arrays;

/**
 * Created by joffre on 2017/11/15.
 * 4. Median of Two Sorted Arrays
 */
public class Solution004 {
    private static int findKthMin(int[] nums1, int[] nums2, int k) {
        if (nums1.length > nums2.length) return findKthMin(nums2, nums1, k);
        if (nums1.length == 0) return nums2[k - 1];
        if (k == 1) return Math.min(nums1[0], nums2[0]);

        int p1 = Math.min(k / 2, nums1.length), p2 = k - p1;
        if (nums1[p1 - 1] < nums2[p2 - 1])
            return findKthMin(Arrays.copyOfRange(nums1, p1, nums1.length), nums2, k - p1);
        else if (nums1[p1 - 1] > nums2[p2 - 1])
            return findKthMin(nums1, Arrays.copyOfRange(nums2, p2, nums2.length), k - p2);
        else
            return nums1[p1 - 1];
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int sum = nums1.length + nums2.length;
        if (sum % 2 != 0)
            return findKthMin(nums1, nums2, sum / 2 + 1);
        else
            return (findKthMin(nums1, nums2, sum / 2) + findKthMin(nums1, nums2, sum / 2 + 1)) / 2.0;
    }

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1, 2, 3}, new int[]{4, 5, 6, 7}));
        System.out.println(findMedianSortedArrays(new int[]{1, 2, 3}, new int[]{4, 5, 6, 7, 8}));
    }
}
