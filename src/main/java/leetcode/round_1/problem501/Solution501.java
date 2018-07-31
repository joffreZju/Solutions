package leetcode.round_1.problem501;

import leetcode.util.TreeNode;

import java.util.*;

/**
 * 501. Find Mode in Binary Search Tree
 */
public class Solution501 {
    public int[] findMode(TreeNode root) {
        maxCount = Integer.MIN_VALUE;
        count = 0;
        curVal = 0;
        candidate = new HashSet<>();

        inOrder(root);

        int[] res = new int[candidate.size()];
        Iterator<Integer> it = candidate.iterator();
        int i = 0;
        while (it.hasNext()) {
            res[i++] = it.next();
        }
        return res;
    }

    private static int maxCount, curVal, count;
    private static Set<Integer> candidate;

    private static void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);

        if (root.val == curVal) {
            count++;
        } else {
            curVal = root.val;
            count = 1;
        }

        if (count > maxCount) {
            candidate.clear();
            maxCount = count;
            candidate.add(curVal);
        } else if (count == maxCount) {
            candidate.add(curVal);
        }

        inOrder(root.right);
    }
}
