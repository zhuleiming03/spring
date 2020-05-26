package structural.bridge;

import structural.bridge.domain.IUser;
import structural.bridge.domain.Order;
import structural.bridge.domain.User;

public class Test {

    public static void main(String[] args) {
        IUser user = new User("Tom");
        Order order = new Order(user);
        order.setAmount(1000f);
        System.out.println(order);
    }
}
