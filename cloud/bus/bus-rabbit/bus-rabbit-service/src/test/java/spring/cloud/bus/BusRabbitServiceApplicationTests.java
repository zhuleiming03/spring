package spring.cloud.bus;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class BusRabbitServiceApplicationTests {

    /**
     * java -jar bus-rabbit-service-0.0.1-SNAPSHOT.jar --server.port=1001
     * java -jar bus-rabbit-client-0.0.1-SNAPSHOT.jar --server.port=3001 --spring.application.name=client-bus-rabbit-one
     * java -jar bus-rabbit-client-0.0.1-SNAPSHOT.jar --server.port=3002 --spring.application.name=client-bus-rabbit-two
     *
     * 1. 分别查看客户端配置值 queryConfigTest()
     * 2. 修改 client-bus-rabbit-one-config 后 刷新服务端配置值
     * 3. 分别查看客户端配置值 queryConfigTest()
     */
    @Test
    void contextLoads() {
    }

    @Test
    void queryConfigTest() {

        RestTemplate restTemplate = new RestTemplate();

        System.out.println("service client-bus-rabbit-one config : " +
                restTemplate.getForObject("http://localhost:3001/index", String.class));

        System.out.println("service client-bus-rabbit-two config : " +
                restTemplate.getForObject("http://localhost:3002/index", String.class));

    }

    @Test
    void refusedTest() {
        Map<String, Object> params = new HashMap<>(1);
        params.put("destination", "client-bus-rabbit-one:**");
        new RestTemplate().postForObject(
                "http://localhost:1001/actuator/bus-refresh",
                params, String.class);
    }

}
