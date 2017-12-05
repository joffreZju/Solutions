package leetcode.problem201;

/**
 * Created by joffre on 2017/11/30.
 * 283. Move Zeroes
 */
public class Solution283 {
    public static void moveZeroes(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) nums[count++] = nums[i];
        }
        for (int i = count; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public static void main(String[] args) {
        moveZeroes(new int[]{0, 1, 0, 3, 12});
    }
}
