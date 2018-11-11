package com.lhb.study.devSmallDemo.elasticSearch;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpHost;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Iterator;

/**
 * 首先需要安装并运行ElasticSearch，才可运行下面demo
 */
public class ElasticSearchDemo {

    public static void main(String[] args) throws IOException {
        // on startup
        RestHighLevelClient client = new RestHighLevelClient(RestClient.builder(
                new HttpHost("localhost", 9200, "http")));
        /*IndexRequest request = new IndexRequest("posts", "doc", "1");
        JSONObject json1 = new JSONObject();
        json1.put("user","jack");
        json1.put("msg","hello");
        request.source(json1,XContentType.JSON);
        System.out.println("==================request=====================");
        System.out.println(JSON.toJSONString(request));
        IndexResponse indexResponse = client.index(request,RequestOptions.DEFAULT);
        System.out.println("==================indexResponse=====================");
        System.out.println(JSON.toJSONString(indexResponse));*/

        GetRequest getRequest = new GetRequest( "posts", "doc",  "1");
        GetResponse getResponse = client.get(getRequest,RequestOptions.DEFAULT);
        System.out.println("==================getResponse=====================");
        System.out.println(JSON.toJSONString(getResponse.getSourceAsMap()));
        System.out.println(getResponse.getSourceAsMap().get("user"));


        //创建搜索请求
        SearchRequest searchRequest = new SearchRequest("posts");
        searchRequest.types("doc");
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.matchAllQuery());
        //降序
        searchSourceBuilder.sort("_id", SortOrder.DESC);
        //分页
        searchSourceBuilder.from(0);
        searchSourceBuilder.size(5);
        searchRequest.source(searchSourceBuilder);
        SearchResponse searchResponse=client.search(searchRequest,RequestOptions.DEFAULT);
        System.out.println("==================searchResponse=====================");
        System.out.println(JSON.toJSONString(searchResponse));
        System.out.println("==================Hits=====================");
//        System.out.println(JSON.toJSONString(searchResponse.getHits().getHits()));

        for(SearchHit hit:searchResponse.getHits()) {
            System.out.println(hit.getSourceAsMap().toString());
        }

            // on shutdown
        client.close();

    }

}
