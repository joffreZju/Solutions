package leetcode.round_1.problem101;

import java.util.*;

/**
 * 146. LRU Cache
 */
class LRUCache {
    private class Node {
        int key, value;
        Node prev, next;

        Node(int key, int value, Node prev, Node next) {
            this.key = key;
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }

    private Map<Integer, Node> map;
    private Node fakeHead, tail;
    private int cap;

    public LRUCache(int cap) {
        this.map = new HashMap<>();
        this.cap = cap;
        fakeHead = new Node(-1, -1, null, null);
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        Node node = map.get(key);
        moveToTail(node);
        return node.value;
    }

    private void moveToTail(Node node) {
        if (node != tail) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.prev = tail;
            tail.next = node;
            tail = node;
        }
        map.put(node.key, node);
    }

    public void put(int key, int value) {
        if (!map.containsKey(key)) {
            Node node = new Node(key, value, null, null);
            if (tail == null) {
                fakeHead.next = node;
                node.prev = fakeHead;
            } else {
                tail.next = node;
                node.prev = tail;
            }
            tail = node;
            map.put(key, node);
            if (map.size() > cap) {
                map.remove(fakeHead.next.key);
                fakeHead.next = fakeHead.next.next;
                fakeHead.next.prev = fakeHead;
            }
            return;
        }
        Node node = map.get(key);
        node.value = value;
        moveToTail(node);
    }


    // Solution1
    // key-value map, key-age map, age-key map, minAge, maxAge
    // 每次get和put都更新以上数据结构，缓存溢出时删除 minAge 对应的 Key
    // private Map<Integer, Integer> kv, ka, ak;
    // private int cap, maxAge, minAge;
    //
    // public LRUCache(int capacity) {
    //     kv = new HashMap<>();
    //     ka = new HashMap<>();
    //     ak = new HashMap<>();
    //     maxAge = 0;
    //     minAge = 0;
    //     cap = capacity;
    // }
    //
    // public int get(int key) {
    //     if (!kv.containsKey(key)) return -1;
    //     int age = ka.get(key);
    //     ka.put(key, maxAge + 1);
    //     ak.remove(age);
    //     ak.put(maxAge + 1, key);
    //     maxAge++;
    //     if (age == minAge) changeMinAge(age);
    //     return kv.get(key);
    // }
    //
    // public void put(int key, int value) {
    //     if (kv.containsKey(key)) {
    //         int age = ka.get(key);
    //         kv.put(key, value);
    //         ka.put(key, maxAge + 1);
    //         ak.put(maxAge + 1, key);
    //         ak.remove(age);
    //         maxAge++;
    //         if (age == minAge) changeMinAge(age);
    //         return;
    //     }
    //     if (kv.size() >= cap) removeMinAgeKey();
    //     kv.put(key, value);
    //     ka.put(key, maxAge + 1);
    //     ak.put(maxAge + 1, key);
    //     maxAge++;
    //     if (minAge == 0) minAge = maxAge;
    // }
    //
    // private void removeMinAgeKey() {
    //     int k = ak.get(minAge), age = minAge;
    //     kv.remove(k);
    //     ka.remove(k);
    //     ak.remove(minAge);
    //     changeMinAge(age);
    // }
    //
    // private void changeMinAge(int min) {
    //     for (int i = min + 1; i <= maxAge; i++) {
    //         if (ak.containsKey(i)) {
    //             minAge = i;
    //             break;
    //         }
    //     }
    // }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2 /* capacity */);

        // cache.put(2, 1);
        // cache.put(2, 2);
        // System.out.println(cache.get(2));
        // cache.put(1, 1);
        // cache.put(4, 1);
        // System.out.println(cache.get(2));

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // returns 1
        cache.put(3, 3);    // evicts key 2
        System.out.println(cache.get(2));       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        System.out.println(cache.get(1));       // returns -1 (not found)
        System.out.println(cache.get(3));       // returns 3
        System.out.println(cache.get(4));       // returns 4
    }
}