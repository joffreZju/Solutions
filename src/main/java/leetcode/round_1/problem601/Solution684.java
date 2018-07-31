package leetcode.round_1.problem601;

import java.util.HashSet;
import java.util.Set;

/**
 * 684. Redundant Connection
 */
public class Solution684 {
    //    并查集
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] path = new int[n + 1], rank = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            path[i] = i;
            rank[i] = 0;
        }
        for (int i = 0; i < n; i++) {
            int x = edges[i][0], y = edges[i][1], rx = find(path, x), ry = find(path, y);
            if (rx == ry) return edges[i];
            else merge(path, rank, rx, ry);
        }
        return null;
    }

    private static void merge(int[] path, int[] rank, int rx, int ry) {
        if (rx == ry) return;
        if (rank[rx] > rank[ry]) {
            path[ry] = rx;
            rank[rx]++;
        } else {
            path[rx] = ry;
            rank[ry]++;
        }
    }

    private static int find(int[] path, int x) {
        int root = x;
        while (path[root] != root) {
            root = path[root];
        }
        int i = x;
        while (path[i] != root) {
            int tmp = path[i];
            path[i] = root;
            i = tmp;
        }
        return root;
    }

}
