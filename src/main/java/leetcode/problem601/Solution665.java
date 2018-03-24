package leetcode.problem601;

/**
 * 665. Non-decreasing Array
 */
public class Solution665 {
    // Solution1
    public static boolean checkPossibility(int[] nums) {
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                count++;
                if (i - 2 >= 0 && nums[i] < nums[i - 2]) nums[i] = nums[i - 1];
                else nums[i - 1] = nums[i];
            }
        }
        return count <= 1;
    }

    // Solution2
    // public static boolean checkPossibility(int[] nums) {
    //     int count = 0, index = -1;
    //     for (int i = 0; i < nums.length - 1; i++) {
    //         if (nums[i] > nums[i + 1]) {
    //             index = i + 1;
    //             count++;
    //         }
    //     }
    //     if (count == 0) return true;
    //     else if (count > 1) return false;
    //     else {
    //         if (index == nums.length - 1 || nums[index - 1] <= nums[index + 1]) {
    //             nums[index] = nums[index - 1];
    //         } else {
    //             nums[index - 1] = nums[index];
    //         }
    //         for (int i = 0; i < nums.length - 1; i++) {
    //             if (nums[i] > nums[i + 1]) return false;
    //         }
    //         return true;
    //     }
    // }

    public static void main(String[] args) {
        System.out.println(checkPossibility(new int[]{4, 2, 3}));
        System.out.println(checkPossibility(new int[]{1, 2, 1, 3}));
        System.out.println(checkPossibility(new int[]{1, 4, 1, 3}));
    }

}
