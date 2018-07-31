package leetcode.round_1.problem801;

import java.util.*;

public class Solution850_2 {
    // 线段树 + 扫描线 + 离散化, 计算交叉矩形面积
    private static class SegNode {
        int left, right, mid, count;
        SegNode lchild, rchild;

        SegNode(int left, int right, int count) {
            this.left = left;
            this.right = right;
            this.count = count;
            this.mid = left + (right - left) / 2;
        }
    }

    private static class LineX {
        int x1, x2, height, tag;

        LineX(int x1, int x2, int height, int tag) {
            this.x1 = x1;
            this.x2 = x2;
            this.height = height;
            this.tag = tag;
        }
    }

    private static int[] map;

    private static int getCover(SegNode root) {
        if (root == null) return 0;
        else if (root.count > 0) return map[root.right] - map[root.left];
        else return getCover(root.lchild) + getCover(root.rchild);
    }

    private static void update(SegNode root, int left, int right, int val) {
        if (root == null || left >= root.right || right <= root.left) return;
        if (left <= root.left && right >= root.right) {
            root.count += val;
            update(root.lchild, left, right, val);
            update(root.rchild, left, right, val);
        } else {
            if (root.lchild == null) root.lchild = new SegNode(root.left, root.mid, root.count);
            update(root.lchild, left, right, val);
            if (root.rchild == null) root.rchild = new SegNode(root.mid, root.right, root.count);
            update(root.rchild, left, right, val);
        }
    }

    public static int rectangleArea(int[][] rectangles) {
        TreeSet<Integer> xset = new TreeSet<>();
        List<LineX> lines = new ArrayList<>();
        for (int[] rec : rectangles) {
            xset.add(rec[0]);
            xset.add(rec[2]);
            lines.add(new LineX(rec[0], rec[2], rec[1], 1));
            lines.add(new LineX(rec[0], rec[2], rec[3], -1));
        }
        lines.sort((a, b) -> {
            if (a.height != b.height) return a.height - b.height;
            else return b.tag - a.tag;
        });

        Map<Integer, Integer> x2i = new HashMap<>();
        map = new int[xset.size()];
        int index = 0;
        for (int x : xset) {
            x2i.put(x, index);
            map[index++] = x;
        }

        long res = 0;
        SegNode root = new SegNode(0, index - 1, 0);
        for (int i = 0; i < lines.size() - 1; i++) {
            LineX line = lines.get(i);
            update(root, x2i.get(line.x1), x2i.get(line.x2), line.tag);
            res += (getCover(root) * (long) (lines.get(i + 1).height - line.height));
        }
        return (int) (res % 10_0000_0007);
    }


    public static void main(String[] args) {
        System.out.println(rectangleArea(new int[][]{{0, 0, 2, 2}, {1, 0, 2, 3}, {1, 0, 3, 1}}));
        System.out.println(rectangleArea(new int[][]{{0, 0, 1000000000, 1000000000}}));
    }
}
