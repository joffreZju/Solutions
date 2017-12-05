package leetcode.problem201;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by joffre on 2017/11/29.
 * 228. Summary Ranges
 */
public class Solution228 {
    public static List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        int begin = 0;
        for (int i = 1; i <= nums.length; i++) {
            if (i == nums.length || nums[i] != nums[i - 1] + 1) {
                StringBuilder sb = new StringBuilder();
                sb.append(nums[begin]);
                if (i - 1 > begin) sb.append("->").append(nums[i - 1]);
                res.add(sb.toString());
                begin = i;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(summaryRanges(new int[]{0, 1, 2, 4, 5, 7}));
        System.out.println(summaryRanges(new int[]{0, 2, 3, 4, 6, 8, 9}));
    }
}
