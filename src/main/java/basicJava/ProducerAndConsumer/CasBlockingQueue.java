package basicJava.ProducerAndConsumer;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class CasBlockingQueue<E> {
    private Object[] data;
    private int cap;
    private AtomicInteger readIndex, writeIndex, maxReadIndex;

    public CasBlockingQueue(int cap) {
        this.cap = cap;
        this.data = new Object[cap];
        this.readIndex = new AtomicInteger(0);
        this.writeIndex = new AtomicInteger(0);
        this.maxReadIndex = new AtomicInteger(0);
    }

    private int idx(int index) {
        return index % cap;
    }

    public boolean isEmpty() {
        return idx(readIndex.get()) == idx(maxReadIndex.get());
    }

    public int size() {
        return maxReadIndex.get() - readIndex.get();
    }

    public boolean put(Object e) {
        int r, w;
        do {
            r = readIndex.get();
            w = writeIndex.get();
            if (idx(r) == idx(w + 1)) {
                return false;
            }
        } while (!writeIndex.compareAndSet(w, w + 1));

        data[idx(w)] = e;

        while (!maxReadIndex.compareAndSet(w, w + 1)) {
            // Thread.yield(); // 多 producer 竞争更新 maxReadIndex, 需要 FIFO
        }
        return true;
    }

    @SuppressWarnings("unchecked")
    public E poll() {
        int r, maxR;
        while (true) {
            r = readIndex.get();
            maxR = maxReadIndex.get();
            if (idx(r) == idx(maxR)) {
                return null; // queue is empty
            }

            Object e = data[idx(r)];
            if (readIndex.compareAndSet(r, r + 1)) {
                data[idx(r)] = null;
                return (E) e;
            }
        }
    }

    public static void main(String[] args) {
        CasBlockingQueue<Integer> queue = new CasBlockingQueue<>(10000000);
        // BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(10000000);

        long s = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            // queue.offer(i);
            queue.put(i);
        }
        System.out.println(System.currentTimeMillis() - s);

        // Producer producer = new Producer1(queue);
        // Consumer consumer = new Consumer1(queue);
        // new Thread(producer).start();
        // new Thread(consumer).start();
    }
}

class Producer1 implements Runnable {
    CasBlockingQueue<Integer> queue;

    public Producer1(CasBlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        Random random = new Random();
        int i = 0;
        while (true) {
            try {
                while (!queue.put(i)) {
                    Thread.yield();
                }
                System.out.println("producer:           " + i++);
                Thread.sleep(random.nextInt(3));
            } catch (Throwable e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer1 implements Runnable {
    CasBlockingQueue<Integer> queue;

    public Consumer1(CasBlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            Integer msg = queue.poll();
            if (msg != null) System.out.println("consumer:    " + msg);
        }
    }
}
