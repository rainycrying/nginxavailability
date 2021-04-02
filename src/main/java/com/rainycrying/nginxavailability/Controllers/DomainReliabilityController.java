package com.rainycrying.nginxavailability.Controllers;

import com.rainycrying.nginxavailability.Dao.DomainReliability;
import com.rainycrying.nginxavailability.Dao.Result;
import com.rainycrying.nginxavailability.Services.DomainReliabilityService;
import com.rainycrying.nginxavailability.Utils.RedisUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.support.collections.DefaultRedisList;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
public class DomainReliabilityController {
    @Autowired
    private DomainReliabilityService domainreliabilityservice;

    @Autowired
    private RedisTemplate redisTemplate;
    @Resource
    private RedisUtil redisUtil;

    @RequestMapping(value = "/api/domainreliability/list/Es_index/{ES_index}",method = RequestMethod.GET)
    public List<DomainReliability> DomainReliability_list (@PathVariable String ES_index) {
        System.out.println(ES_index);
        Result result = new Result();
        List<DomainReliability> people = domainreliabilityservice.selectByPersones_index(ES_index);
        System.out.println(people);
        return people;
    }


    @RequestMapping(value = "/api/domainreliability/search")
    public Result Search_DomainReliability (@RequestBody JSONObject params) {
        Result result = new Result();
        DomainReliability domainReliability = new DomainReliability();
        String ES_index = (String) params.get("ES_index");
        String Domain_Name = (String) params.get("Domain_Name");
        String From_Hours = (String) params.get("From_Hours");
        String From_Daytime = (String) params.get("From_Daytime");
        String In_Domain = (String) params.get("In_Domain");
        String Note_in_Domain = (String) params.get("Note_in_Domain");

        if ((ES_index =="") && (Domain_Name=="") && (From_Hours=="") && (From_Daytime=="") && (In_Domain=="") && (Note_in_Domain=="") ) {
            List<DomainReliability> people = domainreliabilityservice.select_ALL_1000(1000);
            System.out.println(people);
            JSONArray json_people = JSONArray.fromObject(people);
            result.setData(json_people);
            result.setMsg(200);
            System.out.println(result);
            return result;
        }else if((ES_index !="") && (Domain_Name=="") && (From_Hours=="") && (From_Daytime=="") && (In_Domain=="") && (Note_in_Domain=="")){
            List<DomainReliability> people = domainreliabilityservice.selectBy_Daytime_type1(ES_index);
            System.out.println(people);
            JSONArray json_people = JSONArray.fromObject(people);
            result.setData(json_people);
            result.setMsg(200);
            System.out.println(result);
            return result;
        }else if((ES_index !="") && (Domain_Name!="") && (From_Hours=="") && (From_Daytime=="") && (In_Domain=="") && (Note_in_Domain=="")){
            System.out.println(ES_index+Domain_Name);
            List<DomainReliability> people = domainreliabilityservice.selectBy_Daytime_type2(ES_index,Domain_Name,From_Hours,From_Daytime);
            System.out.println(people);
            JSONArray json_people = JSONArray.fromObject(people);
            result.setData(json_people);
            result.setMsg(200);
            System.out.println(result);
            return result;
        }else if((ES_index !="") && (Domain_Name=="") && (From_Hours=="") && (From_Daytime =="") && (In_Domain !="") && (Note_in_Domain =="")){
            String In_Domain_all = "\""+In_Domain.replace(",", "\",\"")+"\"";
            List<DomainReliability> people = domainreliabilityservice.selectBy_Daytime_type3(ES_index,In_Domain_all);
            System.out.println(people);
            JSONArray json_people = JSONArray.fromObject(people);
            result.setData(json_people);
            result.setMsg(200);
            System.out.println(result);
            return result;
        }else if((ES_index !="") && (Domain_Name=="") && (From_Hours=="") && (From_Daytime =="") && (In_Domain =="") && (Note_in_Domain !="")){
            String Note_in_Domain_all = "\""+Note_in_Domain.replace(",", "\",\"")+"\"";
            List<DomainReliability> people = domainreliabilityservice.selectBy_Daytime_type4(ES_index,Note_in_Domain_all);

            System.out.println(people);
            JSONArray json_people = JSONArray.fromObject(people);
            result.setData(json_people);
            result.setMsg(200);
            System.out.println(result);
            return result;
        }
        JSONArray json = JSONArray.fromObject(params);
        result.setData(json);
        result.setMsg(404);
        System.out.println(result);
        return result;
    }

    @PostMapping("/api/domain/history")
    @ResponseBody
    public String add(String DomainName, String TimeType, String date_begin, String date_end, HttpServletRequest request, HttpServletResponse response) throws IOException {
        String str = "返回值是"+DomainName+date_begin+TimeType+date_end;
        System.out.println("返回值是"+DomainName+date_begin+TimeType+date_end);
        response.sendRedirect("http://"+request.getServerName()+"/admin/domainreliability/historyhtml?StartTime="+date_begin+"&EndTime="+date_end+"&Domain_Name="+DomainName+"&SFrom_Daytime_Type="+TimeType);

        return str;
    }

    @PostMapping("/api/domain/ALL")
    @ResponseBody
    public  String domainList() {
        String str="";
        redisUtil.hset("domain","1","1");
        return str;
    }

}
