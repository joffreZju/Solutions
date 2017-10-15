package leetcode.problem001_050;

/**
 * Created by joffre on 2017/9/18.
 * 26. Remove Duplicates from Sorted Array
 */
public class Solution026 {
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int duplicate = nums[0] + 1, position = 0; //duplicate的初始值不能等于nums[0],也不能越界
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != duplicate) {
                nums[position] = nums[i];
                duplicate = nums[i];
                position++;
            }
        }
        return position;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 0, 0, 0, 3, 3};
        System.out.println(removeDuplicates(nums));
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
