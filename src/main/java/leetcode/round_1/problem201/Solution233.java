package leetcode.round_1.problem201;

/**
 * 233. Number of Digit One
 */
public class Solution233 {
    public int countDigitOne(int n) {
        int sum = 0;
        for (long i = 1; i <= n; i *= 10) {
            long div = i * 10;
            sum += (n / div) * i;
            // 碎片: 2xx, 在计算十位上的 1 的个数时(i = 10)：xx(00~0x~1x~20~99)值不同时，那么十位上 1 的个数不相同，但是最多10个。
            long chip = Math.max(n % div - i + 1, 0);
            sum += Math.min(chip, i);
        }
        return sum;
    }
}
