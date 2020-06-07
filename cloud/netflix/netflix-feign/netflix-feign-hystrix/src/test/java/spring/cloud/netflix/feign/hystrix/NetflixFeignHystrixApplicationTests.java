package spring.cloud.netflix.feign.hystrix;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;
import spring.cloud.netflix.feign.hystrix.domian.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * java -jar netflix-feign-hystrix-0.0.1-SNAPSHOT.jar --server.port=8081
 */
@SpringBootTest
class NetflixFeignHystrixApplicationTests {

    @Test
    void contextLoads() {
        String url = String.format("http://%s/simulate?id={0}", SERVICE_NAME);
        List<Thread> ts = new ArrayList<>(16);
        for (int i = 0; i < 11; i++) {
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        System.out.println("result: " + restTemplate.getForObject(url,
                                User.class, new Random().nextInt(10)));
                    }
                }
            });
            ts.add(t);
        }
        // 启动所有线程
        for (Thread t : ts) {
            t.start();
        }
        // 等待所有线程执行完成
        for (Thread t : ts) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private RestTemplate restTemplate = new RestTemplate();

    private final static String SERVICE_NAME = "localhost:8081";
}
