package leetcode.round_1.problem101;

import leetcode.util.TreeNode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * 124. Binary Tree Maximum Path Sum
 */
public class Solution124 {
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }

    private int max;

    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int left = dfs(root.left), right = dfs(root.right);
        int res = Math.max(left, right) + root.val;

        List<Integer> list = Arrays.asList(root.val + left + right, left + root.val, right + root.val, max);
        Collections.sort(list);
        max = list.get(list.size() - 1);

        return res > 0 ? res : 0;
    }
}
