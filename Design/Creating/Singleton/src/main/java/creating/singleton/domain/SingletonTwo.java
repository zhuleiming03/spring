package creating.singleton.domain;

public class SingletonTwo {

    private static class SingletonHolder {
        private static final SingletonTwo INSTANCE = new SingletonTwo();
    }

    private SingletonTwo() {
        System.out.println("登记式/静态内部类");
    }

    public static SingletonTwo getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
