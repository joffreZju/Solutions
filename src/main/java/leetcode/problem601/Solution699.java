package leetcode.problem601;

import java.util.*;

/**
 * 699. Falling Squares
 */
public class Solution699 {
    private class SegNode {
        //max 是当前区间的最大高度，height当前区间的高度（整个区间都是同一高度，否则height=0）
        int left, right, mid, max, height;
        SegNode lchild, rchild;

        SegNode(int left, int right, int height) {
            this.left = left;
            this.right = right;
            this.height = height;
            this.max = height;
            this.mid = left + (right - left) / 2;
        }
    }

    private int globalMax;

    // 查询[left, right]的最大高度
    // 1、如果区间完全匹配或者当前node是叶子节点，那么直接返回
    // 2、否则递归查询
    private int query(SegNode root, int left, int right) {
        if (root == null) return 0;
        else if ((root.left == left && root.right == right) || (root.lchild == null && root.rchild == null))
            return Math.max(root.max, root.height);
        else if (left > root.mid) return query(root.rchild, left, right);
        else if (right <= root.mid) return query(root.lchild, left, right);
        else return Math.max(query(root.lchild, left, root.mid), query(root.rchild, root.mid + 1, right));
    }

    // 更新[left, right]的区间高度为newHeight
    // 1、如果当前node为空或者没有交集，那么直接return
    // 2、如果当前node被全部覆盖，那么更新当前node及其所有子树的height和max，同步更新globalMax
    // 3、没有全部覆盖，但是与当前node有交集，更新当前node的左右子树
    // （即使[left, right]全部位于左子树，也要new一棵右子树给当前node，否则查询的时候检索到右子树会返回0，如下面注释的代码）
    private void update(SegNode root, int left, int right, int newHeight) {
        if (root == null || left > root.right || right < root.left) return;
        else if (left <= root.left && right >= root.right) {
            root.max = newHeight;
            root.height = newHeight;
            globalMax = Math.max(root.max, globalMax);
            update(root.lchild, left, right, newHeight);
            update(root.rchild, left, right, newHeight);
        } else {
            root.max = Math.max(root.max, newHeight);
            if (root.lchild == null) root.lchild = new SegNode(root.left, root.mid, root.height);
            update(root.lchild, left, right, newHeight);

            if (root.rchild == null) root.rchild = new SegNode(root.mid + 1, root.right, root.height);
            update(root.rchild, left, right, newHeight);

            // if (left > root.mid) {
            //     if (root.rchild == null) root.rchild = new SegNode(root.mid + 1, root.right);
            //     update(root.rchild, left, right, newHeight);
            // } else if (right <= root.mid) {
            //     if (root.lchild == null) root.lchild = new SegNode(root.left, root.mid);
            //     update(root.lchild, left, right, newHeight);
            // } else {
            //     if (root.lchild == null) root.lchild = new SegNode(root.left, root.mid);
            //     update(root.lchild, left, root.mid, newHeight);
            //
            //     if (root.rchild == null) root.rchild = new SegNode(root.mid + 1, root.right);
            //     update(root.rchild, root.mid + 1, right, newHeight);
            // }
        }
    }

    public List<Integer> fallingSquares(int[][] positions) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int[] pos : positions) {
            min = Math.min(pos[0], min);
            max = Math.max(pos[0] + pos[1] - 1, max);
        }

        SegNode root = new SegNode(min, max, 0);
        globalMax = 0;
        List<Integer> res = new ArrayList<>();
        for (int[] pos : positions) {
            int left = pos[0], right = pos[0] + pos[1] - 1, h = query(root, left, right) + pos[1];
            update(root, left, right, h);
            res.add(globalMax);
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] tmp = new int[][]{{9, 7}, {1, 9}, {3, 1}};
        System.out.println(new Solution699().fallingSquares(tmp));

        tmp = new int[][]{{100, 100}, {200, 100}};
        System.out.println(new Solution699().fallingSquares(tmp));

        tmp = new int[][]{{4, 6}, {4, 2}, {4, 3}};
        System.out.println(new Solution699().fallingSquares(tmp));

        tmp = new int[][]{{5, 10}, {1, 7}, {1, 2}, {9, 3}, {1, 6}};
        System.out.println(new Solution699().fallingSquares(tmp));

        //这个用例，update()导致的节点分裂，子节点不能直接继承父节点的localMax，导致子节点的localMax=0，所以要同时维护height，max
        tmp = new int[][]{{5, 10}, {6, 1}, {8, 2}};
        System.out.println(new Solution699().fallingSquares(tmp));


        // [7, 16, 17]
        // [100, 100]
        // [6, 8, 11]
        // [0, 17, 19, 19, 25]
        // [10, 11, 12]
    }
}
