package leetcode.problem601;

import java.util.*;

/**
 * 621. Task Scheduler
 */
public class Solution621 {
    public static int leastIntervalWrong(char[] tasks, int n) {
        int N = tasks.length, time = 0;
        int[] taskCounter = new int[26], preTaskBeginTime = new int[26];
        for (char c : tasks) taskCounter[c - 'A']++;
        Arrays.sort(taskCounter);
        /**
         * A B C D
         * 4 3 3 1
         * 这个case就会出错。
         * 原因：每次执行一个任务之后，应将剩余任务重新排序，而不是固定不动。
         * 改正：将任务放到优先队列中，每次将队列头的任务-1，并将其重新放到优先队列中排序。
         */
        while (N > 0) {
            int i = 25;
            while (i >= 0) {
                if (taskCounter[i] == 0) i--;
                else if (preTaskBeginTime[i] == 0 || time - preTaskBeginTime[i] >= n) {
                    taskCounter[i]--;
                    N--;
                    time++;
                    preTaskBeginTime[i] = time;
                    i = 25;
                } else i--;
            }
            if (N > 0) {
                time++;
            }
        }
        return time;
    }

    public static int leastIntervalAC1(char[] tasks, int n) {
        // https://leetcode.com/articles/task-scheduler/
        int[] taskCounter = new int[26];
        for (char c : tasks) taskCounter[c - 'A']++;
        Arrays.sort(taskCounter);
        int sum = 0;
        for (int i = 25; i >= 0; i--) {
            if (taskCounter[i] == taskCounter[25]) sum++;
        }
        return Math.max(tasks.length, (taskCounter[25] - 1) * (n + 1) + sum);
    }

    public static int leastIntervalAC3(char[] tasks, int n) {
        Map<Character, Integer> taskCounter = new HashMap<>();
        for (char c : tasks) taskCounter.put(c, taskCounter.getOrDefault(c, 0) + 1);

        // 优先队列(最大堆): 将次数最多的task放在队首
        PriorityQueue<Map.Entry<Character, Integer>> queue = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        queue.addAll(taskCounter.entrySet());

        Map<Character, Integer> taskPreExTime = new HashMap<>();

        int time = 0;
        while (!queue.isEmpty()) {
            boolean slot = true;
            List<Map.Entry<Character, Integer>> tmpList = new ArrayList<>();

            // 从优先队列一次poll得到队首task
            // 1. 如果这个task可以执行，那么执行他（time++，设置taskPreExTime，slot设为false），如果仍有剩余次数那么再将其加入tmpList
            // 2. 如果不能执行那么直接加入tmpList
            while (!queue.isEmpty()) {
                Map.Entry<Character, Integer> entry = queue.poll();
                int preTime = taskPreExTime.getOrDefault(entry.getKey(), 0);
                if (preTime == 0 || time - preTime >= n) {
                    time++;
                    taskPreExTime.put(entry.getKey(), time);
                    if (entry.getValue() > 1) {
                        entry.setValue(entry.getValue() - 1);
                        tmpList.add(entry);
                    }
                    slot = false;
                    break;
                } else tmpList.add(entry);
            }

            // 如果slot=true，那么说明这个节拍没有执行任何任务，time++，空节拍
            if (slot) time++;

            // 3. 将tmpList中的所有task再次加入到优先队列
            queue.addAll(tmpList);
        }
        System.out.println(time);
        return time;
    }

    public static void main(String[] args) {
        String[] strings = new String[]{"G", "C", "A", "H", "A", "G", "G", "F", "G", "J", "H", "C", "A", "G", "E", "A", "H", "E", "F", "D", "B", "D", "H", "H", "E", "G", "F", "B", "C", "G", "F", "H", "J", "F", "A", "C", "G", "D", "I", "J", "A", "G", "D", "F", "B", "F", "H", "I", "G", "J", "G", "H", "F", "E", "H", "J", "C", "E", "H", "F", "C", "E", "F", "H", "H", "I", "G", "A", "G", "D", "C", "B", "I", "D", "B", "C", "J", "I", "B", "G", "C", "H", "D", "I", "A", "B", "A", "J", "C", "E", "B", "F", "B", "J", "J", "D", "D", "H", "I", "I", "B", "A", "E", "H", "J", "J", "A", "J", "E", "H", "G", "B", "F", "C", "H", "C", "B", "J", "B", "A", "H", "B", "D", "I", "F", "A", "E", "J", "H", "C", "E", "G", "F", "G", "B", "G", "C", "G", "A", "H", "E", "F", "H", "F", "C", "G", "B", "I", "E", "B", "J", "D", "B", "B", "G", "C", "A", "J", "B", "J", "J", "F", "J", "C", "A", "G", "J", "E", "G", "J", "C", "D", "D", "A", "I", "A", "J", "F", "H", "J", "D", "D", "D", "C", "E", "D", "D", "F", "B", "A", "J", "D", "I", "H", "B", "A", "F", "E", "B", "J", "A", "H", "D", "E", "I", "B", "H", "C", "C", "C", "G", "C", "B", "E", "A", "G", "H", "H", "A", "I", "A", "B", "A", "D", "A", "I", "E", "C", "C", "D", "A", "B", "H", "D", "E", "C", "A", "H", "B", "I", "A", "B", "E", "H", "C", "B", "A", "D", "H", "E", "J", "B", "J", "A", "B", "G", "J", "J", "F", "F", "H", "I", "A", "H", "F", "C", "H", "D", "H", "C", "C", "E", "I", "G", "J", "H", "D", "E", "I", "J", "C", "C", "H", "J", "C", "G", "I", "E", "D", "E", "H", "J", "A", "H", "D", "A", "B", "F", "I", "F", "J", "J", "H", "D", "I", "C", "G", "J", "C", "C", "D", "B", "E", "B", "E", "B", "G", "B", "A", "C", "F", "E", "H", "B", "D", "C", "H", "F", "A", "I", "A", "E", "J", "F", "A", "E", "B", "I", "G", "H", "D", "B", "F", "D", "B", "I", "B", "E", "D", "I", "D", "F", "A", "E", "H", "B", "I", "G", "F", "D", "E", "B", "E", "C", "C", "C", "J", "J", "C", "H", "I", "B", "H", "F", "H", "F", "D", "J", "D", "D", "H", "H", "C", "D", "A", "J", "D", "F", "D", "G", "B", "I", "F", "J", "J", "C", "C", "I", "F", "G", "F", "C", "E", "G", "E", "F", "D", "A", "I", "I", "H", "G", "H", "H", "A", "J", "D", "J", "G", "F", "G", "E", "E", "A", "H", "B", "G", "A", "J", "J", "E", "I", "H", "A", "G", "E", "C", "D", "I", "B", "E", "A", "G", "A", "C", "E", "B", "J", "C", "B", "A", "D", "J", "E", "J", "I", "F", "F", "C", "B", "I", "H", "C", "F", "B", "C", "G", "D", "A", "A", "B", "F", "C", "D", "B", "I", "I", "H", "H", "J", "A", "F", "J", "F", "J", "F", "H", "G", "F", "D", "J", "G", "I", "E", "B", "C", "G", "I", "F", "F", "J", "H", "H", "G", "A", "A", "J", "C", "G", "F", "B", "A", "A", "E", "E", "A", "E", "I", "G", "F", "D", "B", "I", "F", "A", "B", "J", "F", "F", "J", "B", "F", "J", "F", "J", "F", "I", "E", "J", "H", "D", "G", "G", "D", "F", "G", "B", "J", "F", "J", "A", "J", "E", "G", "H", "I", "E", "G", "D", "I", "B", "D", "J", "A", "A", "G", "A", "I", "I", "A", "A", "I", "I", "H", "E", "C", "A", "G", "I", "F", "F", "C", "D", "J", "J", "I", "A", "A", "F", "C", "J", "G", "C", "C", "H", "E", "A", "H", "F", "B", "J", "G", "I", "A", "A", "H", "G", "B", "E", "G", "D", "I", "C", "G", "J", "C", "C", "I", "H", "B", "D", "J", "H", "B", "J", "H", "B", "F", "J", "E", "J", "A", "G", "H", "B", "E", "H", "B", "F", "F", "H", "E", "B", "E", "G", "H", "J", "G", "J", "B", "H", "C", "H", "A", "A", "B", "E", "I", "H", "B", "I", "D", "J", "J", "C", "D", "G", "I", "J", "G", "J", "D", "F", "J", "E", "F", "D", "E", "B", "D", "B", "C", "B", "B", "C", "C", "I", "F", "D", "E", "I", "G", "G", "I", "B", "H", "G", "J", "A", "A", "H", "I", "I", "H", "A", "I", "F", "C", "D", "A", "C", "G", "E", "G", "E", "E", "H", "D", "C", "G", "D", "I", "A", "G", "G", "D", "A", "H", "H", "I", "F", "E", "I", "A", "D", "H", "B", "B", "G", "I", "C", "G", "B", "I", "I", "D", "F", "F", "C", "C", "A", "I", "E", "A", "E", "J", "A", "H", "C", "D", "A", "C", "B", "G", "H", "G", "J", "G", "I", "H", "B", "A", "C", "H", "I", "D", "D", "C", "F", "G", "B", "H", "E", "B", "B", "H", "C", "B", "G", "G", "C", "F", "B", "E", "J", "B", "B", "I", "D", "H", "D", "I", "I", "A", "A", "H", "G", "F", "B", "J", "F", "D", "E", "G", "F", "A", "G", "G", "D", "A", "B", "B", "B", "J", "A", "F", "H", "H", "D", "C", "J", "I", "A", "H", "G", "C", "J", "I", "F", "J", "C", "A", "E", "C", "H", "J", "H", "H", "F", "G", "E", "A", "C", "F", "J", "H", "D", "G", "G", "D", "D", "C", "B", "H", "B", "C", "E", "F", "B", "D", "J", "H", "J", "J", "J", "A", "F", "F", "D", "E", "F", "C", "I", "B", "H", "H", "D", "E", "A", "I", "A", "B", "F", "G", "F", "F", "I", "E", "E", "G", "A", "I", "D", "F", "C", "H", "E", "C", "G", "H", "F", "F", "H", "J", "H", "G", "A", "E", "H", "B", "G", "G", "D", "D", "D", "F", "I", "A", "F", "F", "D", "E", "H", "J", "E", "D", "D", "A", "J", "F", "E", "E", "E", "F", "I", "D", "A", "F", "F", "J", "E", "I", "J", "D", "D", "G", "A", "C", "G", "G", "I", "E", "G", "E", "H", "E", "D", "E", "J", "B", "G", "I", "J", "C", "H", "C", "C", "A", "A", "B", "C", "G", "B", "D", "I", "D", "E", "H", "J", "J", "B", "F", "E", "J", "H", "H", "I", "G", "B", "D"};
        char[] chars = new char[strings.length];
        for (int i = 0; i < strings.length; i++) chars[i] = strings[i].charAt(0);

        leastIntervalAC3(chars, 1);                                                                         //1000
        leastIntervalAC3(new char[]{'A', 'A', 'A', 'A', 'B', 'B', 'B', 'C', 'C', 'C', 'D'}, 1);             //11
        leastIntervalAC3(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2);                                      //8
        leastIntervalAC3(new char[]{'A', 'A', 'A', 'A', 'A', 'A', 'B', 'B', 'C', 'D', 'E', 'F', 'G'}, 2);   //16
        leastIntervalAC3(new char[]{'A', 'B', 'C', 'D', 'E', 'A', 'B', 'C', 'D', 'E'}, 4);                  //10
    }
}