package spring.cloud.zuul.service.gateway;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

/**
 * 分别以下启动服务
 * java -jar eureka-service-0.0.1-SNAPSHOT.jar
 * java -jar sub-service-0.0.1-SNAPSHOT.jar
 * java -jar gateway-service-0.0.1-SNAPSHOT.jar
 */
@SpringBootTest
class GatewayTest {

    @Test
    void test() {

        System.out.println("直接访问 sub service, 结果：" +
                restTemplate.getForObject("http://localhost:2001/index", String.class));

        try {
            restTemplate.getForEntity("http://localhost:8080/sub-service/index",
                    String.class);
        } catch (HttpClientErrorException e) {
            System.out.println("网关访问 sub service, 结果：" + e.getMessage());
        }

        System.out.println("网关访问（带token） sub service, 结果：" +
                restTemplate.getForObject("http://localhost:8080/sub-service/index?accessToken=123",
                        String.class));
    }

    private RestTemplate restTemplate = new RestTemplate();

    private final String URL = "http://localhost:2001/";
}
