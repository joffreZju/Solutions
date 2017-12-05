package leetcode.problem101;

/**
 * Created by joffre on 2017/11/28.
 * 153. Find Minimum in Rotated Sorted Array
 */
public class Solution153 {
    public static int findMin(int[] nums) {
        int i = 0, j = nums.length - 1, mid;
        while (i < j) {
            mid = (i + j) / 2;
            if (nums[mid] > nums[j]) i = mid + 1;
            else j = mid;
        }
        return nums[i];
    }

    public static void main(String[] args) {
        System.out.println(findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
        System.out.println(findMin(new int[]{4, 0, 1, 2}));
        System.out.println(findMin(new int[]{4, 5, 6, 7, 0}));
        System.out.println(findMin(new int[]{0, 1, 2, 4}));
    }
}
