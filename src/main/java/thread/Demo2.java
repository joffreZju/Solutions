package thread;

/**
 * Created by joffre on 2017/9/5.
 */
public class Demo2 {
    public static void main(String[] args) {
        Animal p = new Penguin("企鹅", 1);
        Animal m = new Mouse("老鼠", 2);
        p.introduction();
        m.introduction();
    }
}

class Animal {
    protected String name;
    private int id;

    Animal(String myName, int myid) {
        name = myName;
        id = myid;
    }

    public void eat() {
        System.out.println(name + "正在吃");
    }

    public void sleep() {
        System.out.println(name + "正在睡");
    }

    public void introduction() {
        System.out.println("大家好！我是" + id + "号" + name + ".");
    }
}

class Penguin extends Animal {
    public Penguin(String myName, int myid) {
        super(myName, myid);
    }
}

class Mouse extends Animal {
    public Mouse(String myName, int myid) {
        super(myName, myid);
    }
}