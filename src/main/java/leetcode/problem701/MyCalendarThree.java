package leetcode.problem701;

/**
 * 732. My Calendar III
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(start,end);
 */

public class MyCalendarThree {
    private SegmentTree tree;

    public MyCalendarThree() {
        tree = new SegmentTree();
    }

    public int book(int start, int end) {
        return tree.addEvent(start, end - 1);
    }

    public static void main(String[] args) {
        MyCalendarThree calendarThree = new MyCalendarThree();
        System.out.println(calendarThree.book(10, 20)); // returns 1
        System.out.println(calendarThree.book(50, 60)); // returns 1
        System.out.println(calendarThree.book(10, 40)); // returns 2
        System.out.println(calendarThree.book(5, 15)); // returns 3
        System.out.println(calendarThree.book(5, 10)); // returns 3
        System.out.println(calendarThree.book(25, 55)); // returns 3
    }
}

class SegmentTree {
    private class Node {
        int left, right, mid, times;
        Node lchild, rchild;

        public Node(int left, int right, int times) {
            this.left = left;
            this.right = right;
            this.mid = left + (right - left) / 2;
            this.times = times;
        }
    }

    private Node root;
    private int curMaxTimes;

    SegmentTree() {
        root = new Node(0, 10_0000_0000, 0);
        curMaxTimes = 0;
    }

    public int addEvent(int start, int end) {
        addEvent(root, start, end);
        return curMaxTimes;
    }

    private void addEvent(Node root, int start, int end) {
        if (root == null) return;
        else if (start <= root.left && end >= root.right) {
            update(root, 1);
        } else if ((start >= root.left && start <= root.right) || (end >= root.left && end <= root.right)) {
            if (root.lchild == null) root.lchild = new Node(root.left, root.mid, root.times);
            addEvent(root.lchild, start, end);

            if (root.rchild == null) root.rchild = new Node(root.mid + 1, root.right, root.times);
            addEvent(root.rchild, start, end);
        }
    }

    private void update(Node root, int val) {
        if (root == null) return;
        root.times += val;
        curMaxTimes = Math.max(curMaxTimes, root.times);
        update(root.lchild, val);
        update(root.rchild, val);
    }
}
