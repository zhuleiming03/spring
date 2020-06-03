package spring.boot.starter.validation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
class ControllerTests {

    @Autowired
    WebApplicationContext context;
    private MockMvc mockMVC;

    @BeforeEach
    void initEnvironment() {
        mockMVC = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    void success() {

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/index")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\":12,\"context\":\"test\"}");
        System.out.println(">>> post result：" + mockCall(requestBuilder));
    }

    @Test
    void fail() {

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/index")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"context\":\"test\"}");
        System.out.println(">>> post result：" + mockCall(requestBuilder));
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
        return "405";
    }
}
