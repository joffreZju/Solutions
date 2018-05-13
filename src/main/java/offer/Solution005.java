package offer;

/**
 * 构建乘积数组：
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 */
public class Solution005 {
    public int[] multiply(int[] A) {
        int len = A.length, B1[] = new int[len], B2[] = new int[len];
        for (int i = 0; i < len; i++) {
            if (i == 0) B1[i] = 1;
            else B1[i] = B1[i - 1] * A[i - 1];
        }
        for (int i = len - 1; i >= 0; i--) {
            if (i == len - 1) B2[i] = 1;
            else B2[i] = B2[i + 1] * A[i + 1];
        }
        for (int i = 0; i < len; i++) {
            B1[i] *= B2[i];
        }
        return B1;
    }
}
