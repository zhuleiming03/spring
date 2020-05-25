package spring.boot.starter.instance;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.stereotype.Component;
import spring.boot.starter.domain.Article;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

@Component
public class BulkInstance {

    private static final String INDEX_NAME = "springboot";

    @Resource
    RestHighLevelClient restHighLevelClient;

    @Resource
    ObjectMapper objectMapper;

    public void bulkInsert() throws IOException {

        // 批量请求
        BulkRequest request = new BulkRequest();
        // 设置超时时间
        request.timeout(new TimeValue(60, TimeUnit.SECONDS));

        // 初始化实例集合
        ArrayList<Article> articles = new ArrayList<>();
        articles.add(new Article("原始战记", "陈词滥调", 2018));
        articles.add(new Article("未来天王", "陈词滥调", 2020));
        articles.add(new Article("回到过去变成猫", "陈词滥调", 2009));
        articles.add(new Article("神墓", "辰东", 2001));
        articles.add(new Article("完美世界", "辰东", 2019));

        // 构造批处理请求
        for (int i = 0; i < articles.size(); i++) {
            request.add(
                    new IndexRequest(INDEX_NAME)
                            .id("" + (i + 1))
                            .source(objectMapper
                                    .writeValueAsString(articles.get(i)), XContentType.JSON));
        }

        // 发送请求
        BulkResponse response = restHighLevelClient.bulk(request, RequestOptions.DEFAULT);

        System.out.printf("bulk insert document status: %s, result: %s (false is success) \n",
                response.status(), response.hasFailures());
    }
}
