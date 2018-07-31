package leetcode.round_1.problem801;

import java.util.*;

/**
 * 847. Shortest Path Visiting All Nodes
 */
public class Solution847 {
    // 1、dp[i][j] 表示经由 i 到达状态 j 的最短路径，j 用二进制表示已经访问的节点
    // 2、例如 dp[1][3] -> dp[1][...011] 可以表示：由 dp[0][...001] 到达 dp[1][...011] 的最短距离
    // 3、初始状态为 dp[i][1<<i] = 0 (0<= i < n)
    // 4、然后从每一个初始状态开始进行BFS搜索，知道某个时刻 j == (1<<n) - 1, BFS结束
    // 5、由于是BFS，所以只要 j == (1<<n) - 1, 就是最短路劲即可结束搜索
    public static int shortestPathLength(int[][] graph) {
        int n = graph.length, dp[][] = new int[n][1 << n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
            dp[i][1 << i] = 0;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, bfs(dp, graph, i));
        }
        return min;
    }

    private static int bfs(int[][] dp, int[][] graph, int start) {
        int n = graph.length;
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(start, 1 << start));

        while (!queue.isEmpty()) {
            Pair cur = queue.poll();
            if (cur.visited == (1 << n) - 1) return dp[cur.vertex][cur.visited];

            for (int neighbor : graph[cur.vertex]) {
                int newVisited = cur.visited | 1 << neighbor;
                if (dp[neighbor][newVisited] > dp[cur.vertex][cur.visited] + 1) {
                    dp[neighbor][newVisited] = dp[cur.vertex][cur.visited] + 1;
                    queue.offer(new Pair(neighbor, newVisited));
                }
            }
        }
        return Integer.MAX_VALUE;
    }

    private static class Pair {
        int vertex, visited;

        Pair(int vertex, int visited) {
            this.vertex = vertex;
            this.visited = visited;
        }
    }

    public static void main(String[] args) {
        int[][] graph = new int[][]{{1, 2, 3}, {0}, {0}, {0}};
        System.out.println(shortestPathLength(graph));
    }
}
