package spring.boot.starter;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import spring.boot.starter.instance.BulkInstance;

import java.io.IOException;

@SpringBootTest
class BulkTest {

    @Autowired
    BulkInstance instance;

    @Test
    void bulkInsert() throws IOException {
        instance.bulkInsert();
    }
}
