package leetcode.problem001;

/**
 * 42. Trapping Rain Water
 */
public class Solution042 {
    public static int trap(int[] height) {
        if (height.length < 3) return 0;

        int midMaxIndex = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] > height[midMaxIndex]) midMaxIndex = i;
        }

        int res = 0;
        for (int i = 0, leftMax = 0; i < midMaxIndex; i++) {
            if (height[i] < leftMax) res += leftMax - height[i];
            leftMax = Math.max(height[i], leftMax);
        }
        for (int i = height.length - 1, rightMax = 0; i > midMaxIndex; i--) {
            if (height[i] < rightMax) res += rightMax - height[i];
            rightMax = Math.max(rightMax, height[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }
}
