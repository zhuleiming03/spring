package spring.cloud.config;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@ActiveProfiles("symmetric")
@SpringBootTest
class SymmetricTest {

    @Test
    void encryptTest() {

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/encrypt")
                .contentType(MediaType.APPLICATION_JSON)
                .content("Hello");
        System.out.println(">>> dev encrypt text：" + mockCall(requestBuilder));

    }

    @Test
    void decryptTest() {

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/client-symmetric-config/dev");
        System.out.println(">>> dev decrypt text：" + mockCall(requestBuilder));
    }

    @Autowired
    WebApplicationContext context;
    MockMvc mockMVC;

    @BeforeEach
    void initEnvironment() {
        mockMVC = MockMvcBuilders.webAppContextSetup(context).build();
    }

    String mockCall(RequestBuilder requestBuilder) {
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
