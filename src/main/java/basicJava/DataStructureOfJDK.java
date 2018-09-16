package basicJava;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.locks.ReentrantLock;

public class DataStructureOfJDK {
    enum Day {
        Monday, Tuesday
    }

    private static void datastructureOfJDK() {
        new ArrayList<>();
        new Vector<>();
        new Stack<>();
        new LinkedList<>();
        new HashMap<>().put(null, null);
        LinkedHashMap<Integer, Integer> lru = new LinkedHashMap<Integer, Integer>(16, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return super.removeEldestEntry(eldest);
            }
        };
        new TreeMap<>();
        new EnumMap<Day, Integer>(Day.class);
        new HashSet<>();
        new TreeSet<>();
        new PriorityQueue<>();
        new StringBuffer();
        new StringBuilder();

        Collections.synchronizedCollection(null);
        Collections.synchronizedList(null);
        Collections.synchronizedMap(null);
        Collections.synchronizedSet(null);
        Collections.synchronizedSortedMap(null);
        Collections.synchronizedSortedSet(null);
        Collections.synchronizedNavigableMap(null);
        Collections.synchronizedNavigableSet(null);

        new Thread();

        new ConcurrentHashMap<>().put(null, null);
        new CopyOnWriteArrayList<>();
        new ConcurrentSkipListMap<>();
        new AtomicInteger(1);
        new AtomicIntegerArray(new int[]{1, 2, 3});

        Executors.newCachedThreadPool();
        Executors.newFixedThreadPool(2);
        Executors.newScheduledThreadPool(2);
        Executors.newSingleThreadExecutor();
        Executors.newSingleThreadScheduledExecutor();

        new LinkedBlockingQueue<>();
        new ThreadLocal<>();
        new ReentrantLock().tryLock();
        new Semaphore(1);
        new CountDownLatch(2);
        new CyclicBarrier(2);
        new Phaser(2);
    }
}
