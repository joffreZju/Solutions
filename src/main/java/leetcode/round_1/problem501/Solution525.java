package leetcode.round_1.problem501;

import java.util.HashMap;
import java.util.Map;

/**
 * 525. Contiguous Array
 */
public class Solution525 {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int zero = 0, one = 0, max = 0;
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) zero++;
            else one++;

            if (map.containsKey(zero - one)) max = Math.max(max, i - map.get(zero - one));
            else map.put(zero - one, i);
        }
        return max;
    }
}
