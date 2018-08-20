package leetcode.round_2.problem001;

/**
 * 88. Merge Sorted Array
 */
public class Solution088 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int k = m + n - 1, i = m - 1, j = n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] <= nums2[j]) {
                nums1[k--] = nums2[j--];
            } else if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            }
        }
        while (i >= 0) nums1[k--] = nums1[i--];
        while (j >= 0) nums1[k--] = nums2[j--];
    }
}
