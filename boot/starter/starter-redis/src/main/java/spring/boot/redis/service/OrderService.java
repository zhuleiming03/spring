package spring.boot.redis.service;

import org.springframework.stereotype.Service;
import spring.boot.redis.domain.Bill;
import spring.boot.redis.domain.Item;
import spring.boot.redis.domain.Order;

import java.util.*;

@Service
public class OrderService {

    public Order getSimpleOrder(Integer id) {
        return new Order(id, getProduct());
    }

    public Order getFullOrder(Integer id) {
        return new Order(id, getProduct(), getBill());
    }

    private Map<Integer, Bill> getBill() {
        Random random = new Random();
        int k = random.nextInt(12);
        Map<Integer, Bill> billMap = new HashMap<>();
        for (int i = 0; i < k; i++) {
            billMap.put(i + 1, new Bill(i + 1, getItem()));
        }
        return billMap;
    }

    private List<Item> getItem() {
        Random random = new Random();
        int k = random.nextInt(5);
        List<Item> items = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            items.add(new Item(i + 5, random.nextFloat() * 10000));
        }
        return items;
    }

    private String getProduct() {
        int i = new Random().nextInt(3);
        if (i % 2 == 0) {
            return "豆豆钱";
        } else {
            return "卡卡贷";
        }
    }
}
