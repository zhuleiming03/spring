package demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletResponse;
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
    void getTest() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/feign/get");
        String contentAsString = mockMVC.perform(requestBuilder)
                .andReturn()
                .getResponse()
                .getContentAsString();
        System.out.printf("【GET】InstanceInfo： %s\n", contentAsString);
    }

    @Test
    void postTest() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/feign/post");
        MockHttpServletResponse response = mockMVC.perform(requestBuilder)
                .andReturn()
                .getResponse();
        System.out.printf("【POST】User: %s\n", new String(response.getContentAsByteArray()));
    }

    @Autowired
    private WebApplicationContext context;
    private MockMvc mockMVC;

    @BeforeEach
    private void initEnvironment() {
        mockMVC = MockMvcBuilders.webAppContextSetup(context).build();
    }

}
