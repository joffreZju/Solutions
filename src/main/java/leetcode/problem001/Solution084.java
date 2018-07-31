package leetcode.problem001;

import java.util.Stack;

public class Solution084 {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        int n = heights.length, res = 0;
        int left[] = new int[n]; // left[i]: 从 i 向左第一个小于 heights[i] 的下标
        int right[] = new int[n]; // right[i]: 从 i 向右第一个小于 heights[i] 的下标

        left[0] = -1;
        right[n - 1] = n;

        for (int i = 1; i < n; i++) {
            int j = i - 1;
            while (j >= 0 && heights[j] >= heights[i]) j = left[j];// 这里是关键
            left[i] = j;
        }
        for (int i = n - 2; i >= 0; i--) {
            int j = i + 1;
            while (j < n && heights[j] >= heights[i]) j = right[j];// 这里是关键
            right[i] = j;
        }
        for (int i = 0; i < n; i++) {
            res = Math.max(res, heights[i] * (right[i] - left[i] - 1));
        }
        return res;
    }

    // Stack：记录高度，记录下标
    // 1、从左往右扫，当前高度为 h, 如果比栈顶的高，直接入栈
    // 2、如果比栈顶的低，那么依次出栈直到栈顶高度小于 h, 出栈同时尝试更新最大值（其实相当于从右往左扫）
    // 3、上述出栈过程将会找到最后一个比 h 大的矩形的下标为 preIndex, 将 h 和 preIndex 同时入栈
    // （相当于用 h 顶替掉最后出栈的一个height（其原始下标是 preIndex，被 h 复用）
    // h * (i - preIndex + 1)下次会被计算到，所以栈中的高度始终是递增的）。
    // public int largestRectangleArea(int[] heights) {
    //     Stack<Integer> iStack = new Stack<>(), hStack = new Stack<>();
    //     int res = 0;
    //     for (int i = 0; i < heights.length; i++) {
    //         if (hStack.isEmpty() || heights[i] >= hStack.peek()) {
    //             hStack.push(heights[i]);
    //             iStack.push(i);
    //         } else {
    //             int preIndex = i;
    //             while (!hStack.isEmpty() && heights[i] <= hStack.peek()) {
    //                 int h = hStack.pop();
    //                 preIndex = iStack.pop();
    //                 res = Math.max(res, h * (i - preIndex));
    //             }
    //             iStack.push(preIndex);
    //             hStack.push(heights[i]);
    //         }
    //     }
    //     while (!hStack.isEmpty() && hStack.peek() > 0) {
    //         res = Math.max(res, hStack.pop() * (heights.length - iStack.pop()));
    //     }
    //     return res;
    // }
}
