package leetcode.problem301;

/**
 * 327. Count of Range Sum
 */
public class Solution327 {
    private class TreeNode {
        long val;
        TreeNode left, right;

        public TreeNode(long val) {
            this.val = val;
        }
    }

    private TreeNode root;

    private TreeNode insert(TreeNode root, long val) {
        if (root == null) return new TreeNode(val);
        if (val < root.val) root.left = insert(root.left, val);
        else root.right = insert(root.right, val);
        return root;
    }

    private int count(TreeNode root, long left, long right) {
        if (root == null) return 0;
        if (root.val < left) return count(root.right, left, right);
        if (root.val > right) return count(root.left, left, right);
        return 1 + count(root.left, left, right) + count(root.right, left, right);
    }

    /**
     * lower <= sum[0~j] - sum[0~i] <= upper (0 <= i <= j < len)
     * sum(j) - upper <= sum(i) <= sum(j) -  lower
     */
    public int countRangeSum(int[] nums, int lower, int upper) {
        root = insert(root, 0L);
        long presum = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            presum += nums[i];
            res += count(root, presum - upper, presum - lower);
            root = insert(root, presum);
        }
        return res;
    }
}
