package basicJava.singleton;

import java.io.Serializable;

public class Singleton3 implements Serializable {
    private static volatile Singleton3 instance;

    private Singleton3() {
    }

    // 必须要加volatile 见下文：
    // http://wuchong.me/blog/2014/08/28/how-to-correctly-write-singleton-pattern/
    public static Singleton3 getInstance() {
        if (instance == null) {
            synchronized (Singleton3.class) {
                if (instance == null) {
                    instance = new Singleton3();
                }
            }
        }
        return instance;
    }

    // http://www.hollischuang.com/archives/1144
    private Object readResolve() {
        return instance;
    }

}
