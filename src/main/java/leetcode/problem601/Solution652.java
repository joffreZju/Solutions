package leetcode.problem601;

import leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 652. Find Duplicate Subtrees
 */
public class Solution652 {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        map = new HashMap<>();
        preOrder(root);

        for (Map.Entry<Integer, List<TreeNode>> entry : map.entrySet()) {
            if (entry.getValue().size() < 2) continue;

        }
    }


    private static Map<Integer, List<TreeNode>> map;

    private static void preOrder(TreeNode root) {
        if (root == null) return;
        if (!map.containsKey(root.val)) map.put(root.val, new ArrayList<>());
        map.get(root.val).add(root);

        preOrder(root.left);
        preOrder(root.right);
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        else if (p == null || q == null) return false;
        else if (p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
