package leetcode.problem701;

import java.util.ArrayList;
import java.util.List;

public class MyCalendar {

    private List<Integer> starts, ends;

    public MyCalendar() {
        starts = new ArrayList<>();
        ends = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        for (int i = 0; i < starts.size(); i++) {
            if (starts.get(i) >= start && starts.get(i) < end) return false;
            else if (start >= starts.get(i) && start < ends.get(i)) return false;
        }
        starts.add(start);
        ends.add(end);
        return true;
    }

    public static void main(String[] args) {
        MyCalendar calendar = new MyCalendar();
        System.out.println(calendar.book(10, 20));
        System.out.println(calendar.book(15, 25));
        System.out.println(calendar.book(20, 30));
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
