package com.rainycrying.nginxavailability.Controllers;

import com.rainycrying.nginxavailability.Dao.Echarts;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/Echarts/")
public class EchartsController {
    @RequestMapping("/api/echarts_test_data.json")
    public Object EchartsData(Model model) {
        String request = "{" +
                "\"username\": \"Admin\"," +
                "\"ip\": \"58.215.108.75\","+
                "\"userKey\": \"95398c5dfe42c7665a10bb3f223fa7fe\""+
                "}";
        String request1 = "{ \"data_pie\" : [{\"value\":235, \"name\":\"视频广告\"},{\"value\":274, \"name\":\"联盟广告\"},{\"value\":310, \"name\":\"邮件营销\"},{\"value\":335, \"name\":\"直接访问\"},{\"value\":400, \"name\":\"搜索引擎\"}]}";
        System.out.println(request1);
        model.addAttribute("data_pie",request1);
        return request1;
    }


    @RequestMapping("/api/domain/echarts_test_data.json")
    public Object domainEchartsData(Model model) {
        String request = "{ \"data_pie\" : [{\"value\":235, \"name\":\"视频广告\"},{\"value\":274, \"name\":\"联盟广告\"},{\"value\":310, \"name\":\"邮件营销\"},{\"value\":335, \"name\":\"直接访问\"},{\"value\":400, \"name\":\"搜索引擎\"}]}";
        return request;
    }
}
