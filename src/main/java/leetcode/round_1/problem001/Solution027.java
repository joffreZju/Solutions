package leetcode.round_1.problem001;


/**
 * Created by joffre on 2017/9/18.
 * 27. Remove Element
 */
public class Solution027 {
    public static int removeElement(int[] nums, int val) {
        int position = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[position++] = nums[i];
            }
        }
        return position;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3};
        System.out.println(removeElement(nums, 3));
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
