package leetcode.problem101;

/**
 * Created by joffre on 2017/11/28.
 * 167. Two Sum II - Input array is sorted
 */
public class Solution167 {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0, j = numbers.length - 1;
        while (numbers[i] + numbers[j] != target) {
            if (numbers[i] + numbers[j] < target) i++;
            else j--;
        }
        return new int[]{i + 1, j + 1};
    }
}
