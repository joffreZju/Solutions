package leetcode.problem601;

import java.util.*;

/**
 * 632. Smallest Range
 */
public class Solution632 {
    public int[] smallestRange(List<List<Integer>> nums) {
        // 在 TreeSet 中存放每个数组的其中一个元素，将最小的元素出队，然后将其原来位置的后一个元素入队
        // 直到 set 中的最小元素已经是原数组的最后一个元素，退出循环
        TreeSet<int[]> set = new TreeSet<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[2] != o2[2]) return o1[2] - o2[2];
                // 如果当前元素相等，那么比较后面的元素，如果某一个先到达数组末尾，那么将其排在前面
                // 其实就是比较两个 list, 可以直接: return nums.get(o1[0]).hashCode() - nums.get(o2[0]).hashCode();

                int size1 = nums.get(o1[0]).size(), size2 = nums.get(o2[0]).size();
                return nums.get(o1[0]).subList(o1[1], size1).hashCode() - nums.get(o2[0]).subList(o2[1], size2).hashCode();

                // 啰嗦一点自己比较：
                // int i = o1[1] + 1, j = o2[1] + 1;
                // while (i < nums.get(o1[0]).size() && j < nums.get(o2[0]).size()) {
                //     int t = nums.get(o1[0]).get(i) - nums.get(o2[0]).get(j);
                //     if (t != 0) return t;
                //     i++;
                //     j++;
                // }
                // if (i >= nums.get(o1[0]).size()) return -1;
                // if (j >= nums.get(o2[0]).size()) return 1;
                // return 0;
            }
        });
        for (int i = 0; i < nums.size(); i++) {
            set.add(new int[]{i, 0, nums.get(i).get(0)});
        }

        int res[] = new int[2], min = Integer.MAX_VALUE;
        while (!set.isEmpty()) {
            int[] first = set.first(), last = set.last();
            if (last[2] - first[2] < min) {
                res[0] = first[2];
                res[1] = last[2];
                min = res[1] - res[0];
            }
            if (first[1] >= nums.get(first[0]).size() - 1) break;
            set.pollFirst();
            set.add(new int[]{first[0], ++first[1], nums.get(first[0]).get(first[1])});
        }
        return res;
    }
}
