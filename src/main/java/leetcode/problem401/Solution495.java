package leetcode.problem401;

/**
 * 495. Teemo Attacking
 */
public class Solution495 {
    public static int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries.length == 0) return 0;
        int total = duration, preEnd = timeSeries[0] + duration;
        for (int i = 1; i < timeSeries.length; i++) {
            if (timeSeries[i] < preEnd) {
                total += timeSeries[i] + duration - preEnd;
            } else {
                total += duration;
            }
            preEnd = timeSeries[i] + duration;
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println(findPoisonedDuration(new int[]{1, 4, 7}, 2));
        System.out.println(findPoisonedDuration(new int[]{1, 2, 3}, 2));

    }

}
