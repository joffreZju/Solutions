package leetcode.round_1.problem301;

import java.util.*;

/**
 * 381. Insert Delete GetRandom O(1) - Duplicates allowed
 */
class RandomizedCollection {
    // nums保存所有的元素
    private ArrayList<Integer> nums;

    // location的value是set，保存同一个元素的多个不同位置
    private HashMap<Integer, Set<Integer>> location;

    private Random random = new Random();

    /**
     * Initialize your data structure here.
     */
    public RandomizedCollection() {
        nums = new ArrayList<>();
        location = new HashMap<>();
    }

    /**
     * Inserts a value to the collection. Returns true if the collection did not already contain the specified element.
     */
    public boolean insert(int val) {
        boolean exists = location.containsKey(val);

        Set<Integer> locs;
        if (exists) locs = location.get(val);
        else locs = new HashSet<>();
        // 加入元素
        nums.add(val);
        // 更新并保存其位置set
        locs.add(nums.size() - 1);
        location.put(val, locs);
        return !exists;
    }

    /**
     * Removes a value from the collection. Returns true if the collection contained the specified element.
     */
    public boolean remove(int val) {
        boolean exists = location.containsKey(val);
        if (!exists) return false;
        if (nums.get(nums.size() - 1) == val) {
            int numsSize = nums.size();

            // 移除最后一个元素
            nums.remove(numsSize - 1);

            // 更新其位置set，如果这是最后一个元素，那么删除其位置set
            Set<Integer> locs = location.get(val);
            locs.remove(numsSize - 1);
            if (locs.size() > 0) location.put(val, locs);
            else location.remove(val);

        } else {
            Set<Integer> locs = location.get(val);

            // 记录当前nums的大小,找到需要移除的位置,记录末尾元素
            int numsSize = nums.size(), removeLoc = locs.iterator().next(), lastElement = nums.get(numsSize - 1);

            // 更新并保存val的位置set
            locs.remove(removeLoc);
            if (locs.size() > 0) location.put(val, locs);
            else location.remove(val);

            // 将val(也即removeLoc处的元素)替换为lastElement，并移除末尾的lastElement
            nums.set(removeLoc, lastElement);
            nums.remove(numsSize - 1);

            // 更新并保存lastElement的位置set
            Set<Integer> locsOfLastElement = location.get(lastElement);
            locsOfLastElement.remove(numsSize - 1);
            locsOfLastElement.add(removeLoc);
            location.put(lastElement, locsOfLastElement);
        }
        return true;
    }

    /**
     * Get a random element from the collection.
     */
    public int getRandom() {
        return nums.get(random.nextInt(nums.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */