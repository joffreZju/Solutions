package leetcode.round_1.problem001;

/**
 * Created by joffre on 2017/9/26.
 * 11. Container With Most Water
 */
public class Solution011 {
    public static int maxArea(int[] height) {
        int max = 0, left = 0, right = height.length - 1;
        while (left < right) {
            if (height[left] <= height[right]) {
                if (height[left] * (right - left) > max) {
                    max = height[left] * (right - left);
                }
                left++;
            } else {
                if (height[right] * (right - left) > max) {
                    max = height[right] * (right - left);
                }
                right--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(Solution011.maxArea(new int[]{1, 1}));
        System.out.println(Solution011.maxArea(new int[]{1, 3, 5, 6, 4, 2}));
    }
}
