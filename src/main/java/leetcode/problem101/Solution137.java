package leetcode.problem101;

/**
 * 137. Single Number II
 */
public class Solution137 {
    public static int singleNumber(int[] nums) {
        // 统计所有数字中在32位上1的出现次数，如果某一位上次数不是3的整数倍，那么res在该位置是1
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int sum = 0;
            for (int num : nums) {
                if (((num >> i) & 1) == 1) {
                    sum++;
                }
            }
            if (sum % 3 != 0) {
                res |= (1 << i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{1, 2, 3, 1, 2, 3, 1, 2}));
    }
}
