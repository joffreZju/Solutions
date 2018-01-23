package leetcode.problem101;

import leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 108. Convert Sorted Array to Binary Search Tree
 */
public class Solution108 {
    public static TreeNode sortedArrayToBST(int[] nums) {
        List<Integer> numbers = new ArrayList<>();
        for (int num : nums) numbers.add(num);
        return helper(numbers);
    }

    private static TreeNode helper(List<Integer> nums) {
        if (nums.size() == 0) return null;
        int mid = nums.size() / 2;
        TreeNode root = new TreeNode(nums.get(mid));
        root.left = helper(nums.subList(0, mid));
        root.right = helper(nums.subList(mid + 1, nums.size()));
        return root;
    }

    public static void main(String[] args) {
        sortedArrayToBST(new int[]{});
        sortedArrayToBST(new int[]{1});
        sortedArrayToBST(new int[]{1, 2});
        sortedArrayToBST(new int[]{1, 2, 3});
        sortedArrayToBST(new int[]{1, 2, 3, 4});
        sortedArrayToBST(new int[]{1, 2, 3, 4, 5});
    }
}
