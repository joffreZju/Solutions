package basicJava;

class OuterClass {
    public void display() {
        new InnerClass();
        System.out.println("basicJava.OuterClass...");
    }

    public class InnerClass {
        public OuterClass getOuterClass() {
            return OuterClass.this;
        }
    }

    public static class InnerClassStatic {
        public OuterClass getOuterClass() {
            return new OuterClass();
        }
    }

}

public class InnerClassClient {
    public static void main(String[] args) {
        OuterClass outerClass = new OuterClass();
        // 依赖外部类
        OuterClass.InnerClass innerClass = outerClass.new InnerClass();
        // 不依赖外部类
        OuterClass.InnerClassStatic innerClassStatic = new OuterClass.InnerClassStatic();
        innerClass.getOuterClass().display();
        innerClassStatic.getOuterClass();
    }

}