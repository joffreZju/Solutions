package leetcode.problem001_050;

/**
 * Created by joffre on 2017/9/18.
 * 35. Search Insert Position
 */
public class Solution035 {
    public static int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            } else if (nums[i] > target) {
                return i;
            } else if (nums[i] < target && i == nums.length - 1) {
                return nums.length;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 5));
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 2));
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 7));
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 0));
    }
}
