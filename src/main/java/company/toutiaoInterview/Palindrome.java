package company.toutiaoInterview;

import leetcode.util.ListNode;

public class Palindrome {
	public boolean isPalindrome(ListNode pHead) {
		// write code here
		if (pHead == null || pHead.next == null) return true;
		ListNode pre = null, slow = pHead, slowNext = slow.next, fast = pHead;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow.next = pre;
			pre = slow;
			slow = slowNext;
			slowNext = slowNext.next;
		}
		if (fast != null) slow = slow.next;
		while (slow != null && pre != null) {
			if (slow.val != pre.val) return false;
			slow = slow.next;
			pre = pre.next;
		}
		return true;
	}
}