package leetcode.problem601;

import java.util.ArrayList;
import java.util.List;

/**
 * 670. Maximum Swap
 */
public class Solution670 {
    public static int maximumSwap(int num) {
        if (num < 10) return num;
        int tmpNum = num;
        List<Integer> list = new ArrayList<>();
        while (tmpNum != 0) {
            list.add(0, tmpNum % 10);
            tmpNum /= 10;
        }
        // 找到第一个比较小的数位置low
        int low = -1;
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) < list.get(i + 1)) {
                low = i;
                break;
            }
        }
        // 找到low后面的最大数的位置highIndex
        if (low == -1) return num;
        int highIndex = low + 1;
        for (int i = low + 2; i < list.size(); i++) {
            if (list.get(highIndex) <= list.get(i)) highIndex = i;
        }
        // 从0开始找到第一个比highIndex小的数，替换
        for (int i = 0; i <= low; i++) {
            if (list.get(highIndex) > list.get(i)) {
                int tmp = list.get(highIndex);
                list.set(highIndex, list.get(i));
                list.set(i, tmp);
                break;
            }
        }
        // 计算结果
        int res = 0;
        for (int i : list) res = res * 10 + i;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(maximumSwap(9973));
        System.out.println(maximumSwap(2736));
    }
}
