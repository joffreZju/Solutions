package leetcode.round_1.problem101;

/**
 * Created by joffre on 2017/11/28.
 * 162. Find Peak Element
 */
public class Solution162 {
    public static int findPeakElement(int[] nums) {
        int i = 0, j = nums.length - 1, mid;
        while (i < j) {
            mid = (i + j) / 2;
            //mid - 1可能越下界，不会越上界
            if (mid == 0) {
                if (nums[mid] > nums[mid + 1]) return mid;
                else i = mid + 1;
            } else {
                if (nums[mid] < nums[mid + 1]) i = mid + 1;
                else if (nums[mid] < nums[mid - 1]) j = mid - 1;
                else return mid;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        System.out.println(findPeakElement(new int[]{0, 1}));
        System.out.println(findPeakElement(new int[]{1, 0}));
        System.out.println(findPeakElement(new int[]{0, 1, 0}));
        System.out.println(findPeakElement(new int[]{1, 2, 1, 2}));
        System.out.println(findPeakElement(new int[]{1, 2, 3, 4}));
    }
}
