package leetcode.problem101;

import leetcode.util.RandomListNode;

public class Solution138 {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return null;
        RandomListNode p = head, node;
        while (p != null) {
            node = new RandomListNode(p.label);
            node.next = p.next;
            p.next = node;
            p = node.next;
        }
        p = head;
        while (p != null) {
            if (p.random != null) p.next.random = p.random.next;
            p = p.next.next;
        }

        // 这里注意：拆分的时候要将原链表还原，同时间新链表拆分出来。
        RandomListNode clone = head.next;
        p = head;
        while (p.next != null) {
            node = p.next;
            p.next = p.next.next;
            p = node;
        }
        return clone;
    }
}
