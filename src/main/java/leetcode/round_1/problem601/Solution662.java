package leetcode.round_1.problem601;

import leetcode.util.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 662. Maximum Width of Binary Tree
 */
public class Solution662 {
    //    用数组表示二叉树时节点的index
    public int widthOfBinaryTree(TreeNode root) {
        return helper(root, 1, 1, new HashMap<>());
    }

    private static int helper(TreeNode root, int index, int level, Map<Integer, Integer> leftIndex) {
        if (root == null) return 0;
        if (!leftIndex.containsKey(level)) leftIndex.put(level, index);
        int cur = index - leftIndex.get(level) + 1;
        return Math.max(cur, Math.max(
                helper(root.left, index * 2, level + 1, leftIndex),
                helper(root.right, index * 2 + 1, level + 1, leftIndex)
        ));
    }
}
