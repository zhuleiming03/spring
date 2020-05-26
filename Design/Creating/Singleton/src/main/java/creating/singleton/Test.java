package creating.singleton;

import creating.singleton.domain.SingletonOne;
import creating.singleton.domain.SingletonTwo;

public class Test {

    public static void main(String[] args) {

        //是否 Lazy 初始化：否
        //是否多线程安全：是
        //描述：这种方式比较常用，但容易产生垃圾对象。
        //优点：没有加锁，执行效率会提高。
        //缺点：类加载时就初始化，浪费内存。
        SingletonOne one = SingletonOne.getInstance();

        //是否 Lazy 初始化：是
        //是否多线程安全：是
        //描述：这种方式能达到双检锁方式一样的功效，但实现更简单。
        // 对静态域使用延迟初始化，应使用这种方式
        SingletonTwo two = SingletonTwo.getInstance();
    }
}
