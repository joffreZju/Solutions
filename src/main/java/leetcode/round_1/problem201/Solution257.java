package leetcode.round_1.problem201;

import leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 257. Binary Tree Paths
 */
public class Solution257 {
    public static List<String> binaryTreePaths(TreeNode root) {
        res = new ArrayList<>();
        dfs(root, new ArrayList<>());
        return res;
    }

    private static List<String> res;

    private static void dfs(TreeNode root, List<String> paths) {
        if (root == null) return;

        paths.add(String.valueOf(root.val));
        if (root.left == null && root.right == null) {
            res.add(String.join("->", paths));
        } else {
            dfs(root.left, paths);
            dfs(root.right, paths);
        }
        paths.remove(paths.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.deserializeTree(new Integer[]{1, 2, 3, 4, 5, 6});
        System.out.println(binaryTreePaths(root));
    }
}
