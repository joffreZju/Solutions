package leetcode.problem601;

import leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 654. Maximum Binary Tree
 */
public class Solution654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        List<Integer> candidate = new ArrayList<>();
        for (int i : nums) candidate.add(i);
        return build(candidate);
    }

    private static TreeNode build(List<Integer> candidate) {
        if (candidate.size() == 0) return null;
        int maxIndex = 0;
        for (int i = 1; i < candidate.size(); i++) {
            if (candidate.get(i) > candidate.get(maxIndex)) {
                maxIndex = i;
            }
        }
        TreeNode root = new TreeNode(candidate.get(maxIndex));
        root.left = build(candidate.subList(0, maxIndex));
        root.right = build(candidate.subList(maxIndex + 1, candidate.size()));
        return root;
    }
}
