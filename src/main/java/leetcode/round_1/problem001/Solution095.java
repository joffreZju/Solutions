package leetcode.round_1.problem001;

/**
 * 95. Unique Binary Search Trees II
 */

import leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution095 {
    public static List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<>();
        List<Integer> candidate = new ArrayList<>();
        for (int i = 1; i <= n; i++) candidate.add(i);
        return helper(candidate);
    }

    private static List<TreeNode> helper(List<Integer> candidate) {
        if (candidate.size() == 0) {
            List<TreeNode> res = new ArrayList<>();
            res.add(null);
            return res;
        } else if (candidate.size() == 1) {
            List<TreeNode> res = new ArrayList<>();
            res.add(new TreeNode(candidate.get(0)));
            return res;
        }
        List<TreeNode> res = new ArrayList<>();
        for (int i = 0; i < candidate.size(); i++) {
            for (TreeNode left : helper(candidate.subList(0, i))) {
                for (TreeNode right : helper(candidate.subList(i + 1, candidate.size()))) {
                    TreeNode root = new TreeNode(candidate.get(i));
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<TreeNode> res = generateTrees(0);
        System.out.println(res);
        for (TreeNode root : res) {
            System.out.println(root.val);
        }
    }
}
