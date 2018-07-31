package leetcode.round_1.problem001;

import java.util.Arrays;

/**
 * Created by joffre on 2017/9/29.
 * 16. 3Sum Closest
 */
public class Solution016 {
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int nearest = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                int left = i + 1, right = nums.length - 1;
                while (left < right) {
                    int sum = nums[i] + nums[left] + nums[right];
                    if (Math.abs(sum - target) < Math.abs(nearest - target)) {
                        nearest = sum;
                    }

                    if (sum == target) {
                        return sum;
                    } else if (sum > target) {
                        while (left < right && nums[right] == nums[right - 1]) right--;
                        right--;
                    } else {
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        left++;
                    }
                }
            }
        }
        return nearest;
    }

    public static void main(String[] args) {
        System.out.println(Solution016.threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
    }
}
