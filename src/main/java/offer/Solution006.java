package offer;

import java.util.*;

/**
 * 数据流中的中位数
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 */

public class Solution006 {
    /**
     * 1. left是最大堆，保存左半边，同时维护左半边最大值
     * 2. right是最小堆，保存右半边的数据，同时维护右半边最小值
     * 3. 每次插入到left或者right后，检测两边的size，保证left和right的大小差不超过1
     * 4. 获取中位数时：区分奇偶个数
     */
    private PriorityQueue<Integer> left = new PriorityQueue<>(new Comparator<Integer>() {
        public int compare(Integer a, Integer b) {
            return b - a;
        }
    }), right = new PriorityQueue<>();

    public void Insert(Integer num) {
        if (left.size() == 0 || num < left.peek()) {
            left.offer(num);
            if (left.size() - right.size() > 1) right.offer(left.poll());
        } else {
            right.offer(num);
            if (right.size() - left.size() > 1) left.offer(right.poll());
        }
    }

    public Double GetMedian() {
        if (left.size() == right.size()) return (double) (left.peek() + right.peek()) / 2;
        else return (double) (left.size() > right.size() ? left.peek() : right.peek());
    }

    // Solution：O(n)
    // private static ArrayList<Integer> nums = new ArrayList<>();
    //
    // public void Insert(Integer num) {
    //     int i = 0;
    //     for (; i < nums.size(); i++) {
    //         if (nums.get(i) > num) break;
    //     }
    //     nums.add(i, num);
    // }
    //
    // public Double GetMedian() {
    //     int size = nums.size();
    //     if (size % 2 == 0) return (double) (nums.get(size / 2) + nums.get(size / 2 - 1)) / 2;
    //     else return (double) nums.get(size / 2);
    // }
}
