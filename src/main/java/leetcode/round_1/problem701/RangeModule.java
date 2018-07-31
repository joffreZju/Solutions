package leetcode.round_1.problem701;

/**
 * 715. Range Module
 */
public class RangeModule {
    private class SegNode {
        int left, right, mid, exist;
        SegNode lchild, rchild;

        public SegNode(int left, int right, int exist) {
            this.left = left;
            this.right = right;
            this.mid = left + (right - left) / 2;
            this.exist = exist;
        }
    }

    private SegNode root;

    public RangeModule() {
        root = new SegNode(0, 1000_000_000, 0);
    }

    private boolean query(SegNode root, int left, int right) {
        if (root == null) return true;
        else if (left > root.right || right < root.left) return true;
            // 如果当前节点被查询区间完全包含，或者当前节点是叶子节点，那么只返回与当前节点重叠的部分即可
            // 同时避免了问题：叶子节点exist = 0应该返回false，但是左右子树都是null导致返回true
        else if ((left <= root.left && right >= root.right) || (root.lchild == null && root.rchild == null))
            return root.exist == 1;
        else return query(root.lchild, left, right) && query(root.rchild, left, right);
    }

    private void update(SegNode root, int left, int right, int status) {
        if (root == null) return;
        else if (left > root.right || right < root.left) return;
        else if (left <= root.left && right >= root.right) {
            root.exist = status;
            //这里可以将左右子区间合并，其实就是省去了向下传递的过程
            root.lchild = null;
            root.rchild = null;
        } else {
            if (root.lchild == null) root.lchild = new SegNode(root.left, root.mid, root.exist);
            update(root.lchild, left, right, status);
            // 这里使用闭区间，开区间也可以AC，但是好像稍微慢一些
            if (root.rchild == null) root.rchild = new SegNode(root.mid + 1, root.right, root.exist);
            update(root.rchild, left, right, status);

            // 注意这里要向上传递，更新完子节点之后，可能会影响到父节点的状态（例如子节点中exist=0的空缺被补齐）
            if (root.lchild.exist == root.rchild.exist) {
                root.exist = root.lchild.exist;
                // 注意这里不可以合并，即使root.exist = 0, 左右子树还可能有exist = 1的子节点
                // root.lchild = null;
                // root.rchild = null;
            } else {
                root.exist = 0;
            }
        }
    }

    public void addRange(int left, int right) {
        update(root, left, right - 1, 1);
    }

    public boolean queryRange(int left, int right) {
        return query(root, left, right - 1);
    }

    public void removeRange(int left, int right) {
        update(root, left, right - 1, 0);
    }

    public static void main(String[] args) {
        RangeModule range = new RangeModule();
        range.addRange(10, 20);
        range.removeRange(14, 16);
        System.out.println(range.queryRange(10, 14));
        System.out.println(range.queryRange(13, 15));
        System.out.println(range.queryRange(16, 17));
    }
}
