package leetcode.round_1.problem601;

import leetcode.util.TreeNode;

/**
 * 671. Second Minimum Node In a Binary Tree
 */
public class Solution671 {
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) return -1;
        int min = root.val, secondMin = Math.min(findMinGt(root, min), findMinGt(root.right, min));
        return secondMin == Integer.MAX_VALUE ? -1 : secondMin;
    }

    private static int findMinGt(TreeNode root, int gt) {
        if (root == null) return Integer.MAX_VALUE;
        else if (root.val == gt) {
            return Math.min(findMinGt(root.left, gt), findMinGt(root.right, gt));
        } else return root.val;
    }
}
