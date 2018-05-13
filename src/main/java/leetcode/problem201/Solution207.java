package leetcode.problem201;

import leetcode.problem301.NumArray;

import java.util.*;

/**
 * 207. Course Schedule
 */

public class Solution207 {
    public static void main(String[] args) {
        System.out.println(canFinish(2, new int[][]{{0, 1}, {1, 0}}));
        System.out.println(canFinish(2, new int[][]{{0, 1}}));
    }

    // 拓扑排序
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses < 2) return true;

        int preCounter[] = new int[numCourses];
        Map<Integer, Set<Integer>> g = new HashMap<>();
        for (int[] pair : prerequisites) {
            preCounter[pair[0]]++;
            if (!g.containsKey(pair[1])) g.put(pair[1], new HashSet<>());
            g.get(pair[1]).add(pair[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (preCounter[i] == 0) queue.offer(i);
        }

        int res = 0;
        while (!queue.isEmpty()) {
            int f = queue.poll();
            res++;
            if (!g.containsKey(f)) continue;
            for (int reqF : g.get(f)) {
                if (--preCounter[reqF] == 0) queue.offer(reqF);
            }
        }
        return res == numCourses;
    }

    // DFS Map + Set, 思路不错，cpp版本的比较快，Java版的比较慢
    // https://leetcode.com/problems/course-schedule/discuss/126917/C++-Topological-Sort-and-DFS-solutions-with-explanation
    // public static boolean canFinish(int numCourses, int[][] prerequisites) {
    //     if (numCourses < 2) return true;
    //
    //     Map<Integer, Set<Integer>> g = new HashMap<>();
    //     for (int[] pair : prerequisites) {
    //         if (!g.containsKey(pair[0])) g.put(pair[0], new HashSet<>());
    //         g.get(pair[0]).add(pair[1]);
    //     }
    //
    //     Set<Integer> visiting = new HashSet<>(), finished = new HashSet<>();
    //     for (int i = 0; i < numCourses; i++) {
    //         if (!dfs(i, g, visiting, finished)) return false;
    //     }
    //     return true;
    // }
    //
    // private static boolean dfs(int c, Map<Integer, Set<Integer>> g, Set<Integer> visiting, Set<Integer> finished) {
    //     if (visiting.contains(c)) return false;
    //     else if (!g.containsKey(c)) {
    //         finished.add(c);
    //         return true;
    //     }
    //     boolean flag;
    //     visiting.add(c);
    //     for (int prereq : g.get(c)) {
    //         // 一点优化
    //         if (!g.containsKey(prereq)) continue;
    //         if (visiting.contains(prereq)) return false;
    //
    //         flag = dfs(prereq, g, visiting, finished);
    //         if (!flag) return false;
    //     }
    //     visiting.remove(c);
    //     finished.add(c);
    //     return true;
    // }


    //	DFS 二维数组
    //	public boolean canFinish(int numCourses, int[][] prerequisites) {
    //		if (numCourses < 2) return true;
    //		int g[][] = new int[numCourses][numCourses];
    //		Set<Integer> set = new HashSet<>();
    //		for (int i = 0; i < numCourses; i++) set.add(i);
    //
    //		for (int[] pair : prerequisites) {
    //			g[pair[0]][pair[1]] = 1;
    //			set.remove(pair[0]);
    //		}
    //
    //		for (int i = 0; i < numCourses; i++) {
    //			if (!dfs(g, i, set)) return false;
    //		}
    //		return true;
    //	}
    //
    //	private boolean dfs(int[][] g, int c, Set<Integer> set) {
    //		if (set.contains(c)) return true;
    //
    //		boolean flag = true;
    //		for (int i = 0; flag && i < g.length; i++) {
    //			if (g[c][i] == 1) {
    //				g[c][i] = 2;
    //				flag = dfs(g, i, set);
    //				g[c][i] = 1;
    //			} else if (g[c][i] == 2) return false;
    //		}
    //		if (flag) set.add(c);
    //		return flag;
    //	}
    //
}