package spring.cloud.busrabbitclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class IndexController {

    @Value("${tag}")
    private String tag;

    @RequestMapping("index")
    public String from() {
        return this.tag;
    }
}
