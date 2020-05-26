package spring.cloud.hystrix.extend;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;
import spring.cloud.hystrix.extend.domain.User;

/**
 * 运行此Test前，请先package项目，并运行jar
 * java -jar hystrix-extend-0.0.1-SNAPSHOT.jar --server.port=9010
 *
 * 分别用注解和编程两种方式实现熔断
 */
@SpringBootTest
class DefinedTest {

    @Test
    void annotationTest() {
        for (int i = 1; i < 6; i++) {
            String url = String.format("http://%s/defined/annotation/%d",
                    SERVICE_NAME, i);
            System.out.println("result: " +
                    restTemplate.getForObject(url, User.class));
        }
    }

    @Test
    void annotationAsyncTest() {
        for (int i = 1; i < 6; i++) {
            String url = String.format("http://%s/defined/annotation/async/%d",
                    SERVICE_NAME, i);
            System.out.println("result: " +
                    restTemplate.getForObject(url, User.class));
        }
    }

    @Test
    void codeTest() {
        for (int i = 1; i < 6; i++) {
            String url = String.format("http://%s/defined/code/%d",
                    SERVICE_NAME, i);
            System.out.println("result: " +
                    restTemplate.getForObject(url, User.class));
        }
    }

    @Test
    void codeAsyncTest() {
        for (int i = 1; i < 6; i++) {
            String url = String.format("http://%s/defined/code/async/%d",
                    SERVICE_NAME, i);
            System.out.println("result: " +
                    restTemplate.getForObject(url, User.class));
        }
    }

    private RestTemplate restTemplate = new RestTemplate();

    private final String SERVICE_NAME = "localhost:9010";
}
