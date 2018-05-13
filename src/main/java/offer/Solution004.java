package offer;

/**
 * 输入两个链表，找出它们的第一个公共结点。
 */

import leetcode.util.ListNode;

import java.util.*;

public class Solution004 {
    //方法3：计算两个链表的长度，让长链表的指针先走 len2-len1 的长度，然后两个指针一起走，知道相遇。

    //方法2: p1 p2 都走了len1 + len2的长度，最终相遇
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode p1 = pHead1, p2 = pHead2;
        while (p1 != p2) {
            if (p1 == null) p1 = pHead2;
            else p1 = p1.next;
            if (p2 == null) p2 = pHead1;
            else p2 = p2.next;
        }
        return p1;
    }


    // 方法1
    // public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
    //     Set<ListNode> set = new HashSet<>();
    //     ListNode p1 = pHead1, p2 = pHead2;
    //     while (p1 != null || p2 != null) {
    //         if (p1 != null) {
    //             if (!set.add(p1)) return p1;
    //             p1 = p1.next;
    //         }
    //         if (p2 != null) {
    //             if (!set.add(p2)) return p2;
    //             p2 = p2.next;
    //         }
    //     }
    //     return null;
    // }
}

