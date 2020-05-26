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
 * 请求合并操作
 * 循环调用不会触发合并操作，多线程才能触发合并操作
 */
@SpringBootTest
class CollapseTest {

    @Test
    void codeLoopTest() {
        for (int i = 1; i < 6; i++) {
            String url = String.format("http://%s/collapse/code/{0}", SERVICE_NAME);
            System.out.println("result: " +
                    restTemplate.getForObject(url, User.class, i));
        }
    }

    @Test
    void annotationLoopTest() {
        for (int i = 1; i < 6; i++) {
            String url = String.format("http://%s/collapse/annotation/{0}", SERVICE_NAME);
            System.out.println("result: " +
                    restTemplate.getForObject(url, User.class, i));
        }
    }

    @Test
    void codeParallelTest() {
        String url = String.format("http://%s/collapse/code/{0}", SERVICE_NAME);
        parallelTest(url);
    }

    @Test
    void annotationParallelTest() {
        String url = String.format("http://%s/collapse/annotation/{0}", SERVICE_NAME);
        parallelTest(url);
    }


    private void parallelTest(String url) {
        List<Thread> ts = new ArrayList<>(16);
        for (int i = 0; i < 12; i++) {
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
