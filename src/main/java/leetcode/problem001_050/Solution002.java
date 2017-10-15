package leetcode.problem001_050;

import leetcode.util.ListNode;

/**
 * Created by joffre on 2017/9/20.
 * 2. Add Two Numbers
 */
public class Solution002 {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode curNode = res;
        int cur = 0;
        while (l1 != null || l2 != null || cur != 0) {
            if (l1 != null) {
                cur += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                cur += l2.val;
                l2 = l2.next;
            }
            curNode.val = cur % 10;
            cur /= 10;
            if (!(l1 != null || l2 != null || cur != 0)) {
                break;
            }
            curNode.next = new ListNode(0);
            curNode = curNode.next;
        }
        return res;
    }

    public static void main(String[] args) {
        ListNode l1 = ListNode.parse(new int[]{2, 4, 3});
        ListNode l2 = ListNode.parse(new int[]{5, 6, 9});
        ListNode res = addTwoNumbers(l1, l2);
        ListNode.printListNode(res);
    }
}
