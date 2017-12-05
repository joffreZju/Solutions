package leetcode.problem001;

/**
 * Created by joffre on 2017/10/31.
 * 81. Search in Rotated Sorted Array II
 */
public class Solution081 {
    public static boolean search(int[] nums, int target) {
        if (nums.length == 0) return false;
        int left = 0, right = nums.length - 1, mid;
        while (left < right) {
            mid = (left + right) / 2;
            if (nums[mid] == target) return true;
            else if (nums[left] < nums[mid]) {
                //左半部分有序，检查target是否在左半边
                if (target >= nums[left] && target < nums[mid]) right = mid - 1;
                else left = mid + 1;
            } else if (nums[left] > nums[mid]) {
                //右半部分有序，检查target是否在右半边
                if (target > nums[mid] && target <= nums[right]) left = mid + 1;
                else right = mid - 1;
            } else {
                //不确定哪边有序
                //2 2(mid) 3 2
                //2 3 2(mid) 2 2
                left++;
            }
        }
        return (target == nums[left]);
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{2, 3, 3, 3, 4, 5, 1, 1, 2}, 3));
        System.out.println(search(new int[]{2, 3, 3, 3, 4, 5, 1, 1, 2}, 1));
        System.out.println(search(new int[]{2, 3, 3, 3, 4, 5, 1, 1, 2}, 2));
        System.out.println(search(new int[]{2, 3, 3, 3, 4, 5, 1, 1, 2}, 4));
        System.out.println(search(new int[]{2, 3, 3, 3, 4, 5, 1, 1, 2}, 5));
        System.out.println(search(new int[]{1, 3, 1, 1, 1}, 1));
        System.out.println(search(new int[]{1, 3, 1, 1, 1}, 3));
    }
}
