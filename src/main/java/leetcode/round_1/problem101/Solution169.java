package leetcode.round_1.problem101;

/**
 * Created by joffre on 2017/11/28.
 * 169. Majority Element
 */
public class Solution169 {
    public static int majorityElement(int[] nums) {
        int major = nums[0], count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                major = nums[i];
                count++;
            } else if (major == nums[i]) count++;
            else count--;
        }
        return major;
    }
}
