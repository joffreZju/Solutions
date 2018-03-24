package leetcode.problem001;


import leetcode.util.ListNode;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 23. Merge k Sorted Lists
 */
public class Solution023 {
    // 最小堆
    // public ListNode mergeKLists(ListNode[] lists) {
    //     if (lists == null || lists.length == 0) return null;
    //     PriorityQueue<ListNode> queue = new PriorityQueue<>((a, b) -> a.val - b.val);
    //     for (ListNode head : lists) {
    //         if (head != null)
    //             queue.offer(head);
    //     }
    //     ListNode fake = new ListNode(0), cur = fake;
    //     while (queue.size() > 1) {
    //         ListNode min = queue.poll();
    //         cur.next = min;
    //         cur = cur.next;
    //         if (min.next != null) queue.offer(min.next);
    //     }
    //     cur.next = queue.poll();
    //     return fake.next;
    // }


    // 归并
    // public ListNode mergeKLists(ListNode[] lists) {
    //     if (lists == null || lists.length == 0) return null;
    //     int end = lists.length - 1;
    //     while (end > 0) {
    //         int begin = 0;
    //         while (begin < end) {
    //             lists[begin] = mergeTwo(lists[begin], lists[end]);
    //             begin++;
    //             end--;
    //         }
    //     }
    //     return lists[0];
    // }

    // 归并 递归
    // public ListNode mergeKLists(ListNode[] lists) {
    //     if (lists == null || lists.length == 0) return null;
    //     return partition(lists, 0, lists.length - 1);
    // }
    //
    // private static ListNode partition(ListNode[] lists, int begin, int end) {
    //     if (begin > end) return null;
    //     else if (begin == end) return lists[begin];
    //     else {
    //         int mid = begin + (end - begin) / 2;
    //         return mergeTwo(partition(lists, begin, mid), partition(lists, mid + 1, end));
    //     }
    // }

    // 每次挑上一轮未合并过的链表进行合并
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        Queue<ListNode> queue = new LinkedList<>();
        for (ListNode node : lists) queue.offer(node);

        while (queue.size() > 1) {
            queue.offer(mergeTwo(queue.poll(), queue.poll()));
        }
        return queue.peek();
    }

    // 依赖方法
    private static ListNode mergeTwo(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0), cur = head;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if (l1 != null) cur.next = l1;
        else if (l2 != null) cur.next = l2;
        return head.next;
    }
}
