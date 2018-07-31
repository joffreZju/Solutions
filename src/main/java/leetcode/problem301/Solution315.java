package leetcode.problem301;

import java.util.*;

/**
 * 315. Count of Smaller Numbers After Self
 * 整体思路：
 * int counter[] = new int[maxn], BIT[] = new int[maxn + 1];
 * for(int i: nums)counter[i]++;
 * BIT其实是counter的BIT，初始化为全 0
 * 倒序遍历nums，对于每一个nums[i], BIT的sum(nums[i] - 1) 就是 res[i]
 *
 * 方法一：求出 nums 中的 min, max, 将 nums 映射到 counter[min - min + 1, max - min + 1] 上，然后使用 BIT 求解
 * 方法二：将 nums 离散化到 1 ~ length 上，同时映射到 counter[1, length] 上，然后使用 BIT 求解
 *
 * PS: 也可以使用归并排序，二分搜索来解决
 */
public class Solution315 {
    private class Node {
        int src, pos;

        Node(int src, int pos) {
            this.src = src;
            this.pos = pos;
        }
    }

    // public List<Integer> countSmaller(int[] nums) {
    //     int len = nums.length;
    //
    //     //离散化
    //     Node[] data = new Node[len];
    //     for (int i = 0; i < len; i++) {
    //         data[i] = new Node(nums[i], i);
    //     }
    //     Arrays.sort(data, (a, b) -> a.src - b.src);
    //     int id = 1, map[] = new int[len];
    //     for (int i = 0; i < len; i++) {
    //         int pos = data[i].pos;
    //         if (i == 0) map[pos] = id;
    //         else if (data[i].src == data[i - 1].src) map[pos] = id;
    //         else map[pos] = ++id;
    //     }
    //
    //     int tree[] = new int[len + 1], tmp[] = new int[len];
    //     for (int i = len - 1; i >= 0; i--) {
    //         int index = map[i];
    //         tmp[i] = sum(index - 1, tree);
    //         addOne(index, tree);
    //     }
    //     List<Integer> res = new ArrayList<>();
    //     for (int t : tmp) res.add(t);
    //     return res;
    // }

    // 树状数组
    public List<Integer> countSmaller(int[] nums) {
        int len = nums.length, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i : nums) {
            max = Math.max(max, i);
            min = Math.min(min, i);
        }
        int tree[] = new int[max - min + 2], tmp[] = new int[len];
        for (int i = len - 1; i >= 0; i--) {
            int index = nums[i] - min + 1;
            tmp[i] = sum(index - 1, tree);
            addOne(index, tree);
        }
        List<Integer> res = new ArrayList<>();
        for (int i : tmp) res.add(i);
        return res;
    }


    private int sum(int i, int[] tree) {
        int sum = 0;
        while (i >= 1) {
            sum += tree[i];
            i -= i & (-i);
        }
        return sum;
    }

    private void addOne(int i, int[] tree) {
        while (i <= tree.length - 1) {
            tree[i]++;
            i += i & (-i);
        }
    }


    public static void main(String[] args) {
        System.out.println(new Solution315().countSmaller(new int[]{5, 2, 6, 1}));
        System.out.println(new Solution315().countSmaller(new int[]{1, 1}));
    }
}
