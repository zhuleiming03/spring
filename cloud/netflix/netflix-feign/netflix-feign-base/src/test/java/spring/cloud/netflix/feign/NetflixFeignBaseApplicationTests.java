package spring.cloud.netflix.feign;

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
class NetflixFeignBaseApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void getTest() {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/get");
        System.out.printf("【GET】InstanceInfo： %s\n", mockCall(requestBuilder));
    }

    @Test
    void postTest() {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/post");
        System.out.printf("【POST】User: %s\n", mockCall(requestBuilder));
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
