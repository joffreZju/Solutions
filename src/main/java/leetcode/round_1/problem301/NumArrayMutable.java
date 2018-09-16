package leetcode.round_1.problem301;

/**
 * 307. Range Sum Query - Mutable
 * 树状数组
 * http://www.cnblogs.com/zichi/p/4806998.html
 */
public class NumArrayMutable {
    private int lowBit(int index) {
        return index & (-index);
    }

    private int sum(int n) {
        int res = 0;
        for (int i = n; i >= 1; i -= lowBit(i)) {
            res += tree[i];
        }
        return res;
    }

    private int tree[], len;

    public NumArrayMutable(int[] nums) {
        len = nums.length;
        tree = new int[len + 1];
        for (int i = 0; i < len; i++) {
            update(i, nums[i]);
        }
    }

    public void update(int index, int val) {
        val = val - (sum(index + 1) - sum(index));
        for (int i = index + 1; i <= len; i += lowBit(i)) {
            tree[i] += val;
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