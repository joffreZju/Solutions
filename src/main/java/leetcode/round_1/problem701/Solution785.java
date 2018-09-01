package leetcode.round_1.problem701;

/**
 * 785. Is Graph Bipartite?
 */
public class Solution785 {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length, color[] = new int[n];

        for (int i = 0; i < n; i++) {
            if (color[i] == 0 && !dfs(graph, color, i, 1)) return false;
        }
        return true;
    }

    private boolean dfs(int[][] graph, int[] color, int i, int curColor) {
        if (color[i] != 0) {
            return color[i] == curColor;
        }
        color[i] = curColor;
        for (int j : graph[i]) {
            if (!dfs(graph, color, j, 0 - curColor)) return false;
        }
        return true;
    }
}
