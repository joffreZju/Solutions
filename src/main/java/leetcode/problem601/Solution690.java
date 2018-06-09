package leetcode.problem601;

import java.util.*;

/**
 * 690. Employee Importance
 */

// Employee info
class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
}

public class Solution690 {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee e : employees) map.put(e.id, e);
        return dfs(map, id);
    }

    private int dfs(Map<Integer, Employee> map, int id) {
        Employee e = map.get(id);
        int self = e.importance;
        if (e.subordinates == null || e.subordinates.size() == 0) return self;

        for (int subId : e.subordinates) {
            self += dfs(map, subId);
        }
        return self;
    }
}