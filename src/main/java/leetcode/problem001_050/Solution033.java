package leetcode.problem001_050;

/**
 * Created by joffre on 2017/10/10.
 * 33. Search in Rotated Sorted Array
 */
public class Solution033 {
    public static int search(int[] nums, int target) {
        if (nums.length == 0 || (nums.length == 1 && nums[0] != target)) return -1;

        int pivot = 0, high = nums.length - 1;
        while (pivot < high) {
            int mid = (pivot + high) / 2;
            if (nums[mid] > nums[high]) pivot = mid + 1;
            else high = mid;
        }

        int left = -1, right = -1;
        if (target >= nums[pivot] && target <= nums[nums.length - 1]) {
            left = pivot;
            right = nums.length - 1;
        } else if (pivot != 0 && target >= nums[0] && target <= nums[pivot - 1]) {
            left = 0;
            right = pivot - 1;
        }
        if (left == -1 && right == -1) return -1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{4, 5, 6, 7, 1, 2, 3}, 1));
    }
}
