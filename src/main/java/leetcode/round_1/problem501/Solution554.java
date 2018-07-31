package leetcode.round_1.problem501;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 554. Brick Wall
 */
public class Solution554 {
    /**
     * 扫描每一行所有缝隙的位置，统计每个位置在所有行的缝隙数目，找到缝隙最多的那个位置，从那个位置画垂线穿越的砖块数目最少。
     */
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> map = new HashMap<>();
        for (List<Integer> row : wall) {
            int x = 0;
            for (int i = 0; i < row.size() - 1; i++) {
                x += row.get(i);
                map.put(x, map.getOrDefault(x, 0) + 1);
            }
        }
        int maxLoc = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            maxLoc = Math.max(maxLoc, entry.getValue());
        }
        return wall.size() - maxLoc;
    }
}
