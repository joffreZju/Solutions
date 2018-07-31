package leetcode.round_1.problem601;

import java.util.*;

/**
 * 692. Top K Frequent Words
 */
public class Solution692 {
    public static List<String> topKFrequentBucket(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String w : words) map.put(w, map.getOrDefault(w, 0) + 1);

        int maxKey = 0;
        Map<Integer, List<String>> bucket = new HashMap<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            maxKey = Math.max(maxKey, entry.getValue());
            if (!bucket.containsKey(entry.getValue())) {
                bucket.put(entry.getValue(), new ArrayList<>());
            }
            bucket.get(entry.getValue()).add(entry.getKey());
        }

        List<String> res = new ArrayList<>();
        int tmp = k;
        while (tmp > 0) {
            if (bucket.containsKey(maxKey)) {
                Collections.sort(bucket.get(maxKey));
                res.addAll(bucket.get(maxKey));
                tmp -= bucket.get(maxKey).size();
            }
            maxKey--;
        }
        return res.subList(0, k);
    }

    public static List<String> topKFrequentPriorityQueue(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String w : words) map.put(w, map.getOrDefault(w, 0) + 1);

        // 匿名类比lambda执行要快很多 WTF
        PriorityQueue<Map.Entry<String, Integer>> queue = new PriorityQueue<>(
                new Comparator<Map.Entry<String, Integer>>() {
                    @Override
                    public int compare(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b) {
                        if (a.getValue().equals(b.getValue())) return a.getKey().compareTo(b.getKey());
                        return b.getValue() - a.getValue();
                    }
                });
        // PriorityQueue<Map.Entry<String, Integer>> queue = new PriorityQueue<>((a, b) -> {
        //     if (a.getValue().equals(b.getValue())) return a.getKey().compareTo(b.getKey());
        //     return b.getValue() - a.getValue();
        // });
        queue.addAll(map.entrySet());

        List<String> res = new ArrayList<>();
        while (k-- > 0) {
            res.add(queue.poll().getKey());
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(topKFrequentBucket(new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"}, 4));
        System.out.println(topKFrequentBucket(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 1));
        System.out.println(topKFrequentBucket(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 2));

        System.out.println(topKFrequentPriorityQueue(new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"}, 4));
        System.out.println(topKFrequentPriorityQueue(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 1));
        System.out.println(topKFrequentPriorityQueue(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 2));
    }
}
