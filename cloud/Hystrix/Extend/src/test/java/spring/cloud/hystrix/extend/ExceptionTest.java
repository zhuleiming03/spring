package spring.cloud.hystrix.extend;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;
import spring.cloud.hystrix.extend.domain.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 运行此Test前，请先package项目，并运行jar
 * java -jar hystrix-extend-0.0.1-SNAPSHOT.jar --server.port=9010
 *
 * 异常忽略和异常捕获
 */
@SpringBootTest
class ExceptionTest {

    @Test
    void ignoreTest() {
        String url = String.format("http://%s/exception/ignore",SERVICE_NAME);
        System.out.println("result: " +
                restTemplate.getForObject(url, String.class));
    }

    @Test
    void timeoutTest() {
        String url = String.format("http://%s/exception/timeout/{0}", SERVICE_NAME);
        System.out.println("result: " +
                restTemplate.getForObject(url,
                        User.class,
                        new Random().nextInt(10)));
    }

    @Test
    void errorTest() {
        String url = String.format("http://%s/exception/error/{0}", SERVICE_NAME);
        for (int i = 0; i < 3; i++) {
            System.out.println("result: " +
                    restTemplate.getForObject(url, User.class, i));
        }
    }

    @Test
    void parallelTest() {
        String url = String.format("http://%s/exception/parallel/{0}", SERVICE_NAME);
        List<Thread> ts = new ArrayList<>(16);
        for (int i = 0; i < 15; i++) {
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("result: " + restTemplate.getForObject(url,
                            User.class, new Random().nextInt(100)));
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

    private final RestTemplate restTemplate = new RestTemplate();

    private final String SERVICE_NAME = "localhost:9010";
}
