package leetcode.util;

import java.util.*;

/**
 * Created by joffre on 2017/10/15.
 */
public class Interval {
    public int start;
    public int end;

    public Interval() {
        start = 0;
        end = 0;
    }

    public Interval(int s, int e) {
        start = s;
        end = e;
    }

    public static List<Interval> arraysToIntervalsList(int[][] arrays) {
        List<Interval> intervals = new ArrayList<>();
        for (int i = 0; i < arrays.length; i++) {
            intervals.add(new Interval(arrays[i][0], arrays[i][1]));
        }
        return intervals;
    }

    public static Interval[] arraysToIntervalsArray(int[][] arrays) {
        Interval[] intervals = new Interval[arrays.length];
        for (int i = 0; i < arrays.length; i++) {
            intervals[i] = new Interval(arrays[i][0], arrays[i][1]);
        }
        return intervals;
    }

    @Override
    public String toString() {
        return "[" + start + "," + end + "]";
    }
}