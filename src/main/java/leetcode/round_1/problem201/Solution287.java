package leetcode.round_1.problem201;

/**
 * Created by joffre on 2017/11/30.
 * 287. Find the Duplicate Number
 */
public class Solution287 {
    public static int findDuplicate(int[] nums) {
        int low = 1, high = nums.length - 1;
        while (low < high) {
            int mid = (low + high) / 2, count = 0;
            for (int i : nums) {
                if (i <= mid) count++;
            }
            if (count <= mid) low = mid + 1;
            else high = mid;
        }
        return low;
    }

    public static int findDuplicateOn(int[] nums) {
        int slow = 0;
        int fast = 0;
        // 找到快慢指针相遇的地方
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
            // System.out.println(slow + "---" + fast);
        } while (slow != fast);

        // System.out.println("******");
        int find = 0;
        // 用一个新指针从头开始，直到和慢指针相遇
        while (find != slow) {
            slow = nums[slow];
            find = nums[find];
            // System.out.println(slow + "---" + find);
        }
        return find;
    }

    public static void main(String[] args) {
        System.out.println("O(NlogN): ");
        System.out.println(findDuplicate(new int[]{1, 2, 3, 2, 4}));
        System.out.println(findDuplicate(new int[]{3, 2, 5, 14, 5, 5, 19, 18, 11, 10, 1, 4, 5, 5, 5, 5, 12, 5, 17, 5}));

        System.out.println("O(N): ");
        System.out.println(findDuplicateOn(new int[]{1, 2, 4, 3, 1}));

    }
}
