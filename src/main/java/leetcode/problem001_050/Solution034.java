package leetcode.problem001_050;

import java.util.Arrays;

/**
 * Created by joffre on 2017/10/10.
 * 34. Search for a Range
 */
public class Solution034 {
    public static int[] searchRange(int[] nums, int target) {
        int left = -1, right = -1;
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                left = mid;
                high = mid - 1;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        low = 0;
        high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                right = mid;
                low = mid + 1;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return new int[]{left, right};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchRange(new int[]{1, 2, 4, 4, 4, 5}, 3)));
    }
}
