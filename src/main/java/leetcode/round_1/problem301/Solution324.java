package leetcode.round_1.problem301;

/**
 * 324. Wiggle Sort II
 * 这题也太难了吧。。。
 */
public class Solution324 {
    public void wiggleSort(int[] nums) {
        int median = findKthLargest(nums, (nums.length + 1) / 2);
        int n = nums.length;

        int left = 0, i = 0, right = n - 1;

        while (i <= right) {
            if (nums[newIndex(i, n)] > median) {
                swap(nums, newIndex(left++, n), newIndex(i++, n));
            } else if (nums[newIndex(i, n)] < median) {
                swap(nums, newIndex(right--, n), newIndex(i, n));
            } else {
                i++;
            }
        }
    }

    private int newIndex(int index, int n) {
        return (1 + 2 * index) % (n | 1);
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    private int findKthLargest(int[] nums, int k) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int index = partition(nums, i, j);
            if (index == k - 1) return nums[index];
            else if (index < k - 1) i = index + 1;
            else j = index - 1;
        }
        return nums[k - 1];
    }

    private int partition(int nums[], int left, int right) {
        int i = left, j = right, mid = i + (j - i) / 2, tmp = nums[mid];
        nums[mid] = nums[i]; //用 nums[mid] 作为 pivot，在这个题目里面比left和right都好。

        while (i < j) {
            while (j > i && nums[j] < tmp) j--;
            nums[i] = nums[j];

            while (i < j && nums[i] >= tmp) i++;
            nums[j] = nums[i];
        }
        nums[i] = tmp;
        return i;
    }
}
