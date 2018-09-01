package basicAlgorithms;


import java.util.PriorityQueue;

public class Dijkstra {
    // node label: 0 - n-1
    // graph[i][j] = Integer.MAX_VALUE, i j 不可达
    public void dijkstra(int[][] graph, int start) {
        int n = graph.length;
        int distance[] = new int[n];
        int prev[] = new int[n];
        boolean visited[] = new boolean[n];

        for (int i = 0; i < n; i++) {
            distance[i] = graph[start][i];
            if (distance[i] == Integer.MAX_VALUE) {
                prev[i] = -1;
            } else {
                prev[i] = start;
            }
        }
        distance[start] = 0;
        visited[start] = true;

        for (int i = 1; i < n; i++) {
            int minDis = Integer.MAX_VALUE, node = start;
            for (int j = 0; j < n; j++) {
                if (!visited[j] && distance[j] < minDis) {
                    minDis = distance[j];
                    node = j;
                }
            }
            visited[node] = true;

            for (int j = 0; j < n; j++) {
                if (!visited[j] && graph[node][j] != Integer.MAX_VALUE) {
                    if (distance[j] > distance[node] + graph[node][j]) {
                        distance[j] = distance[node] + graph[node][j];
                        prev[j] = node;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        new PriorityQueue<>().poll();
    }
}
