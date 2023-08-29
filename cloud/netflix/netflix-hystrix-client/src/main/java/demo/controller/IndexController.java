package demo.controller;

import demo.api.FallbackApi;
import demo.api.FallbackFactoryApi;
import demo.api.NoneApi;
import demo.domain.User;
import demo.service.IndexService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
public class IndexController {

    @Resource
    private IndexService indexService;

    @Resource
    private FallbackApi fallbackApi;

    @Resource
    private NoneApi noneApi;

    @Resource
    private FallbackFactoryApi fallbackFactoryApi;

    /**
     * 随机获取结果
     *
     * @return 没有熔断
     */
    @GetMapping(value = "random/none/fallback")
    public User getRandomNone() {
        return noneApi.getNoneBackUser(new Random().nextInt(4));
    }

    /**
     * 随机获取结果
     *
     * @return 客户端定义熔断
     */
    @GetMapping(value = "random/client/fallback")
    public User getRandomClientFallback() {
        return indexService.getClientFallbackUser();
    }

    /**
     * 随机获取结果
     *
     * @return 服务端标准熔断
     */
    @GetMapping(value = "random/service/fallback")
    public User getRandomServiceFallback() {
        return fallbackApi.getFallBackUser(new Random().nextInt(4));
    }

    /**
     * 模拟错误类型
     *
     * @param id 0 or 1 or 2 or 3
     * @return 服务端自定义熔断 0-异常 1-超时 2-成功 3-多线程
     */
    @GetMapping("simulate/{id}")
    public User getSimulateUser(@PathVariable("id") Integer id) {
        if (id == 3) {
            multiThread();
            return new User(3, "please look log");
        }
        return fallbackFactoryApi.getFallBackFactoryUser(id);
    }

    private void multiThread() {
        List<Thread> ts = new ArrayList<>(16);
        for (int i = 0; i < 11; i++) {
            Thread t = new Thread(() -> {
                while (true) {
                    System.out.println("result: " + fallbackFactoryApi.getFallBackFactoryUser(3));
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
}
