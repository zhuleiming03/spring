package spring.cloud.hystrix.extend;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;
import spring.cloud.hystrix.extend.domain.User;

import java.util.Random;

@SpringBootTest
class TurbineTest {

    @Test
    void simulateTimeout() {

        String urlOne = "http://localhost:9010/simple";
        String urlTwo = "http://localhost:9011/simple";

        while (true) {
            threadSleep();
            System.out.println("result: " +
                    restTemplate.getForObject(urlOne, User.class));
            System.out.println("result: " +
                    restTemplate.getForObject(urlTwo, User.class));
        }
    }

    private void threadSleep() {
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private RestTemplate restTemplate = new RestTemplate();

    private final String SERVICE_NAME = "localhost:9010";
}
