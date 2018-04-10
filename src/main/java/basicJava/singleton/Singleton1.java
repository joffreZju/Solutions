package basicJava.singleton;

public class Singleton1 {
    private static Singleton1 instance;

    private Singleton1() {
    }

    // 线程不安全，高并发会创建不止一个
    public static Singleton1 getInstance() {
        if (instance == null) {
            instance = new Singleton1();
        }
        return instance;
    }
}
