package basicJava.singleton;

public class Singleton4 {
    private static final Singleton4 instance = new Singleton4();

    private Singleton4() {
    }

    private static Singleton4 getInstance() {
        return instance;
    }
}
