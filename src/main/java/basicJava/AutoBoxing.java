package basicJava;

public class AutoBoxing {
    public static void main(String[] args) {
        // 反正不要这样用
        Integer a = 1, b = 2, c = 3, d = 3, e = 321, f = 321;
        Long g = 3L;
        System.out.println(c == d); // in [-128, 127] true
        System.out.println(e == f); // not in [-128, 127] false
        System.out.println(c == (a + b));
        System.out.println(c.equals(a + b));
        System.out.println(g == (a + b));
        System.out.println(g.equals(a + b)); // equals 不会自动转型
    }
}
