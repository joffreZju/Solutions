package leetcode.problem101;

import leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 113. Path Sum II
 */
public class Solution113 {
    //    postOrder solution
    public List<List<Integer>> pathSumStack(TreeNode root, int sum) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        List<Integer> tmp = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root, pre = null;
        while (cur != null || !stack.empty()) {
            if (cur != null) {
                stack.push(cur);
                tmp.add(cur.val);
                sum -= cur.val;
                cur = cur.left;
            } else if (stack.peek().right != null && stack.peek().right != pre) {
                cur = stack.peek().right;
            } else {
                cur = stack.pop();
                if (cur.left == null && cur.right == null && sum == 0) {
                    ans.add(new ArrayList<>(tmp));
                }
                sum += cur.val;
                tmp.remove(tmp.size() - 1);
                pre = cur;
                cur = null;
            }
        }
        return ans;
    }

    // recursive solution
    private static List<List<Integer>> res;

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        res = new ArrayList<>();
        helper(root, sum, new ArrayList<>());
        return res;
    }

    private static void helper(TreeNode root, int sum, List<Integer> tmp) {
        if (root == null) return;
        tmp.add(root.val);
        if (root.left == null && root.right == null && sum == root.val) {
            res.add(new ArrayList<>(tmp));
        } else {
            helper(root.left, sum - root.val, tmp);
            helper(root.right, sum - root.val, tmp);
        }
        tmp.remove(tmp.size() - 1);
    }

}
