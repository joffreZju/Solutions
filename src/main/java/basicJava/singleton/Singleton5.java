package basicJava.singleton;

public class Singleton5 {
    private static class Holder {
        private static Singleton5 instance = new Singleton5();
    }

    private Singleton5() {
    }

    private static Singleton5 getInstance() {
        return Holder.instance;
    }
}
