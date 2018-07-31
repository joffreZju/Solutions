package leetcode.round_1.problem301;

import leetcode.util.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 382. Linked List Random Node
 */
public class Solution382 {
    private ListNode begin;

    public Solution382(ListNode head) {
        begin = head;
        while (head.next != null) {
            head = head.next;
        }
        head.next = begin;
    }

    public int getRandom() {
        for (int i = 0; i < (int) (Math.random() * 10); i++) {
            begin = begin.next;
        }
        return begin.val;
    }
}
