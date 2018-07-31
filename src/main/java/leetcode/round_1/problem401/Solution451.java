package leetcode.round_1.problem401;

import java.util.*;

/**
 * 451. Sort Characters By Frequency
 */
public class Solution451 {
    /**
     * O(NLogN)
     */
    public static String frequencySort(String s) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        PriorityQueue<Map.Entry<Character, Integer>> queue = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

        for (int i = 0; i < s.length(); i++) {
            hashMap.put(s.charAt(i), hashMap.getOrDefault(s.charAt(i), 0) + 1);
        }
        queue.addAll(hashMap.entrySet());

        StringBuilder sb = new StringBuilder();
        while (queue.size() > 0) {
            Map.Entry<Character, Integer> entry = queue.poll();
            for (int i = 0; i < entry.getValue(); i++) {
                sb.append(entry.getKey());
            }
        }
        return sb.toString();
    }

    /**
     * o(N)
     */
    public static String frequencySortOn(String s) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        TreeMap<Integer, List<Character>> treeMap = new TreeMap<>();

        for (int i = 0; i < s.length(); i++) {
            hashMap.put(s.charAt(i), hashMap.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (Character c : hashMap.keySet()) {
            if (!treeMap.containsKey(hashMap.get(c))) {
                treeMap.put(hashMap.get(c), new ArrayList<>());
            }
            treeMap.get(hashMap.get(c)).add(c);
        }

        StringBuilder sb = new StringBuilder();
        while (treeMap.size() > 0) {
            Map.Entry<Integer, List<Character>> entry = treeMap.pollLastEntry();
            for (char c : entry.getValue()) {
                for (int i = 0; i < entry.getKey(); i++) {
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(frequencySort("tree"));
        System.out.println(frequencySort("cccaaa"));
        System.out.println(frequencySort("Aabb"));
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);
    }
}
