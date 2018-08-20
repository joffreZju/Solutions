package leetcode.round_2.problem401;

import leetcode.util.ListNode;

/**
 * 445. Add Two Numbers II
 * 也可以用 stack 处理
 */
public class Solution445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int len1 = getLen(l1), len2 = getLen(l2);
        if (len1 < len2) return addTwoNumbers(l2, l1);

        //将 l1 的末尾一部分和 l2 相加，结果存储在 l1 上
        ListNode cur = l1;
        for (int i = 0; i < len1 - len2; i++) {
            cur = cur.next;
        }
        add(cur, l2);
        if (cur.val < 10) return l1;


        // 处理 cur 节点上的进位，将其传递到 l1 的 head 上
        ListNode next = cur.next;
        cur.next = null;
        int carry = getCarry(l1);
        if (carry > 0) {
            ListNode head = new ListNode(carry);
            head.next = l1;
            l1 = head;
        }
        cur.next = next;
        return l1;
    }

    // 将链表最末尾的一个节点的进位传递到链表头
    private int getCarry(ListNode node) {
        if (node.next == null) {
            int carry = node.val / 10;
            node.val %= 10;
            return carry;
        }
        int carry = getCarry(node.next), res = (node.val + carry) / 10;
        node.val = (node.val + carry) % 10;
        return res;
    }

    // 递归将两个长度相等的 List 相加，不处理最高位的进位，留给调用者处理
    private void add(ListNode l1, ListNode l2) {
        if (l1.next == null) {
            l1.val += l2.val;
            return;
        }
        add(l1.next, l2.next);
        l1.val += l2.val + l1.next.val / 10;
        l1.next.val %= 10;
    }

    private int getLen(ListNode head) {
        ListNode cur = head;
        int len = 0;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        return len;
    }
}
