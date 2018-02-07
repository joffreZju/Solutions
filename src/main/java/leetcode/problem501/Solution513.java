package leetcode.problem501;

import leetcode.util.TreeNode;

/**
 * 513. Find Bottom Left Tree Value
 */
public class Solution513 {
    // Solution0
    public int findBottomLeftValue(TreeNode root) {
        maxDepth = 0;
        helper(root, 1);
        return res;
    }

    private static int res, maxDepth;

    private static void helper(TreeNode root, int depth) {
        if (root == null) return;
        if (depth > maxDepth) {
            maxDepth = depth;
            res = root.val;
        }
        helper(root.left, depth + 1);
        helper(root.right, depth + 1);
    }


    // Solution1
    // public int findBottomLeftValue(TreeNode root) {
    //     Queue<TreeNode> queue = new LinkedList<>();
    //     queue.add(root);
    //     while (!queue.isEmpty()) {
    //         root = queue.poll();
    //         if (root.right != null) queue.offer(root.right);
    //         if (root.left != null) queue.offer(root.left);
    //     }
    //     return root.val;
    // }


    // // Solution2
    // public int findBottomLeftValue(TreeNode root) {
    //     return helper(root)[1];
    // }
    //
    // // 返回[height, leftMost]
    // private static int[] helper(TreeNode root) {
    //     if (root == null) return new int[]{0, 0};
    //     else if (root.left == null && root.right == null) {
    //         return new int[]{1, root.val};
    //     }
    //
    //     int[] left = helper(root.left), right = helper(root.right);
    //     int height = 1 + Math.max(left[0], right[0]);
    //
    //     if (right[0] > left[0]) {
    //         return new int[]{height, right[1]};
    //     } else {
    //         return new int[]{height, left[1]};
    //     }
    // }
}
