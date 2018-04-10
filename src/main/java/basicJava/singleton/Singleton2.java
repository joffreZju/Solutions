package basicJava.singleton;

public class Singleton2 {
    private static Singleton2 instance;

    private Singleton2() {
    }

    // 线程安全，效率低，其实只需要第一次创建时同步
    public static synchronized Singleton2 getInstance() {
        if (instance == null) {
            instance = new Singleton2();
        }
        return instance;
    }
}
