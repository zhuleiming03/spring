package spring.boot.starter;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import spring.boot.starter.instance.DocumentInstance;

import java.io.IOException;

@SpringBootTest
class DocumentTest {

    @Autowired
    DocumentInstance instance;

    @Test
    void insert() throws IOException {
        instance.insert();
    }

    @Test
    void delete() throws IOException {
        instance.delete();
    }

    @Test
    void update() throws IOException {
        instance.update();
    }

    @Test
    void select() throws IOException {
        instance.select();
    }
}
