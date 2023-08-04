package demo.controller;

import demo.service.IndexService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class IndexController {

    @Resource
    private IndexService indexService;

    @GetMapping(value = "index")
    public String indexConsumer() {
        return indexService.index().toString();
    }

}
