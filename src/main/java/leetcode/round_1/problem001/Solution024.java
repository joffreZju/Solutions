package leetcode.round_1.problem001;

import leetcode.util.ListNode;

/**
 * Created by joffre on 2017/9/30.
 * 24. Swap Nodes in Pairs
 */
public class Solution024 {
    public static ListNode swapPairs(ListNode head) {
        ListNode fake = new ListNode(-1), pre = fake;
        fake.next = head;
        while (pre.next != null && pre.next.next != null) {
            ListNode l1 = pre.next, l2 = pre.next.next;
            l1.next = l2.next;
            l2.next = l1;
            pre.next = l2;

            pre = l1;
        }
        return fake.next;
    }

    public static void main(String[] args) {
        ListNode.printListNode(swapPairs(ListNode.parse(new int[]{1, 2, 3, 4, 5})));
    }
}
