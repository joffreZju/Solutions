package leetcode.round_1.problem401;


/**
 * 414. Third Maximum Number
 */
public class Solution414 {
    public static int thirdMax(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int i : nums) {
            if (i < min) min = i;
        }

        int m1 = min, m2 = m1, m3 = m1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == m1 || nums[i] == m2 || nums[i] == m3) continue;

            int tmp1 = m1, tmp2 = m2;

            if (nums[i] > m1) {
                m1 = nums[i];
                m2 = tmp1;
                m3 = tmp2;
            } else if (nums[i] > m2) {
                m2 = nums[i];
                m3 = tmp2;
            } else if (nums[i] > m3) {
                m3 = nums[i];
            }
        }
        if (m2 == m3 || m1 == m2) return m1;
        else return m3;
    }

    public static void main(String[] args) {
        System.out.println(thirdMax(new int[]{1, 2, 3, 4, 4, 3, 2, 1}));
        System.out.println(thirdMax(new int[]{3, 2, 1, 4}));
        System.out.println(thirdMax(new int[]{2, 1, 2}));
        System.out.println(thirdMax(new int[]{1, 1}));
    }
}
