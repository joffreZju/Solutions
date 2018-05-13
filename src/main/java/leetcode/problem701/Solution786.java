package leetcode.problem701;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 786. K-th Smallest Prime Fraction
 */
public class Solution786 {
    public static int[] kthSmallestPrimeFraction(int[] A, int K) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> A[a[0]] * A[b[1]] - A[a[1]] * A[b[0]]);
        boolean[][] used = new boolean[A.length][A.length];
        queue.offer(new int[]{0, A.length - 1});
        while (K > 0) {
            int[] cur = queue.poll();
            K--;
            if (K == 0) return new int[]{A[cur[0]], A[cur[1]]};
            if (!used[cur[0] + 1][cur[1]]) {
                used[cur[0] + 1][cur[1]] = true;
                queue.offer(new int[]{cur[0] + 1, cur[1]});
            }
            if (!used[cur[0]][cur[1] - 1]) {
                used[cur[0]][cur[1] - 1] = true;
                queue.offer(new int[]{cur[0], cur[1] - 1});
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(kthSmallestPrimeFraction(new int[]{1, 2, 3, 5}, 1)));
        System.out.println(Arrays.toString(kthSmallestPrimeFraction(new int[]{1, 2, 3, 5}, 2)));
        System.out.println(Arrays.toString(kthSmallestPrimeFraction(new int[]{1, 2, 3, 5}, 3)));
        System.out.println(Arrays.toString(kthSmallestPrimeFraction(new int[]{1, 2, 3, 5}, 4)));
        System.out.println(Arrays.toString(kthSmallestPrimeFraction(new int[]{1, 2, 3, 5}, 5)));
        System.out.println(Arrays.toString(kthSmallestPrimeFraction(new int[]{1, 2, 3, 5}, 6)));
    }
}
