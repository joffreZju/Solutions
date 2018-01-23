package leetcode.problem401;

import java.util.HashSet;
import java.util.Set;

/**
 * 421. Maximum XOR of Two Numbers in an Array
 */
public class Solution421 {
    private static class TrieNode {
        TrieNode[] children;

        TrieNode() {
            this.children = new TrieNode[2];
        }
    }

    public static int findMaximumXOR(int[] nums) {
        /**
         * https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/discuss/91059/
         * 因为只有0、1，所以这里的Trie是二叉树，高度为32，所有叶子节点都在最后一层
         */
        TrieNode root = new TrieNode();
        for (int num : nums) {
            TrieNode cur = root;
            for (int i = 31; i >= 0; i--) {
                int curBit = (num >> i) & 1;
                if (cur.children[curBit] == null) {
                    cur.children[curBit] = new TrieNode();
                }
                cur = cur.children[curBit];
            }
        }

        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            TrieNode cur = root;
            int tmp = 0;
            for (int i = 31; i >= 0; i--) {
                int curBit = (num >> i) & 1;
                if (cur.children[curBit ^ 1] != null) {
                    tmp |= (1 << i);
                    cur = cur.children[curBit ^ 1];
                } else {
                    cur = cur.children[curBit];
                }
            }
            max = Math.max(max, tmp);
        }
        return max;
    }

    // 位运算
    public static int findMaximumXORBit(int[] nums) {
        /**
         * https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/discuss/91049/
         * @lsy1991121用户的explaination
         */
        int tool = 0, maxXOR = 0;
        for (int i = 31; i >= 0; i--) {
            // tool: 1000...000, 1100...000, 1110...000,,,1111...110, 1111...111
            tool |= (1 << i);

            // 将每一个数的左边部分add set
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                int leftPart = num & tool;
                set.add(leftPart);
            }

            // 假设当前位是1，看是否可以找到两个数(第一轮循环先找最高位)XOR使得当前位是1, 原理是 a ^ b = c => a ^ c = b
            int greedyMaxXOR = maxXOR | (1 << i);
            for (int num : set) {
                int anotherNum = num ^ greedyMaxXOR;
                if (set.contains(anotherNum)) {
                    // 因为 set.contains(num) = true; set.contains(anotherNum) = true; greedyMaxXOR = num ^ anotherNum;
                    // 所以修改 maxXOR = greedyMaxXOR
                    maxXOR = greedyMaxXOR;
                    break;
                }
            }
        }
        return maxXOR;
    }


    public static void main(String[] args) {
        System.out.println(findMaximumXOR(new int[]{3, 10, 5, 25, 2, 8}));
        System.out.println(findMaximumXORBit(new int[]{3, 10, 5, 25, 2, 8}));
    }
}
