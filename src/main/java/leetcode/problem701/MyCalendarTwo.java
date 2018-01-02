package leetcode.problem701;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * 731. My Calendar II
 */
public class MyCalendarTwo {
    private List<int[]> bookList = new ArrayList<>();

    public boolean book(int start, int end) {
        MyCalendar myCalendar = new MyCalendar();
        for (int[] book : bookList) {
            if (Math.max(start, book[0]) < Math.min(end, book[1]))
                if (!myCalendar.book(Math.max(start, book[0]), Math.min(end, book[1]))) return false;
        }
        bookList.add(new int[]{start, end});
        return true;
    }

    private static class MyCalendar {
        private TreeMap<Integer, Integer> bookMap = new TreeMap<>();

        public boolean book(int start, int end) {
            Integer floor = bookMap.floorKey(start), higher = bookMap.higherKey(start);
            if ((floor == null || bookMap.get(floor) <= start) && (higher == null || higher >= end)) {
                bookMap.put(start, end);
                return true;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        MyCalendarTwo myCalendarTwo = new MyCalendarTwo();
        // System.out.println(myCalendarTwo.book(24, 40));
        // System.out.println(myCalendarTwo.book(43, 50));
        // System.out.println(myCalendarTwo.book(27, 43));
        // System.out.println(myCalendarTwo.book(5, 21));
        // System.out.println(myCalendarTwo.book(30, 40));
        // System.out.println(myCalendarTwo.book(14, 29));
        // System.out.println(myCalendarTwo.book(3, 19));
        // System.out.println(myCalendarTwo.book(3, 14));
        //
        System.out.println(myCalendarTwo.book(10, 20));
        System.out.println(myCalendarTwo.book(50, 60));
        System.out.println(myCalendarTwo.book(10, 40));
        System.out.println(myCalendarTwo.book(5, 15));
        System.out.println(myCalendarTwo.book(5, 10));
        System.out.println(myCalendarTwo.book(25, 55));
        System.out.println(myCalendarTwo.book(55, 60));
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */
