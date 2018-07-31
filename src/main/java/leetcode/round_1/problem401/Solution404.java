package leetcode.round_1.problem401;

import leetcode.util.TreeNode;

/**
 * 404. Sum of Left Leaves
 */
public class Solution404 {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;

        int left;

        if (root.left == null) left = 0;
        else if (root.left.left == null && root.left.right == null) left = root.left.val;
        else left = sumOfLeftLeaves(root.left);

        return left + sumOfLeftLeaves(root.right);
    }
}
