package company.indeed;

import java.util.LinkedList;
import java.util.Scanner;

// 没有AC， Runtime error
public class Main2 {
    private static class Node {
        int index;
        double rate;

        public Node(int index, double rate) {
            this.index = index;
            this.rate = rate;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), m = in.nextInt();
        int matrix[][] = new int[n][n], counter[] = new int[n];
        for (int i = 0; i < m; i++) {
            int r = in.nextInt() - 1;
            matrix[r][in.nextInt() - 1] = 1;
            counter[r]++;
        }

        LinkedList<Node> queue = new LinkedList<>();
        queue.offer(new Node(0, 1));

        double res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (node.index == n - 1) res += node.rate;
                else if (counter[node.index] > 0) {
                    for (int j = node.index + 1; j < n; j++) {
                        if (matrix[node.index][j] == 1) {
                            queue.offer(new Node(j, node.rate / counter[node.index]));
                        }
                    }
                }
            }
        }
        System.out.println(res);
    }
}
