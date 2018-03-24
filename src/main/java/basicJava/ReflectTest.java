package basicJava;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectTest {
    public static void main(String[] args) {
        try {
            test();
        } catch (Exception e) {

        }
    }

    public static void test() throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<?> c = methodClass.class;
        Object object = c.newInstance();

        //获取methodClass类的add方法
        Method method = c.getMethod("add", int.class, int.class);
        System.out.println(method);

        //调用add方法
        Object result = method.invoke(object, 1, 5);
        System.out.println(result);

        //getMethods()方法获取的所有方法
        System.out.println("getMethods获取的方法：");
        Method[] methods = c.getMethods();
        for (Method m : methods)
            System.out.println(m);

        //getDeclaredMethods()方法获取的所有方法
        System.out.println("getDeclaredMethods获取的方法：");
        Method[] declaredMethods = c.getDeclaredMethods();
        for (Method m : declaredMethods)
            System.out.println(m);
    }
}

class methodClass {
    public final int fuck = 3;

    public int add(int a, int b) {
        return a + b;
    }

    public int sub(int a, int b) {
        return a + b;
    }
}
