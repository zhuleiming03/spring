package spring.boot.data.redis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import spring.boot.data.redis.service.FileService;

@SpringBootTest
class FileTest {

    @Test
    void setString() {
        fileService.setString("cache:id", "test");
    }

    @Test
    void getString() {
        System.out.println(fileService.getString("cache:id"));
    }

    @Autowired
    FileService fileService;
}
