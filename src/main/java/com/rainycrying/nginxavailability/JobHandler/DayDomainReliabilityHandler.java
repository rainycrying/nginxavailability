package com.rainycrying.nginxavailability.JobHandler;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.annotation.XxlJob;
import com.xxl.job.core.log.XxlJobLogger;
import org.apache.http.HttpHost;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.core.CountRequest;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class DayDomainReliabilityHandler {
    private static Logger logger = LoggerFactory.getLogger(demoJobHandler.class);
    private RestHighLevelClient restHighLevelClient;

    @XxlJob("day_domainreliability")
    public ReturnT<String> day_domainreliabilityJobHandler(String param) throws Exception {
        SearchRequest searchRequest = new SearchRequest();
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.matchAllQuery());
        searchRequest.source(searchSourceBuilder);


        XxlJobLogger.log("XXL-JOB, day_domainreliabilityJobHandler Start.");
        System.out.println(param);
        XxlJobLogger.log("domainreliabilityJobHandler at:" + param);
        TimeUnit.SECONDS.sleep(2);
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost("localhost", 9200, "http"),
                        new HttpHost("localhost", 9201, "http")));
        client.close();

        return ReturnT.SUCCESS;
    }
}
