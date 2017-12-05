package leetcode.problem201;

import java.util.*;

/**
 * Created by joffre on 2017/11/29.
 * 229. Majority Element II
 */
public class Solution229 {
    public static List<Integer> majorityElement(int[] nums) {
        Set<Integer> res = new HashSet<>();
        int c1 = 0, m1 = 0, c2 = 0, m2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == m1) {
                c1++;
            } else if (nums[i] == m2) {
                c2++;
            } else if (c1 == 0) {
                m1 = nums[i];
                c1 = 1;
            } else if (c2 == 0) {
                m2 = nums[i];
                c2 = 1;
            } else {
                c1--;
                c2--;
            }
        }
        int tmpc1 = 0, tmpc2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == m1) tmpc1++;
            if (nums[i] == m2) tmpc2++;
        }
        if (c1 > 0 && tmpc1 > nums.length / 3) res.add(m1);
        if (c2 > 0 && tmpc2 > nums.length / 3) res.add(m2);
        return new ArrayList<>(res);
    }

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{}));                       //  []
        System.out.println(majorityElement(new int[]{1}));                      //  [1]
        System.out.println(majorityElement(new int[]{1, 1}));                   //  [1]
        System.out.println(majorityElement(new int[]{1, 2}));                   //  [1,2]
        System.out.println(majorityElement(new int[]{1, 2, 3}));                //  []
        System.out.println(majorityElement(new int[]{1, 1, 3}));                //  [1]
        System.out.println(majorityElement(new int[]{1, 2, 3, 1}));             //  [1]
        System.out.println(majorityElement(new int[]{1, 2, 3, 1, 4}));          //  [1]
        System.out.println(majorityElement(new int[]{1, 2, 3, 1, 2}));          //  [1,2]
        System.out.println(majorityElement(new int[]{1, 2, 3, 1, 2, 3}));       //  []
        System.out.println(majorityElement(new int[]{1, 2, 2, 3, 2, 1, 1, 3})); //  [1,2]
    }
}
