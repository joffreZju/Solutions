package leetcode.round_1.problem401;

import java.util.HashMap;
import java.util.Map;

/**
 * 460. LFU Cache
 */
class LFUCache {
    private class Node {
        int key, value, count;
        Node prev, next;

        public Node(int key, int value, int count) {
            this.key = key;
            this.value = value;
            this.count = count;
        }
    }

    // map 中存放 kv
    private Map<Integer, Node> map;

    // countMap 按照 count 分组存放 node, count 相同的 node 以双链表的形式存放在一组
    // 每一组都有一个 fakeHead,
    // 在 fakeHead.next 插入 node
    // 在 fakeHead.prev 移除 node, 这样保证了 count 相同时按照最近访问原则进行删除
    private Map<Integer, Node> countMap;

    // minCount 在 get 和 put 中要同步更新
    private int minCount = 0, cap;

    public LFUCache(int capacity) {
        map = new HashMap<>();
        countMap = new HashMap<>();
        cap = capacity;
    }

    // 将 node 链接到 node.counter 对应的链表上
    private void linkToFakeHead(Node node) {
        Node fake;
        if (!countMap.containsKey(node.count)) {
            fake = new Node(-1, -1, -1);
        } else {
            fake = countMap.get(node.count);
        }
        if (fake.next != null) {
            node.next = fake.next;
            fake.next.prev = node;

            node.prev = fake;
            fake.next = node;
        } else {
            fake.next = node;
            node.prev = fake;

            fake.prev = node;
            node.next = fake;
        }
        countMap.put(node.count, fake);
    }

    // 已有 node 被访问: node.count++
    private void addCount(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        Node fake = countMap.get(node.count);
        if (fake.next == fake) {
            fake.next = null;
            fake.prev = null;
            if (node.count == minCount) minCount++;
        }
        node.count++;
        linkToFakeHead(node);
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        Node node = map.get(key);
        addCount(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (!map.containsKey(key)) {
            Node node = new Node(key, value, 0);
            linkToFakeHead(node);
            map.put(key, node);
            if (map.size() > cap) {
                Node fake = countMap.get(minCount), last = fake.prev;
                if (last.prev == fake) {
                    fake.prev = null;
                    fake.next = null;
                } else {
                    fake.prev = last.prev;
                    last.prev.next = fake;
                }
                map.remove(last.key);
            }
            minCount = 0;
        } else {
            Node node = map.get(key);
            node.value = value;
            addCount(node);
        }
    }

    public static void main(String[] args) {
        LFUCache cache = new LFUCache(2 /* capacity */);

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // returns 1
        cache.put(3, 3);                        // evicts key 2
        System.out.println(cache.get(2));       // returns -1 (not found)
        System.out.println(cache.get(3));       // returns 3.
        cache.put(4, 4);                        // evicts key 1.
        System.out.println(cache.get(1));       // returns -1 (not found)
        System.out.println(cache.get(3));       // returns 3
        System.out.println(cache.get(4));       // returns 4
    }
}
