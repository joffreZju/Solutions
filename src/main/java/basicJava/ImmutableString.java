package basicJava;

import java.util.ArrayList;
import java.util.List;

public class ImmutableString {

    public static void main(String[] args) {
        String s = "haha";
        change(s);
        System.out.println(s);

        List<String> list = new ArrayList<>();
        list.add("haha");
        change(list);
        System.out.println(list);
    }

    private static void change(String s) {
        s += "_____";
        System.out.println(s);
    }


    private static void change(List<String> list) {
        list.add("____");
        System.out.println(list);
    }
}
