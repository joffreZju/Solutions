package basicJava.singleton;

class Resource {
}

enum Singleton6 {
    instance;

    private Resource resource;

    private Singleton6() {
        resource = new Resource();
    }

    public Resource getInstance() {
        return resource;
    }
}

class Client {
    public static void main(String[] args) {
        System.out.println("hello");
        Resource resource = Singleton6.instance.getInstance();
    }
}
