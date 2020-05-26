package spring.cloud.zuul.service.sub.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@RestController
public class IndexController {

    @GetMapping("index")
    public String getInstances() {
        return String.format("This service port : %s", port);
    }

    @PostMapping("cookie")
    public String getCookie(@RequestBody String name, HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        String result = name;
        if (cookies != null && cookies.length > 0) {
            StringBuilder stringBuilder = new StringBuilder();
            for (Cookie cookie : cookies) {
                stringBuilder.append("name:")
                        .append(cookie.getName())
                        .append(",value:")
                        .append(cookie.getValue())
                        .append(",");
            }
            result = String.format("%s %s cookies {%s}", LocalDateTime.now(), name,
                    stringBuilder.substring(0, stringBuilder.length() - 1));
        }
        return result;
    }

    @Value("${server.port}")
    private String port;
}
