package com.rainycrying.nginxavailability.JobHandler;

import com.rainycrying.nginxavailability.Controllers.DomainReliabilityHtmlController;
import com.rainycrying.nginxavailability.Dao.DomainReliability;
import com.rainycrying.nginxavailability.Dao.DomainReliabilityHours;
import com.rainycrying.nginxavailability.Dao.DomainReliabilityMailRule;
import com.rainycrying.nginxavailability.Services.DomainReliabilityMailRuleService;
import com.rainycrying.nginxavailability.Services.DomainReliabilityService;
import com.rainycrying.nginxavailability.Services.MailService;
import com.rainycrying.nginxavailability.Utils.RedisUtil;
import com.rainycrying.nginxavailability.Utils.SendEmailUtils;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.annotation.XxlJob;
import com.xxl.job.core.log.XxlJobLogger;
import net.sf.json.JSONArray;
import org.apache.http.HttpHost;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.annotation.Resource;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Component
public class SendMailDomainHandler {

    private static Logger logger = LoggerFactory.getLogger(demoJobHandler.class);
    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private DomainReliabilityMailRuleService domainReliabilityMailRuleService;

    @Autowired
    private DomainReliabilityService domainreliabilityservice;
    @Value("${spring.mail.username}")
    private String From_Mail_address;
    @Autowired
    private MailService mailService;
    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private SendEmailUtils sendEmailUtils;
    @Autowired
    private RedisTemplate redisTemplate;
    @Resource
    private RedisUtil redisUtil;

    @Autowired
    private TemplateEngine templateEngine;

    @Autowired
    private DomainReliabilityHtmlController domainReliabilityHtmlController;

    @XxlJob("SendMailDomain")
    public ReturnT<String> SendMailDomainJobHandler(String Rlue_name) throws Exception {
        SimpleDateFormat format_From_Daytime=new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar=Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY,-24);
        String From_Daytime = format_From_Daytime.format(calendar.getTime());;
        String From_Daytime_Hours=From_Daytime+"-00-23";
        XxlJobLogger.log("XXL-JOB, SendMailDomainJobHandler Start.");
        XxlJobLogger.log("XXL-JOB, Rlue_name="+Rlue_name);
        XxlJobLogger.log("XXL-JOB, From_Daytime="+From_Daytime);
        XxlJobLogger.log("XXL-JOB, From_Daytime_Hours="+From_Daytime_Hours);
        String template="Mail/DomainReliability.html";
//        String [] to={"zhangzh@zenmen.com"};
        List<DomainReliabilityMailRule> MailRuledatalist = domainReliabilityMailRuleService.selectMailRulebyName(Rlue_name);
        String to[] = MailRuledatalist.get(0).getRlue_group().split(",");
        System.out.println(MailRuledatalist.get(0).getRlue_name());
        if (MailRuledatalist.size()==1) {
            XxlJobLogger.log(MailRuledatalist.get(0).getRlue_group());
            if (redisUtil.hget(From_Daytime,Rlue_name)!=null){
            try {
                sendEmailUtils.thymeleafDomainEmail(to, Rlue_name, template);
            } catch (Exception e) {
                e.printStackTrace();
            }
            XxlJobLogger.log("domainreliabilityJobHandler at:" + Rlue_name);
            TimeUnit.SECONDS.sleep(2);
            return ReturnT.SUCCESS;}else {
                XxlJobLogger.log("Redis缓存读取失败 redisUtil.hget("+From_Daytime+","+Rlue_name+")失败="+redisUtil.hget(From_Daytime,Rlue_name));
                return ReturnT.FAIL;
            }

        }else {
            XxlJobLogger.log("MailRuledatalist-size="+MailRuledatalist.size());
            XxlJobLogger.log(MailRuledatalist.get(0).getRlue_name());
            return ReturnT.FAIL;
        }

    }


    @XxlJob("CreateMailDomain")
    public ReturnT<String> CreateMailDomainJobHandler(String Rlue_name) throws Exception {
        XxlJobLogger.log("XXL-JOB, SendMailDomainJobHandler Start.");
        Rlue_name="运维默认策略";
        SimpleDateFormat format_From_Daytime=new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar=Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY,-24);
        String From_Daytime = format_From_Daytime.format(calendar.getTime());;

        List<DomainReliabilityMailRule> MailRuledatalist_all = domainReliabilityMailRuleService.selectALLMailRuleName();
        for (int ins = 0; ins < MailRuledatalist_all.size(); ins++){
            Rlue_name=MailRuledatalist_all.get(ins).getRlue_name();
            domainReliabilityHtmlController.Set_Redis_From_Daytime(Rlue_name,From_Daytime);
            domainReliabilityHtmlController.Set_Redis_From_Daytime_Hours(Rlue_name,From_Daytime);

            JSONArray  Set_Redis_From_Daytime_json= JSONArray.fromObject(redisUtil.hget(From_Daytime, Rlue_name));
            JSONArray  Set_Redis_From_Daytime_Hours_json= JSONArray.fromObject(redisUtil.hget(From_Daytime+"-00-23", Rlue_name));
            System.out.println(Rlue_name+"JSONArray=Set_Redis_From_Daytime_json"+Set_Redis_From_Daytime_json);
            XxlJobLogger.log(Rlue_name+"JSONArray=Set_Redis_From_Daytime_json"+Set_Redis_From_Daytime_json);
            System.out.println(Rlue_name+"JSONArray=Set_Redis_From_Daytime_Hours_json"+Set_Redis_From_Daytime_Hours_json);
            XxlJobLogger.log(Rlue_name+"JSONArray=Set_Redis_From_Daytime_Hours_json"+Set_Redis_From_Daytime_Hours_json);
        }
        return ReturnT.SUCCESS;
    }

}
