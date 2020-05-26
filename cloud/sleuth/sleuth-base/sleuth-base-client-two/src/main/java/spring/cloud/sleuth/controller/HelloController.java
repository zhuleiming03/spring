package spring.cloud.sleuth.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.Enumeration;

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

        return "ok";
    }
}
