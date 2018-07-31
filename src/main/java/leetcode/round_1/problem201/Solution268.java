package leetcode.round_1.problem201;

/**
 * 268. Missing Number
 */
public class Solution268 {
    public static int missingNumber(int[] nums) {
        int n = nums.length;
        // n次循环，每一次循环都确保nums[i]在正确位置上，或者nums[i]=n
        for (int i = 0; i < n; ) {
            if (nums[i] != n && nums[i] != i) {
                int tmp = nums[i];
                nums[i] = nums[nums[i]];
                nums[tmp] = tmp;
            } else i++;
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] != i) return i;
        }
        return n;
    }

    public static void main(String[] args) {
        System.out.println(missingNumber(new int[]{0, 1, 3}));
        System.out.println(missingNumber(new int[]{0, 1, 2}));
        System.out.println(missingNumber(new int[]{3, 1, 2}));
        System.out.println(missingNumber(new int[]{2, 0}));
        System.out.println(missingNumber(new int[]{1, 2}));
    }
}
