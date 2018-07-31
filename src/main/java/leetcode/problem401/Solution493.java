package leetcode.problem401;

import java.util.Arrays;

/**
 * 493. Reverse Pairs
 */
public class Solution493 {
    private void update(int i, int val, int[] tree) {
        while (i > 0 && i < tree.length) {
            tree[i] += val;
            i += i & (-i);
        }
    }

    private int sum(int i, int[] tree) {
        int sum = 0;
        while (i > 0 && i < tree.length) {
            sum += tree[i];
            i -= i & (-i);
        }
        return sum;
    }

    // 树状数组
    public int reversePairs(int[] nums) {
        int len = nums.length;
        long sorted[] = new long[len];
        int tree[] = new int[len + 1]; // BIT tree 管理的是 sorted 的 index
        for (int i = 0; i < len; i++) sorted[i] = nums[i];
        Arrays.sort(sorted);

        int res = 0;
        //注意从前往后遍历
        for (int i = 0; i < len; i++) {
            //从copy找到第一个大于 nums[i] * 2 的数字的 index
            int index = Arrays.binarySearch(sorted, (long) nums[i] * 2 + 1);
            if (index < 0) {
                index = -index - 1;
            }

            // 统计 tree 中所有大于 index 的个数
            res += sum(len, tree) - sum(index, tree);

            // 将 nums[i] 在 sorted 中的位置 update 到 tree 中
            index = Arrays.binarySearch(sorted, nums[i]);
            update(index + 1, 1, tree);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution493().reversePairs(new int[]{1, 3, 2, 3, 1}));
        System.out.println(new Solution493().reversePairs(new int[]{-1, -1}));
        System.out.println(new Solution493().reversePairs(new int[]{233, 2000000001, 234, 2000000006, 235, 2000000003, 236, 2000000007, 237, 2000000002, 2000000005, 233, 233, 233, 233, 233, 2000000004}));
    }
}
