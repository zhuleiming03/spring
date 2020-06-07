package spring.cloud.netflix.ribbon;

import com.netflix.loadbalancer.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableDiscoveryClient
@SpringBootApplication
public class NetflixRibbonRuleApplication {

    public static void main(String[] args) {
        SpringApplication.run(NetflixRibbonRuleApplication.class, args);
    }

    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public IRule ribbonRule() {

        // 策略规则有待考证

        // 默认 ZoneAvoidanceRule 区域亲和策略
        //return new ZoneAvoidanceRule();
        // 线性轮询策略
        //return new RoundRobinRule();
        // 随机策略
        //return new RandomRule();
        // 权重策略
        return new WeightedResponseTimeRule();
        // 最空闲策略
        //return new BestAvailableRule();
    }
}
