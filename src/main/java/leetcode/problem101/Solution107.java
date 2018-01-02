package leetcode.problem101;

import leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 107. Binary Tree Level Order Traversal II
 */
public class Solution107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode node;
        queue.add(root);
        while (!queue.isEmpty()) {
            int curLevelSize = queue.size();
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < curLevelSize; i++) {
                node = queue.poll();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
                tmp.add(node.val);
            }
            res.add(0, tmp);
        }
        return res;
    }
}
