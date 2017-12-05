package leetcode.problem001;

import leetcode.util.Interval;

import java.util.*;

/**
 * Created by joffre on 2017/10/15.
 * 56. Merge Intervals
 */
public class Solution056 {
    private static class IntervalComparator implements Comparator<Interval> {
        @Override
        public int compare(Interval i1, Interval i2) {
            return i1.start - i2.start;
        }
    }

    public static List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<>();
        if (intervals.size() == 0) return res;

        intervals.sort(new IntervalComparator());
        int start = intervals.get(0).start, end = intervals.get(0).end;
        for (int i = 1; i < intervals.size(); i++) {
            if (intervals.get(i).start <= end) {
                end = Math.max(intervals.get(i).end, end);
            } else {
                res.add(new Interval(start, end));
                start = intervals.get(i).start;
                end = intervals.get(i).end;
            }
        }
        res.add(new Interval(start, end));
        return res;
    }

    public static void main(String[] args) {
        System.out.println(merge(Interval.arraysToIntervalsList(new int[][]{{1, 7}, {2, 6}, {6, 10}, {15, 18}})));
        System.out.println(merge(Interval.arraysToIntervalsList(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}})));
    }
}


