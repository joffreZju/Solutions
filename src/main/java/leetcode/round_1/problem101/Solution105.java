package leetcode.round_1.problem101;

import leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 105. Construct Binary Tree from Preorder and Inorder Traversal
 */
public class Solution105 {
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        List<Integer> pre = new ArrayList<>(), in = new ArrayList<>();
        for (int i = 0; i < preorder.length; i++) {
            pre.add(preorder[i]);
            in.add(inorder[i]);
        }
        return helper(pre, in);
    }

    private static TreeNode helper(List<Integer> preorder, List<Integer> inorder) {
        if (preorder.size() == 0) return null;
        TreeNode root = new TreeNode(preorder.get(0));
        int index = inorder.lastIndexOf(preorder.get(0));

        root.left = helper(preorder.subList(1, index + 1), inorder.subList(0, index));
        root.right = helper(preorder.subList(index + 1, preorder.size()), inorder.subList(index + 1, inorder.size()));
        return root;
    }

    public static void main(String[] args) {
        buildTree(new int[]{1, 2, 3}, new int[]{2, 1, 3});
    }
}
