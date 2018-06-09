package leetcode.problem201;

import java.util.*;

/**
 * 210. Course Schedule II
 */
public class Solution210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        int reqCounter[] = new int[numCourses];
        for (int[] req : prerequisites) {
            reqCounter[req[0]]++;
            if (!graph.containsKey(req[1])) graph.put(req[1], new HashSet<>());
            graph.get(req[1]).add(req[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (reqCounter[i] == 0) queue.offer(i);
        }

        int res[] = new int[numCourses], index = 0;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            res[index++] = cur;
            if (!graph.containsKey(cur)) continue;
            for (int t : graph.get(cur)) {
                if (--reqCounter[t] == 0) queue.offer(t);
            }
        }
        if (index < numCourses) return new int[0];
        else return res;
    }
}
