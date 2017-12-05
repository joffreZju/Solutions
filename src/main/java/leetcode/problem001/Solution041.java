package leetcode.problem001;

/**
 * Created by joffre on 2017/11/16.
 * 41. First Missing Positive
 */
public class Solution041 {
    public static int firstMissingPositive(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            /**
             * 1.只考虑正数
             * 2.nums[i]位置不正确
             * 3.确保下一个条件不越界
             * 4.该位置如果已经存在正确的数字，那么跳过（nums[i]有重复）
             */
            if (nums[i] > 0 && nums[i] != i + 1 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]) {
                int tmp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = tmp;
            } else i++;
        }
        //找到第一个不正确的位置就是答案
        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) break;
        }
        return i + 1;
    }

    public static void main(String[] args) {
        System.out.println(firstMissingPositive(new int[]{1, 2, 0}));
        System.out.println(firstMissingPositive(new int[]{3, 4, -1, 1, 1}));
        System.out.println(firstMissingPositive(new int[]{2}));
        System.out.println(firstMissingPositive(new int[]{}));
    }
}
