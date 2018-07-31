package leetcode.round_1.problem301;

import leetcode.util.Interval;

import java.util.*;

public class SummaryRanges {
    private class BST {
        int left, right;
        BST lchild, rchild;

        public BST(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

    private BST root;

    public SummaryRanges() {
    }

    private BST delete(BST root, int left, int right) {
        if (root == null) return null;
        else if (left > root.right) root.rchild = delete(root.rchild, left, right);
        else if (right < root.left) root.lchild = delete(root.lchild, left, right);
        else {
            if (root.lchild != null) return root.lchild;
            if (root.rchild != null) return root.rchild;
            return null;
        }
        return root;
    }

    private BST insert(BST root, int val) {
        if (root == null) return new BST(val, val);
        if (val > root.right + 1) root.rchild = insert(root.rchild, val);
        if (val < root.left - 1) root.lchild = insert(root.lchild, val);
        if (val == root.left - 1) {
            root.left = val;
            if (root.lchild != null) {
                BST leftMax = root.lchild;
                while (leftMax.rchild != null) leftMax = leftMax.rchild;
                if (root.left - leftMax.right <= 1) {
                    root.left = leftMax.left;
                    root.lchild = delete(root.lchild, leftMax.left, leftMax.right);
                }
            }
        } else if (val == root.right + 1) {
            root.right = val;
            if (root.rchild != null) {
                BST rightMin = root.rchild;
                while (rightMin.lchild != null) rightMin = rightMin.lchild;
                if (rightMin.left - root.right <= 1) {
                    root.right = rightMin.right;
                    root.rchild = delete(root.rchild, rightMin.left, rightMin.right);
                }
            }
        }
        return root;
    }

    private void inorder(BST root, List<Interval> list) {
        if (root == null) return;
        inorder(root.lchild, list);
        list.add(new Interval(root.left, root.right));
        inorder(root.rchild, list);
    }

    public void addNum(int val) {
        root = insert(root, val);
    }

    public List<Interval> getIntervals() {
        List<Interval> list = new ArrayList<>();
        inorder(root, list);
        return list;
    }
}
