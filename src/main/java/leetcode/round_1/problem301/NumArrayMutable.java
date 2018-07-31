package leetcode.round_1.problem301;

/**
 * 307. Range Sum Query - Mutable
 * 树状数组
 * http://www.cnblogs.com/zichi/p/4806998.html
 */
public class NumArrayMutable {
    private int lowBit(int i) {
        return i & (-i);
    }

    private int sum(int n) {
        int res = 0;
        while (n >= 1) {
            res += tree[n];
            n -= lowBit(n);
        }
        return res;
    }

    private int tree[], len;

    public NumArrayMutable(int[] nums) {
        len = nums.length;
        tree = new int[len + 1];
        for (int i = 0; i < len; i++) {
            int index = i + 1;
            while (index <= len) {
                tree[index] += nums[i];
                index = index + lowBit(index);
            }
        }
    }

    public void update(int i, int val) {
        val = val - (sum(i + 1) - sum(i));
        int index = i + 1;
        while (index <= len) {
            tree[index] += val;
            index += lowBit(index);
        }
    }

    public int sumRange(int i, int j) {
        return sum(j + 1) - sum(i);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */