package basicJava;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.locks.ReentrantLock;

public class StringIntern {
    // 测试 String.intern()的使用
    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = "abc";
        String str3 = "a";
        String str4 = "bc";
        String str5 = str3 + str4;
        String str6 = new String(str1);

        printnb("------no intern------");
        printnb("str1 == str2 ? ");
        print(str1 == str2);//true
        printnb("str1 == str5 ? ");
        print(str1 == str5);//false 字符串 + 先用一个StringBuilder append 然后toString()返回新对象，所以不是同一个引用。
        printnb("str1 == str6 ? ");
        print(str1 == str6);//false

        printnb("------intern------");
        printnb("str1.intern() == str2.intern() ? ");
        print(str1.intern() == str2.intern());//true
        printnb("str1.intern() == str5.intern() ? ");
        print(str1.intern() == str5.intern());//true
        printnb("str1.intern() == str6.intern() ? ");
        print(str1.intern() == str6.intern());//true
        printnb("str1 == str6.intern() ? ");
        print(str1 == str6.intern());//true

        new ArrayList<>();
        new Vector<>();
        new Stack<>();
        new LinkedList<>();
        new HashMap<>().put(null, null);
        new LinkedHashMap<>();
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
        new CountDownLatch(2);
        new CyclicBarrier(2);
        new Phaser(2);

    }

    enum Day {Monday, Sunday}

    private static void printnb(String s) {
        System.out.println(s);
    }

    private static void print(boolean f) {
        System.out.println(f);
    }
}

