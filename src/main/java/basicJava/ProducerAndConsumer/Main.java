package basicJava.ProducerAndConsumer;

import java.util.*;

public class Main {
    private static Queue<Integer> queue;
    private static final int cap = 100;
    private static final Object LOCK = new Object();

    public static void main(String[] args) {
        queue = new LinkedList<>();

        Runnable producer = () -> {
            while (true) {
                synchronized (LOCK) {
                    while (queue.size() == cap) {
                        try {
                            LOCK.wait();
                        } catch (Exception e) {
                        }
                    }
                    queue.offer(1);
                    LOCK.notify();
                }
            }
        };

        Runnable consumer = () -> {
            while (true) {
                synchronized (LOCK) {
                    while (queue.size() == 0) {
                        try {
                            LOCK.wait();
                        } catch (Exception e) {
                        }
                    }
                    int c = queue.poll();
                    LOCK.notify();
                }
            }
        };

        new Thread(producer).start();
        new Thread(consumer).start();

        new LinkedHashMap<>().entrySet();
        new HashMap<>();
    }

}


