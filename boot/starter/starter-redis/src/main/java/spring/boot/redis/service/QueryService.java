package spring.boot.redis.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import spring.boot.redis.domain.Order;

import javax.annotation.Resource;

@Service
public class QueryService {

    public Order getOrder(Integer id) {
        Order cacheOrder = toObject(redisService.get(id.toString()), Order.class);
        if (cacheOrder != null) {
            System.out.println(">>> get cache");
            return cacheOrder;
        } else {
            System.out.println(">>> get dba");
            Order order = orderService.getSimpleOrder(id);
            redisService.set(order.getId().toString(), toJson(order));
            return order;
        }
    }

    private String toJson(Object obj) {
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

    private <T> T toObject(Object json, Class<T> type) {
        if (json == null) {
            return null;
        }
        try {
            return objectMapper.readValue(json.toString(), type);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Resource
    RedisService redisService;

    @Resource
    OrderService orderService;

    @Resource
    ObjectMapper objectMapper;
}
