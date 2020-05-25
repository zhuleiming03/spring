package spring.boot.starter.instance;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.stereotype.Component;
import spring.boot.starter.domain.Article;

import javax.annotation.Resource;
import java.io.IOException;

@Component
public class DocumentInstance {

    private static final String INDEX_NAME = "springboot";

    @Resource
    RestHighLevelClient restHighLevelClient;

    @Resource
    ObjectMapper objectMapper;

    /**
     * 创建文档实例
     *
     * @throws IOException
     */
    public void insert() throws IOException {

        // 初始化实例
        Article article = new Article("未来天王", "陈词滥调", 2012);

        // 创建文档请求
        IndexRequest request = new IndexRequest(INDEX_NAME);
        request.id("1");
        request.source(objectMapper.writeValueAsString(article), XContentType.JSON);

        // 发送请求
        IndexResponse response = restHighLevelClient.index(request, RequestOptions.DEFAULT);

        System.out.printf("create document result: %s, \n详细参数： %s \n",
                response.status(), response.toString());
    }

    /**
     * 删除文档请求
     *
     * @throws IOException
     */
    public void delete() throws IOException {

        // 删除文档请求
        DeleteRequest request = new DeleteRequest(INDEX_NAME, "1");

        // 发送请求
        DeleteResponse response = restHighLevelClient.delete(request, RequestOptions.DEFAULT);

        System.out.printf("delete document result: %s, \n详细参数： %s \n",
                response.status(), response.toString());
    }

    /**
     * 更新文档请求
     *
     * @throws IOException
     */
    public void update() throws IOException {

        // 更新文档请求
        UpdateRequest request = new UpdateRequest(INDEX_NAME, "1");

        // 更新实例
        Article article = new Article("回到过去变成猫", "陈词滥调", 2012);
        request.doc(objectMapper.writeValueAsString(article), XContentType.JSON);

        // 发送请求
        UpdateResponse response = restHighLevelClient.update(request, RequestOptions.DEFAULT);

        System.out.printf("update document result: %s, \n详细参数： %s \n",
                response.status(), response.toString());

    }

    /**
     * 查询文档实例
     *
     * @throws IOException
     */
    public void select() throws IOException {

        // 查询文档请求
        GetRequest request = new GetRequest(INDEX_NAME, "1");

        // 发送请求
        GetResponse response = restHighLevelClient.get(request, RequestOptions.DEFAULT);

        System.out.printf("query document result: %s, \n详细参数： %s \n",
                response.getSourceAsString(), response.toString());

    }
}
