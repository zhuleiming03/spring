package creating.singleton.domain;

public class SingletonOne {

    private static SingletonOne instance = new SingletonOne();

    private SingletonOne() {
        System.out.println("饿汉式");
    }

    public static SingletonOne getInstance() {
        return instance;
    }
}
