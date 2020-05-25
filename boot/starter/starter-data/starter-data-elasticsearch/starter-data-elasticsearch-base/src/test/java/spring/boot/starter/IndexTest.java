package spring.boot.starter;

import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import spring.boot.starter.instance.IndexInstance;

import java.io.IOException;

@SpringBootTest
class IndexTest {

    @Autowired
    IndexInstance instance;

    @Test
    void create() throws IOException {
        instance.create();
    }

    @Test
    void exist() throws IOException {
        instance.exist();
    }

    @Test
    void delete() throws IOException {
        instance.delete();
    }
}
