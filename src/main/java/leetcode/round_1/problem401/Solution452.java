package leetcode.round_1.problem401;

import java.util.Arrays;

/**
 * 452. Minimum Number of Arrows to Burst Balloons
 * 注意特殊情况
 * ----------------------
 *  -------
 *           ---------
 */
public class Solution452 {

    // Solution1: 按照end排序
    // public int findMinArrowShots(int[][] points) {
    //     if (points.length == 0) return 0;
    //     Arrays.sort(points, (a, b) -> (a[1] - b[1]));
    //     int cur = points[0][1], res = 1;
    //     for (int i = 1; i < points.length; i++) {
    //         if (points[i][0] <= cur) continue;
    //         cur = points[i][1];
    //         res++;
    //     }
    //     return res;
    // }

    // Solution2: 按照start排序
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;
        Arrays.sort(points, (a, b) -> (a[0] - b[0]));

        int res = 1, len = points.length, cur = points[len - 1][0];
        for (int i = len - 1; i >= 0; i--) {
            if (points[i][1] >= cur) continue;
            cur = points[i][0];
            res++;
        }
        return res;
    }
}
