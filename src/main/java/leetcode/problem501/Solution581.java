package leetcode.problem501;

/**
 * 581. Shortest Unsorted Continuous Subarray
 */
public class Solution581 {
    public static int findUnsortedSubarray(int[] nums) {
        if (nums.length == 0 || nums.length == 1) return 0;
        int left = 0, right = nums.length - 1;

        // 找到左边升序的部分，和右边降序的部分
        while (left < right && nums[left + 1] >= nums[left]) left++;
        if (left == right) return 0;
        while (right > 0 && nums[right - 1] <= nums[right]) right--;

        // 找到中间乱序部分的min，max
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int i = left; i <= right; i++) {
            if (nums[i] > max) max = nums[i];
            if (nums[i] < min) min = nums[i];
        }

        // 将min与左边有序部分依次比较，找到其index，可能有left = -1
        while (left >= 0 && nums[left] > min) left--;

        // 将max与右边有序部分依次比较，找到其index，可能有right = nums.length
        while (right < nums.length && nums[right] < max) right++;

        // unsorted subArray为nums(left, right) (exclusive)，len = right - left -1;
        return right - left - 1;
    }

    public static void main(String[] args) {
        System.out.println(findUnsortedSubarray(new int[]{2, 6, 4, 8, 10, 9, 15}));
        System.out.println(findUnsortedSubarray(new int[]{1, 2}));
        System.out.println(findUnsortedSubarray(new int[]{2, 1}));
        System.out.println(findUnsortedSubarray(new int[]{1, 3, 2}));
        System.out.println(findUnsortedSubarray(new int[]{1, 3, 4, 5, 2}));
    }

}
