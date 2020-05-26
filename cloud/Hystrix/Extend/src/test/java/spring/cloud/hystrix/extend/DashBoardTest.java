package spring.cloud.hystrix.extend;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;
import spring.cloud.hystrix.extend.domain.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@SpringBootTest
class DashBoardTest {

    @Test
    void simulateTimeout() {

        while (true) {
            threadSleep();
            String url = String.format("http://%s/defined/annotation/%d",
                    SERVICE_NAME, new Random().nextInt(100));
            System.out.println("result: " +
                    restTemplate.getForObject(url, User.class));
        }
    }

    @Test
    void simulateRejected() {
        String url = String.format("http://%s/exception/parallel/{0}", SERVICE_NAME);
        List<Thread> ts = new ArrayList<>(16);
        for (int i = 0; i < 6; i++) {
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        System.out.println("result: " + restTemplate.getForObject(url,
                                User.class, new Random().nextInt(100)));
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

    @Test
    void simulateError() {
        while (true) {
            threadSleep();
            String url = String.format("http://%s/exception/error/0", SERVICE_NAME);
            System.out.println("result: " +
                    restTemplate.getForObject(url, User.class));
        }
    }

    @Test
    void threadPool() {

        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                String url = String.format("http://%s/exception/error/0", SERVICE_NAME);
                while (true) {
                    threadSleep();
                    System.out.println("result: " +
                            restTemplate.getForObject(url, User.class));
                }
            }
        });

        Thread threadTwo = new Thread(new Runnable() {
            @Override
            public void run() {
                String url = String.format("http://%s/defined/annotation/{0}", SERVICE_NAME);
                while (true) {
                    System.out.println("result: " +
                            restTemplate.getForObject(url, User.class,
                                    new Random().nextInt(100)));
                }
            }
        });

        threadOne.start();
        threadTwo.start();
        // 等待所有线程执行完成
        try {
            threadOne.join();
            threadTwo.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
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
