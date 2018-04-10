package offer;

/**
 * 二维数组中的查找
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class Solution001 {
    public boolean Find(int target, int[][] array) {
        int m = array.length, n = array[0].length;
        int i = m - 1, j = 0;
        while (i >= 0 && j < n) {
            if (target < array[i][j]) {
                i--;
            } else if (target > array[i][j]) {
                j++;
            } else return true;
        }
        return false;
    }

}
