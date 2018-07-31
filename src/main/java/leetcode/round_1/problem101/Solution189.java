package leetcode.round_1.problem101;

import java.util.Arrays;

/**
 * Created by joffre on 2017/11/28.
 * 189. Rotate Array
 */
public class Solution189 {
    public static void rotateEasily(int[] nums, int k) {
        int len = nums.length;
        k %= len;
        reverse(nums, 0, len - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, len - 1);
        System.out.println(Arrays.toString(nums));
    }

    private static void reverse(int[] nums, int i, int j) {
        while (i < j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i++;
            j--;
        }
    }

    public static void rotate(int[] nums, int k) {
        k %= nums.length;
        if (k == 0) return;
        int len = nums.length, i = len - k, j = (i + k) % len;
        // 一共交换len-1次那么所有的元素都会在正确的位置上
        // 如果i==j,说明当前元素位置正确，所以count++,同时i++处理下一个位置
        for (int count = 0; count < len - 1; count++) {
            swap(nums, j, i);
            j = (j + k) % len;
            if (i == j) {
                count++;
                i++;
                j = (i + k) % len;
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 1);
        rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 2);
        rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 3);
        rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 4);
        rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 5);
        rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 6);
        System.out.println("*******");
        rotate(new int[]{1, 2, 3, 4, 5, 6}, 1);
        rotate(new int[]{1, 2, 3, 4, 5, 6}, 2);
        rotate(new int[]{1, 2, 3, 4, 5, 6}, 3);
        rotate(new int[]{1, 2, 3, 4, 5, 6}, 4);
        rotate(new int[]{1, 2, 3, 4, 5, 6}, 5);
        System.out.println("*******");
        rotateEasily(new int[]{1, 2, 3, 4, 5, 6, 7}, 1);
        rotateEasily(new int[]{1, 2, 3, 4, 5, 6, 7}, 2);
        rotateEasily(new int[]{1, 2, 3, 4, 5, 6, 7}, 3);
        rotateEasily(new int[]{1, 2, 3, 4, 5, 6, 7}, 4);
        rotateEasily(new int[]{1, 2, 3, 4, 5, 6, 7}, 5);
        rotateEasily(new int[]{1, 2, 3, 4, 5, 6, 7}, 6);
        System.out.println("*******");
        rotateEasily(new int[]{1, 2, 3, 4, 5, 6}, 1);
        rotateEasily(new int[]{1, 2, 3, 4, 5, 6}, 2);
        rotateEasily(new int[]{1, 2, 3, 4, 5, 6}, 3);
        rotateEasily(new int[]{1, 2, 3, 4, 5, 6}, 4);
        rotateEasily(new int[]{1, 2, 3, 4, 5, 6}, 5);

    }
}
