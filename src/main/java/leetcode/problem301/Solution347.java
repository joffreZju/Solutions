package leetcode.problem301;

import java.util.*;

/**
 * 347. Top K Frequent Elements
 */
public class Solution347 {
    public static List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        queue.addAll(countMap.entrySet());
        for (int i = 0; i < k; i++) res.add(queue.poll().getKey());
        return res;
    }

    public static List<Integer> topKFrequentAgain(int[] nums, int k) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums) hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);

        List<Integer>[] freq = new List[nums.length + 1];
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            if (freq[entry.getValue()] == null) {
                freq[entry.getValue()] = new ArrayList<>();
            }
            freq[entry.getValue()].add(entry.getKey());
        }

        List<Integer> res = new ArrayList<>();
        for (int i = nums.length; i > 0 && res.size() < k; i--) {
            if (freq[i] != null) res.addAll(freq[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(topKFrequent(new int[]{1, 2, 3, 1, 2, 1}, 2));
        System.out.println(topKFrequent(new int[]{1, 2}, 2));
        System.out.println(topKFrequent(new int[]{1}, 1));

        System.out.println(topKFrequentAgain(new int[]{1, 2, 3, 1, 2, 1}, 2));
        System.out.println(topKFrequentAgain(new int[]{1, 2}, 2));
        System.out.println(topKFrequentAgain(new int[]{1}, 1));
    }
}
