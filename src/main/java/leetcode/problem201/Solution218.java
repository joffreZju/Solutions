package leetcode.problem201;

import java.util.*;

/**
 * 218. The Skyline Problem
 * https://blog.csdn.net/magicbean2/article/details/73613204
 */
public class Solution218 {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> heights = new ArrayList<>(), result = new ArrayList<>();
        for (int[] b : buildings) {
            heights.add(new int[]{b[0], -b[2]});
            heights.add(new int[]{b[1], b[2]});
        }
        heights.sort((a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            else return a[0] - b[0];
        });

        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        queue.offer(0);
        int preH = 0, curH = 0;
        for (int[] h : heights) {
            if (h[1] < 0) queue.offer(-h[1]);
            else queue.remove(h[1]);

            curH = queue.peek();
            if (curH != preH) {
                result.add(new int[]{h[0], curH});
                preH = curH;
            }
        }
        return result;
    }
}
