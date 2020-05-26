package spring.mvc.resttemplate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class ControllerTest {

    @Autowired
    WebApplicationContext context;
    private MockMvc mockMVC;

    @BeforeEach
    void initEnvironment() {
        mockMVC = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    void getUserTest() {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/get/all");
        System.out.println(">>> get all result：" + mockCall(requestBuilder));

        requestBuilder = MockMvcRequestBuilders
                .get("/get/user")
                .param("id", "2");
        System.out.println(">>> get user result：" + mockCall(requestBuilder));
    }

    @Test
    void postUserTest() {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/post/user")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\":18,\"error\":\"test\"}");
        System.out.println(">>> post new user result：" + mockCall(requestBuilder));

        requestBuilder = MockMvcRequestBuilders
                .post("/post/user")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\":18,\"rebate\":0.65}");
        System.out.println(">>> post update user result：" + mockCall(requestBuilder));
    }

    @Test
    void postCookieTest(){

        List<String> cookies = new ArrayList<String>();
        cookies.add("user=Tom;password=123456;type=customer");
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.put(HttpHeaders.COOKIE, cookies);

        // mock 未实现 cookie set 方法
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/post/cookie")
                .headers(httpHeaders)
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"Test\"}");
        System.out.println(">>> post cookie user result：" + mockCall(requestBuilder));

    }

    @Test
    void putUserTest() {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .put("/put/user")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\":20}");
        System.out.println(">>> put new user result：" + mockCall(requestBuilder));

        requestBuilder = MockMvcRequestBuilders
                .put("/put/user")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\":10,\"name\":\"Jewel\",\"rebate\":0.63}");
        System.out.println(">>> put new user result：" + mockCall(requestBuilder));
    }

    @Test
    void deleteUserTest() {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .delete("/delete/user?id=2");
        System.out.println(">>> delete user(Sean) result：" + mockCall(requestBuilder));

        requestBuilder = MockMvcRequestBuilders
                .delete("/delete/user")
                .param("id", "2");
        System.out.println(">>> delete user(Sean) result：" + mockCall(requestBuilder));
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
