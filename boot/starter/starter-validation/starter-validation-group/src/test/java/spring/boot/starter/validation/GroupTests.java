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
class GroupTests {

    @Test
    void query() {

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/query")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"type\":1,\"query\":\"success\"}");
        System.out.println(">>> post result：" + mockCall(requestBuilder));

        requestBuilder = MockMvcRequestBuilders
                .post("/query")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"type\":1,\"alter\":\"fail\"}");
        System.out.println(">>> post result：" + mockCall(requestBuilder));
    }

    @Test
    void alter() {

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/alter")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"type\":2,\"alter\":\"success\"}");
        System.out.println(">>> post result：" + mockCall(requestBuilder));

        requestBuilder = MockMvcRequestBuilders
                .post("/alter")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"type\":2,\"query\":\"fail\"}");
        System.out.println(">>> post result：" + mockCall(requestBuilder));
    }

    @Autowired
    WebApplicationContext context;
    private MockMvc mockMVC;

    @BeforeEach
    void initEnvironment() {
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
        return "405";
    }
}
