package spring.cloud.sleuth.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@RestController
public class HelloController {

    @RequestMapping("index")
    public String hello(HttpServletRequest request) {
        System.out.println(LocalDateTime.now() + "  INFO client two called");
        System.out.printf("%s  Trace ID: %s, Span ID: %s,Parent Span ID: %s, 是否抽样: %s\n",
                LocalDateTime.now(),
                request.getHeader("X-B3-TraceId"),
                request.getHeader("X-B3-SpanId"),
                request.getHeader("X-B3-ParentSpanId"),
                request.getHeader("X-B3-Sampled")
        );
        return restTemplate.getForObject(URL, String.class);
    }

    private final static String URL = "http://client-three/index";

    @Resource
    private RestTemplate restTemplate;
}
