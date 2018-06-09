package hihocoder;

import java.util.*;

public class Main_1077 {
    //线段树，超时
    private static class SegNode {
        int left, right, mid, minW;

        public SegNode(int left, int right) {
            this.left = left;
            this.right = right;
            this.mid = left + (right - left) / 2;
        }
    }

    private static SegNode[] tree;

    private static int build(int root, int left, int right, int[] weights) {
        tree[root] = new SegNode(left, right);
        if (left == right) {
            tree[root].minW = weights[left];
            return tree[root].minW;
        }

        int mid = tree[root].mid;
        int curW = Math.min(build(root * 2, left, mid, weights),
                build(root * 2 + 1, mid + 1, right, weights));
        tree[root].minW = curW;
        return curW;
    }

    private static void update(int root, int index, int w) {
        if (index == tree[root].left && index == tree[root].right) {
            tree[root].minW = w;
            return;
        }
        int mid = tree[root].mid;
        if (index <= mid) {
            update(root * 2, index, w);
        } else {
            update(root * 2 + 1, index, w);
        }
        tree[root].minW = Math.min(tree[root * 2].minW, tree[root * 2 + 1].minW);
    }

    private static int findMin(int root, int left, int right) {
        int mid = tree[root].mid;

        if (tree[root].left == left && tree[root].right == right) {
            return tree[root].minW;
        } else if (right <= mid) {
            return findMin(root * 2, left, right);
        } else if (left > mid) {
            return findMin(root * 2 + 1, left, right);
        } else {
            return Math.min(findMin(root * 2, left, mid), findMin(root * 2 + 1, mid + 1, right));
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(
                System.in
                // "10\n" +
                //         "3655 5246 8991 5933 7474 7603 6098 6654 2414 884 \n" +
                //         "6\n" +
                //         "0 4 9\n" +
                //         "0 2 10\n" +
                //         "1 4 7009\n" +
                //         "0 5 6\n" +
                //         "1 3 7949\n" +
                //         "1 3 1227"
        );
        int n = in.nextInt(), weight[] = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            weight[i] = in.nextInt();
        }
        tree = new SegNode[3 * (n + 1)];
        build(1, 1, n, weight);

        int q = in.nextInt(), op[] = new int[3];
        for (int i = 0; i < q; i++) {
            op[0] = in.nextInt();
            op[1] = in.nextInt();
            op[2] = in.nextInt();
            if (op[0] == 0) {
                System.out.println(findMin(1, op[1], op[2]));
            } else {
                update(1, op[1], op[2]);
            }
        }
    }
}
