package offer;

import java.util.*;

/**
 * 剑指offer
 * 字符串的排列
 * 题目描述
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * 输入描述:
 * 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 */
public class Solution003 {
	public static ArrayList<String> Permutation(String str) {
		if (str.length() == 0) return new ArrayList<>();
		char[] cs = str.toCharArray();
		Arrays.sort(cs);
		ArrayList<String> res = new ArrayList<>();
		
		dfs(res, new StringBuilder(), cs, 0);
		res.sort(String::compareTo);
		
		//		dfs(res, new StringBuilder(), cs);
		return res;
	}
	
	// 解法一，swap实现回溯, abc -> cba, 会导致cba先加入结果集，cab后加入，所以需要最终将加过排序
	public static void dfs(ArrayList<String> res, StringBuilder sb, char[] cs, int start) {
		if (sb.length() == cs.length) {
			res.add(sb.toString());
			return;
		}
		for (int i = start; i < cs.length; i++) {
			// cs[i] == cs[start]时，会导致重复
			if (i > start && cs[i] == cs[start]) continue;
			sb.append(cs[i]);
			swap(cs, start, i);
			dfs(res, sb, cs, start + 1);
			swap(cs, start, i);
			sb.deleteCharAt(sb.length() - 1);
		}
	}
	
	public static void swap(char[] chars, int i, int j) {
		char c = chars[i];
		chars[i] = chars[j];
		chars[j] = c;
	}
	
	//	解法二，最终结果集不需要排序
	public static void dfs(ArrayList<String> res, StringBuilder sb, char[] cs) {
		if (sb.length() == cs.length) {
			res.add(sb.toString());
			return;
		}
		for (int i = 0; i < cs.length; i++) {
			if (cs[i] >= 255) continue;
			if (i > 0 && cs[i] == cs[i - 1] && cs[i - 1] < 255) continue;
			sb.append(cs[i]);
			cs[i] += 255;
			dfs(res, sb, cs);
			cs[i] -= 255;
			sb.deleteCharAt(sb.length() - 1);
		}
	}
	
	public static void main(String[] args) {
		System.out.println(Permutation("abc"));
	}
}