package spring.boot.starter.instance;

import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;

@Component
public class IndexInstance {

    private static final String INDEX_NAME = "springboot";

    @Resource
    RestHighLevelClient restHighLevelClient;

    /**
     * 创建索引实例
     *
     * @throws IOException
     */
    public void create() throws IOException {
        // 创建索引请求
        CreateIndexRequest createIndexRequest = new CreateIndexRequest(INDEX_NAME);
        // 创建索引
        CreateIndexResponse response = restHighLevelClient.indices().
                create(createIndexRequest, RequestOptions.DEFAULT);
        System.out.printf("index【%s】create result: %s \n", INDEX_NAME, response.isAcknowledged());
    }

    /**
     * 查询索引实例
     *
     * @throws IOException
     */
    public void exist() throws IOException {
        // 创建查询索引请求
        GetIndexRequest getIndexRequest = new GetIndexRequest(INDEX_NAME);
        // 查询索引
        boolean result = restHighLevelClient.indices().
                exists(getIndexRequest, RequestOptions.DEFAULT);
        System.out.printf("index【%s】exist result: %s \n", INDEX_NAME, result);
    }

    /**
     * 删除索引实例
     *
     * @throws IOException
     */
    public void delete() throws IOException {
        // 创建删除索引请求
        DeleteIndexRequest deleteIndexRequest = new DeleteIndexRequest(INDEX_NAME);
        // 删除索引
        AcknowledgedResponse response = restHighLevelClient.indices().
                delete(deleteIndexRequest, RequestOptions.DEFAULT);
        System.out.printf("index【%s】delete result: %s \n", INDEX_NAME, response.isAcknowledged());
    }
}
