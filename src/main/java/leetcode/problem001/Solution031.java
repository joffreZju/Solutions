package leetcode.problem001;

import java.util.Arrays;

/**
 * Created by joffre on 2017/10/9.
 * 31. Next Permutation
 */
public class Solution031 {
    public static void nextPermutation(int[] nums) {
        if (nums.length == 0) {
            return;
        }
        int left = -1, right = -1;
        for (int i = nums.length - 1; i >= 1; i--) {
            if (nums[i] > nums[i - 1]) {
                left = i - 1;
                break;
            }
        }
        if (left == -1) {
            Arrays.sort(nums);
            return;
        }
        for (int i = nums.length - 1; i > left; i--) {
            if (nums[i] > nums[left]) {
                right = i;
                break;
            }
        }
        swap(nums, left, right);

        left++;
        right = nums.length - 1;
        while (left < right) {
            if (nums[left] < nums[right]) {
                break;
            }
            swap(nums, left, right);
            left++;
            right--;
        }
        // System.out.println(Arrays.toString(nums));
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        nextPermutation(new int[]{1, 2, 3, 4});
        nextPermutation(new int[]{1, 3, 2, 4});
        nextPermutation(new int[]{1, 3, 4, 2});
        nextPermutation(new int[]{2, 1, 4, 3});
        nextPermutation(new int[]{3, 2, 1, 4});

    }

}
