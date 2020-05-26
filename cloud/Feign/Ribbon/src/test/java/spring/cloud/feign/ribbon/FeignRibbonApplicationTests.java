package spring.cloud.feign.ribbon;

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
class FeignRibbonApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void getTest() throws InterruptedException {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/get");
        for (int i = 0; i < 10; i++) {
            Thread.sleep(1_000);
            System.out.printf(">>> 第 %s 次访问结果： %s\n"
                    , i, mockCall(requestBuilder));
        }
    }

    @Test
    void postTest() {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/post");
        System.out.printf("User: %s\n", mockCall(requestBuilder));
    }

    @Test
    void repeatTest(){
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/repeat");
        System.out.printf("User: %s\n", mockCall(requestBuilder));
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
