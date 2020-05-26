package spring.cloud.ribbon.rule;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * 区域亲和启动服务命令：
 * java -jar eureka-client-0.0.1-SNAPSHOT.jar  --server.port=8001 --eureka.instance.metadata-map.zone=shanghai
 */
@SpringBootTest
class RibbonRuleApplicationTests {

    @Test
    void contextLoads() throws InterruptedException {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/index");
        for (int i = 0; i < 10; i++) {
            Thread.sleep(1_000);
            System.out.printf(">>> 第 %s 次访问结果： %s\n"
                    , i, mockCall(requestBuilder));
        }
    }

    @Autowired
    private WebApplicationContext context;
    private MockMvc mockMVC;

    @BeforeEach
    private void initEnvironment() {
        mockMVC = MockMvcBuilders.webAppContextSetup(context).build();
    }

    private String mockCall(RequestBuilder requestBuilder) {
        try {
            return mockMVC.perform(requestBuilder)
                    .andReturn()
                    .getResponse()
                    .getContentAsString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "404";
    }
}
