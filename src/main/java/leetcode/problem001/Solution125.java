package leetcode.problem001;

/**
 * 125. Valid Palindrome
 */
public class Solution125 {
	public static boolean isPalindrome(String s) {
		int l = 0, r = s.length() - 1;
		while (l < r) {
			char left = s.charAt(l), right = s.charAt(r);
			if (!Character.isLetterOrDigit(left)) {
				l++;
			} else if (!Character.isLetterOrDigit(right)) {
				r--;
			} else if (Character.toLowerCase(left) != Character.toLowerCase(right)) {
				return false;
			} else {
				l++;
				r--;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
		System.out.println(isPalindrome("race a car"));
	}
}

