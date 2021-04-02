package com.rainycrying.nginxavailability.Controllers;

import com.rainycrying.nginxavailability.Dao.DomainReliability;
import com.rainycrying.nginxavailability.Dao.Host;
import com.rainycrying.nginxavailability.Services.DomainReliabilityMailRuleService;
import com.rainycrying.nginxavailability.Services.DomainReliabilityService;
import com.rainycrying.nginxavailability.Services.MailService;
import com.rainycrying.nginxavailability.Utils.RedisUtil;
import com.rainycrying.nginxavailability.Utils.SendEmailUtils;
import net.minidev.json.JSONObject;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.http.HTTPException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@RestController
public class SendMailController {

    @Autowired
    private MailService mailService;
    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private SendEmailUtils sendEmailUtils;
    @Autowired
    private DomainReliabilityService domainreliabilityservice;

    @Autowired
    private DomainReliabilityMailRuleService domainReliabilityMailRuleService;


    @Autowired
    private RedisTemplate redisTemplate;
    @Resource
    private RedisUtil redisUtil;

    @RequestMapping(value = "/api/sendmail/test", method = RequestMethod.GET)
    public void sendmail_Get(HttpServletResponse response) throws IOException {
//        Object emailParam = new Object();
//        String Rlue_name="视频号";
//        String [] to={"zhangzh@zenmen.com"};
//        //String from, String[] to, String subject, Object emailParam, String template, String imagePath
//        try {
//            sendEmailUtils.thymeleafDomainEmail(to ,  Rlue_name, "Mail/DomainReliability.html");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }





}
