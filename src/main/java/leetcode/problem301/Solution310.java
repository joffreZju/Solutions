package leetcode.problem301;

import java.util.*;

/**
 * 310. Minimum Height Trees
 */
public class Solution310 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n <= 1) return Arrays.asList(0);

        Map<Integer, Set<Integer>> graph = new HashMap<>();
        int degree[] = new int[n];
        for (int e[] : edges) {
            if (!graph.containsKey(e[0])) graph.put(e[0], new HashSet<>());
            if (!graph.containsKey(e[1])) graph.put(e[1], new HashSet<>());
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
            degree[e[0]]++;
            degree[e[1]]++;
        }

        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) {
                queue.add(i);
            }
        }
        while (n > 2) {
            int size = queue.size();
            n -= size;
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                for (int v : graph.get(cur)) {
                    if (--degree[v] == 1) queue.offer(v);
                    graph.get(v).remove(cur);
                }
                graph.remove(cur);
            }
        }
        return queue;
    }
}
