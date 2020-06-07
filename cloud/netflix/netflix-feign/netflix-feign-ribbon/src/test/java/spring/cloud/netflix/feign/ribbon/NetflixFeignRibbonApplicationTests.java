package spring.cloud.netflix.feign.ribbon;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
class NetflixFeignRibbonApplicationTests {

    @Test
    void contextLoads() throws InterruptedException {

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/ribbon");
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
