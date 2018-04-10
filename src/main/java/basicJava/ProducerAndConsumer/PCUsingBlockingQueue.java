package basicJava.ProducerAndConsumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class PCUsingBlockingQueue {
    public static void main(String[] args) throws Exception {
        BlockingQueue<Integer> queue = new LinkedBlockingQueue<>();
        new Thread(new Producer(queue)).start();
        Thread.sleep(10000);
        new Thread(new Consumer(queue)).start();
    }
}

class Producer implements Runnable {
    private BlockingQueue<Integer> queue;

    Producer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                System.out.println(Thread.currentThread().getName() + "produce: " + i);
                queue.put(i);
                // Thread.sleep((long) (Math.random() * 3000));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer implements Runnable {
    private BlockingQueue<Integer> queue;

    Consumer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 8; i++) {
            try {
                System.out.println(Thread.currentThread().getName() + "consume: " + queue.take());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
