package spring.boot.application.service;

import org.springframework.stereotype.Service;

@Service
public class CommonService {

    public CommonService() {
        System.out.println("Bean commonService create");
    }
}
