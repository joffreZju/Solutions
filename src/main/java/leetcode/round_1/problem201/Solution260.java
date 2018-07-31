package leetcode.round_1.problem201;

/**
 * 260. Single Number III
 */
public class Solution260 {
    /**
     * 假设结果为num1 num2
     * xor = num1 ^ num2
     * xor最低位的一个1说明num1 num2在这一位不同。
     */
    public int[] singleNumber(int[] nums) {
        int[] res = new int[2];
        int xor = 0;
        for (int num : nums) xor ^= num;
        int last_1_Bit = xor & ~(xor - 1);
        for (int num : nums) {
            if ((num & last_1_Bit) == 0) {
                res[0] ^= num;
            } else {
                res[1] ^= num;
            }
        }
        return res;
    }

}
