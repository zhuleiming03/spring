package spring.cloud.zuul.service.gateway;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

/**
 * 分别以下启动服务
 * java -jar eureka-service-0.0.1-SNAPSHOT.jar
 * java -jar sub-service-0.0.1-SNAPSHOT.jar --server.port=2001 --spring.application.name=sub-service
 * java -jar sub-service-0.0.1-SNAPSHOT.jar --server.port=2002 --spring.application.name=sub-service
 * java -jar sub-service-0.0.1-SNAPSHOT.jar --server.port=2003 --spring.application.name=default-service
 * java -jar sub-service-0.0.1-SNAPSHOT.jar --server.port=2004 --spring.application.name=ignored-service
 * java -jar gateway-service-0.0.1-SNAPSHOT.jar --spring.profiles.active=extend
 */
@SpringBootTest
class ExtendTest {

    @Test
    void subServiceTest() {
        for (int i = 0; i < 5; i++) {
            System.out.println("网关访问 sub service, 结果：" +
                    restTemplate.getForObject(
                            "http://localhost:8081/client-service/index",
                            String.class));
        }
    }

    @Test
    void defaultTest() {
        System.out.println("访问默认配置 default service, 结果：" +
                restTemplate.getForObject(
                        "http://localhost:8081/default-service/index",
                        String.class));
        try {
            restTemplate.getForEntity("http://localhost:8081/ignored-service/index",
                    String.class);
        } catch (HttpClientErrorException e) {
            System.out.println("访问忽略配置 ignored service, 结果：" + e.getMessage());
        }
    }

    private RestTemplate restTemplate = new RestTemplate();
}
