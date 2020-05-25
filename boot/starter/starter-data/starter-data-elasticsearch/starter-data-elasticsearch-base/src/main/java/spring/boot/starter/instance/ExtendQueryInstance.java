package spring.boot.starter.instance;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;

@Component
public class ExtendQueryInstance {

    private static final String INDEX_NAME = "springboot";

    @Resource
    RestHighLevelClient restHighLevelClient;

    @Resource
    ObjectMapper objectMapper;

    /**
     * 模糊查询
     *
     * @throws IOException
     */
    public void match() throws IOException {

        // 构造模糊查询条件
        QueryBuilder queryBuilder = QueryBuilders.matchQuery("author", "陈词");

        // 构造查询条件
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        sourceBuilder.query(queryBuilder);

        // 执行查询
        search(sourceBuilder);
    }

    /**
     * 精确查询
     *
     * @throws IOException
     */
    public void term() throws IOException {

        // 构造精确查询条件
        QueryBuilder queryBuilder = QueryBuilders.termQuery("title", "来");

        // 构造查询条件
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        sourceBuilder.query(queryBuilder);

        // 执行查询
        search(sourceBuilder);
    }

    private void search(SearchSourceBuilder sourceBuilder) throws IOException {

        // 构造查询请求
        SearchRequest request = new SearchRequest(INDEX_NAME);
        request.source(sourceBuilder);

        // 发送查询请求
        SearchResponse response = restHighLevelClient.search(request, RequestOptions.DEFAULT);

        // 展示查询结果
        System.out.println(objectMapper.writeValueAsString(response.getHits()));
        System.out.println("---------------------");
        for (SearchHit documentFields : response.getHits().getHits()) {
            System.out.println(documentFields.getSourceAsMap());
        }
    }
}
