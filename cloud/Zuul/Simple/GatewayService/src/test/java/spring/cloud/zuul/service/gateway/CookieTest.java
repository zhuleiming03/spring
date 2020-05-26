package spring.cloud.zuul.service.gateway;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * 分别以下启动服务
 * java -jar eureka-service-0.0.1-SNAPSHOT.jar
 * java -jar sub-service-0.0.1-SNAPSHOT.jar
 * java -jar gateway-service-0.0.1-SNAPSHOT.jar --spring.profiles.active=cookie
 */
@SpringBootTest
class CookieTest {

    @Test
    void test() {

        //在 header 中存入cookies
        HttpHeaders headers = new HttpHeaders();
        List<String> cookies = new ArrayList<String>();
        cookies.add("user=Tom;password=123456;type=customer");
        headers.put(HttpHeaders.COOKIE, cookies);
        HttpEntity<String> request = new HttpEntity<>("Test", headers);

        System.out.println("结果：" + restTemplate.postForObject(
                "http://localhost:8082/sub-service/cookie",
                request, String.class));
    }

    private RestTemplate restTemplate = new RestTemplate();
}
