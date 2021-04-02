package com.rainycrying.nginxavailability.Controllers;

import com.rainycrying.nginxavailability.Dao.*;
import com.rainycrying.nginxavailability.Services.*;
import com.rainycrying.nginxavailability.Utils.RedisUtil;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/domainreliability")
public class DomainReliabilityHtmlController {
    @Autowired
    private DomainReliabilityService domainreliabilityservice;
    @Autowired
    private DomainReliabilityMailRuleService domainReliabilityMailRuleService;

    @Autowired
    private DomainReliabilityHtmlController domainReliabilityHtmlController;

    @Autowired
    private RedisTemplate redisTemplate;
    @Resource
    private RedisUtil redisUtil;
    @RequestMapping("/html")
    public String sendmail_Get_Domail_Html(Model model, HttpServletRequest request) {
        SimpleDateFormat format_From_Daytime=new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar=Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY,-24);
        String From_Daytime = format_From_Daytime.format(calendar.getTime());;
        System.out.println(request.getParameter("Rlue_name"));
        String Rlue_name="运维默认策略";
        if (request.getParameter("Rlue_name")!=null){
            Rlue_name =request.getParameter("Rlue_name");
        }
        if (request.getParameter("From_Daytime")!=null){
            From_Daytime=request.getParameter("From_Daytime");
        }
        System.out.println(Rlue_name+From_Daytime);
        model.addAttribute("Rlue_name",Rlue_name);
        model.addAttribute("From_Daytime",From_Daytime);
        System.out.println("redisUtil.hget"+redisUtil.hget(From_Daytime,Rlue_name));
        System.out.println("redisUtil.hget"+redisUtil.hget(From_Daytime+"Hours",Rlue_name));

        if (redisUtil.hget(From_Daytime,Rlue_name)==null) {
            domainReliabilityHtmlController.Set_Redis_From_Daytime(Rlue_name,From_Daytime);
            System.out.println("redisUtil.hset+Day页面缓存" + redisUtil.hget(From_Daytime, Rlue_name));
            model.addAttribute("day_tables", redisUtil.hget(From_Daytime, Rlue_name));
            model.addAttribute("HtmlCache","HtmlCache");
        }else {
            System.out.println("redisUtil.hset+Day页面缓存" + redisUtil.hget(From_Daytime, Rlue_name));
            model.addAttribute("day_tables", redisUtil.hget(From_Daytime, Rlue_name));
            model.addAttribute("HtmlCache","HtmlCache");
        }
        String From_Daytime_Hours=From_Daytime+"-00-23";
        System.out.println("From_Daytime_Hours="+From_Daytime_Hours);
        if (redisUtil.hget(From_Daytime_Hours,Rlue_name)==null){
            domainReliabilityHtmlController.Set_Redis_From_Daytime_Hours(Rlue_name,From_Daytime);
            model.addAttribute("Hours_tables", redisUtil.hget(From_Daytime_Hours, Rlue_name));
            System.out.println("redisUtil.hset+Hours页面缓存="+From_Daytime_Hours + redisUtil.hget(From_Daytime_Hours, Rlue_name));
            model.addAttribute("HoursHtmlCache","HoursHtmlCache");
        }else {
            System.out.println("redisUtil.hset+Hours页面缓存="+From_Daytime_Hours + redisUtil.hget(From_Daytime_Hours, Rlue_name));
            model.addAttribute("Hours_tables", redisUtil.hget(From_Daytime_Hours, Rlue_name));
            model.addAttribute("HoursHtmlCache","HoursHtmlCache");
        }
//        return "Admin/AdminDomainReliability";
        return "Admin/Domainreliability";
    }

    public void Set_Redis_From_Daytime_Hours (String Rlue_name,String From_Daytime){
        String From_Daytime_Hours=From_Daytime+"-00-23";
        System.out.println("From_Daytime_Hours="+From_Daytime_Hours);
        try {
            List<DomainReliabilityMailRule> MailRuledatalist_Hours = domainReliabilityMailRuleService.selectMailRulebyName(Rlue_name);
            DomainReliabilityMailRule MailRuledata_Hour = MailRuledatalist_Hours.get(0);
            if (MailRuledata_Hour.getRlue_domain_name() != null) {
                List<DomainReliability> people_Hour = domainreliabilityservice.selectHoursByPersonRlueName(Rlue_name, From_Daytime);
                for (int i = 0; i < people_Hour.size(); i++) {
                    redisUtil.hset(people_Hour.get(i).getFrom_Hours(),people_Hour.get(i).getEs_index()+"-"+people_Hour.get(i).getDomain_Name(),people_Hour.get(i).getTotal_Throughput());
                }
                List<DomainReliabilityHours> Hour_hosts = new ArrayList<>();
                List<DomainReliability>   Domain_All = (List<DomainReliability>) redisUtil.hget(From_Daytime, Rlue_name);
                for (int i=0 ;i< Domain_All.size();i++){
                    DomainReliabilityHours domainReliabilityHours=new DomainReliabilityHours();
                    String Redis_Domain=Domain_All.get(i).getEs_index()+"-"+Domain_All.get(i).getDomain_Name();
                    System.out.println(Redis_Domain);
                    domainReliabilityHours.setDomain_Name(Domain_All.get(i).getDomain_Name());
                    String[] Hours_redis = {"00", "01", "02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23"};
                    for (String Hours_one : Hours_redis) {
                        System.out.println("当前小时="+Hours_one); /* 依次输出“1”、“2”、“3”、“4” */
                        domainReliabilityHours.Set_All_ThroughputHours(Hours_one,redisUtil.hget(From_Daytime+"-"+Hours_one,Redis_Domain));
                    }
                    System.out.println(domainReliabilityHours.getTotal_23Throughput());
                    Hour_hosts.add(domainReliabilityHours);
                }
                System.out.println(Hour_hosts);
                JSONArray hosts_json = JSONArray.fromObject(Hour_hosts);
                System.out.println("JSONArray=hosts_json"+hosts_json);
                System.out.println("redisUtil.hset-Hours"+From_Daytime_Hours + redisUtil.hset(From_Daytime_Hours, Rlue_name, Hour_hosts,86400));
                System.out.println("redisUtil.hset Hours Success return+"+redisUtil.hset(From_Daytime_Hours, Rlue_name, Hour_hosts,86400));
            }
        }catch (Exception e) {
            System.out.println(e);
        }
    }
    public void Set_Redis_From_Daytime (String Rlue_name, String From_Daytime){
        try {
            List<DomainReliabilityMailRule> MailRuledatalist = domainReliabilityMailRuleService.selectMailRulebyName(Rlue_name);
            System.out.println(MailRuledatalist.get(0).getRlue_name());
            DomainReliabilityMailRule MailRuledata = MailRuledatalist.get(0);
            if (MailRuledata.getRlue_domain_name() != null) {
                List<DomainReliability> people = domainreliabilityservice.selectByPersonRlueName(MailRuledatalist.get(0).getRlue_name(), From_Daytime);
                System.out.println("redisUtil.hset" + redisUtil.hset(From_Daytime, Rlue_name, people,186400));
                System.out.println("redisUtil.hset Success return+"+people);
//                    return "Mail/DomainReliability";
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
