package spring.boot.starter;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import spring.boot.starter.instance.ExtendQueryInstance;

import java.io.IOException;

@SpringBootTest
class ExtendQueryTest {

    @Autowired
    ExtendQueryInstance instance;

    @Test
    void match() throws IOException {
        instance.match();
    }

    @Test
    void term() throws IOException {
        instance.term();
    }
}
