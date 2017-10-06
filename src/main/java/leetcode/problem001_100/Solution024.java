package leetcode.problem001_100;

import leetcode.util.ListNode;

/**
 * Created by joffre on 2017/9/30.
 * 24. Swap Nodes in Pairs
 */
public class Solution024 {
    public static ListNode swapPairs(ListNode head) {
        ListNode cur = head, next, pre = null;
        while (cur != null && cur.next != null) {
            if (cur == head) {
                head = cur.next;
            }
            next = cur.next;
            cur.next = next.next;
            next.next = cur;
            if (pre != null) {
                pre.next = next;
            }

            pre = cur;
            cur = cur.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode.printListNode(swapPairs(ListNode.parse(new int[]{1, 2, 3, 4, 5})));
    }
}
