package com.rainycrying.nginxavailability.Controllers;

import com.rainycrying.nginxavailability.Dao.*;
import com.rainycrying.nginxavailability.Services.DomainReliabilityMailRuleService;
import com.rainycrying.nginxavailability.Services.DomainReliabilityService;
import com.rainycrying.nginxavailability.Utils.RedisUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.jasig.cas.client.authentication.AttributePrincipal;
import org.jasig.cas.client.util.AssertionHolder;
import org.jasig.cas.client.validation.Assertion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private DomainReliabilityMailRuleService domainReliabilityMailRuleService;
    @Autowired
    private DomainReliabilityService domainreliabilityservice;
    @Autowired
    private RedisTemplate redisTemplate;
    @Resource
    private RedisUtil redisUtil;

    @Value("${web.config.cas-client-server-name}")
    private String SSO_Domain_Local;


    @RequestMapping("/sendmail/rlue_all_name")
    public String Rlue_name(Model model, HttpServletRequest request) {
        Set_SSO_Session(request);
        String Rlue_name;
        List<DomainReliabilityHours> Rlue_name_list = new ArrayList<>();

        List<DomainReliabilityMailRule> MailRuledatalist_all = domainReliabilityMailRuleService.selectALLMailRuleName();
        for (int ins = 0; ins < MailRuledatalist_all.size(); ins++){
            Rlue_name=MailRuledatalist_all.get(ins).getRlue_name();
            System.out.println(Rlue_name);
            List<DomainReliabilityMailRule> MailRuledatalist = domainReliabilityMailRuleService.selectMailRulebyName(Rlue_name);
        }

        JSONArray MailRuledatalist_all_json = JSONArray.fromObject(MailRuledatalist_all);
        System.out.println("JSONArray=MailRuledatalist_all_json"+MailRuledatalist_all_json);
        model.addAttribute("rlue_name",MailRuledatalist_all);
//        return "Admin/Rluename";
        return "Admin/Domainreliabilityrule";
    }


    @RequestMapping(value = "/domainreliability/historyhtml")
    public String Domain_History_html(Model model, HttpServletRequest request) {
        Set_SSO_Session(request);
        SimpleDateFormat format_From_Daytime=new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar=Calendar.getInstance();
        calendar.add(Calendar.WEEK_OF_MONTH,1);
        String SEndTime = format_From_Daytime.format(calendar.getTime());;
        calendar.add(Calendar.WEEK_OF_MONTH,-2);
        String SStartTime = format_From_Daytime.format(calendar.getTime());;
        String Domain_Name ="vbs.lsttapppro.com";
        String SFrom_Daytime_Type = "From_Hours";
        if (request.getParameter("Domain_Name")!=null){
            Domain_Name =request.getParameter("Domain_Name");
        }
        if (request.getParameter("SFrom_Daytime_Type")!=null){
            SFrom_Daytime_Type = request.getParameter("SFrom_Daytime_Type");
        }
        if ((request.getParameter("StartTime")!=null) && (request.getParameter("EndTime")!=null)){
            SStartTime= request.getParameter("StartTime");
            SEndTime=request.getParameter("EndTime");
        }
        List<DomainHistry> mysql_data = domainreliabilityservice.selectDomainHistryByDomainName(Domain_Name, SFrom_Daytime_Type, SStartTime, SEndTime);
        int mysql_data_size = mysql_data.size();
        String [] data_piename = new String[mysql_data_size];
        int []  data_pieall = new int[mysql_data_size];
        int []  data_pie5xx = new int[mysql_data_size];
        int []  data_pie4xx = new int[mysql_data_size];
        int []  data_pie3xx = new int[mysql_data_size];
        int []  data_pie2xx = new int[mysql_data_size];
        for (int ins = 0; ins < mysql_data.size(); ins++){
            data_piename[ins]=mysql_data.get(ins).getCreateTime().toString();
            data_pie5xx[ins]=mysql_data.get(ins).getCode_status_5xx();
            data_pie4xx[ins]=mysql_data.get(ins).getCode_status_4xx();
            data_pie3xx[ins]=mysql_data.get(ins).getCode_status_3xx();
            data_pie2xx[ins]=mysql_data.get(ins).getCode_status_2xx();
            data_pieall[ins]=mysql_data.get(ins).getTotal_Throughput();
        }
            System.out.println(data_piename);
            System.out.println(data_pieall);
            System.out.println(data_pie5xx);
        System.out.println(data_pie4xx);
        System.out.println(data_pie3xx);
        System.out.println(data_pie2xx);
        model.addAttribute("data_xAxis",data_piename);
        model.addAttribute("data_series_all",data_pieall);
        model.addAttribute("data_series_5XX",data_pie5xx);
        model.addAttribute("data_series_4XX",data_pie4xx);
        model.addAttribute("data_series_3XX",data_pie3xx);
        model.addAttribute("data_series_2XX",data_pie2xx);
        model.addAttribute("Domain_Name",Domain_Name);
        model.addAttribute("date_begin",SStartTime);
        model.addAttribute("date_end",SEndTime);
        model.addAttribute("TimeType",SFrom_Daytime_Type);
        if (redisUtil.get("DomainSearchTips")==null){
        List<DomainTip> Domain_All_sql = domainreliabilityservice.selectALLDomainTip();
        System.out.println(Domain_All_sql);
        redisUtil.set("DomainSearchTips", Domain_All_sql);
        }else {
        model.addAttribute("DomainSearchTips",redisUtil.get("DomainSearchTips"));
        }
//        return "Admin/DomainHistry";
        return "Admin/Domainqps";
    }


    @RequestMapping(value = "/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().invalidate();
        try {
            response.sendRedirect("https://sso.zenmen.com/cas/logout?service=" + SSO_Domain_Local + "/");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @RequestMapping("/login")
    public String SSO_Login(HttpServletRequest request, HttpServletResponse response) {

        if (request.getSession().getAttribute("UserName")==null){
            Set_SSO_Session(request);
            return "index";
        }else {
            return "index";
        }
    }

    public String Set_SSO_Session(HttpServletRequest request){
        Assertion assertion = AssertionHolder.getAssertion();
        AttributePrincipal principal = assertion.getPrincipal();
        if (request.getSession().getAttribute("zxUserDtoList")==null){
            Map<String, Object> attributes = principal.getAttributes();
            request.getSession().setAttribute("UserName", principal.getName());
            request.getSession().setAttribute("UserName_depName", attributes.get("depName"));
            request.getSession().setAttribute("UserName_cn", attributes.get("name"));
            request.getSession().setAttribute("UserName_email", attributes.get("email"));
            String usermess = attributes.get("zxUserDtoList").toString();
            JSONObject json = JSONObject.fromObject(usermess);
            System.out.println(json.get("avatarSmall"));
            request.getSession().setAttribute("UserzxUseravatarSmall", JSONObject.fromObject(attributes.get("zxUserDtoList").toString()).get("avatarSmall"));
            request.getSession().setAttribute("UserzxUseruid", JSONObject.fromObject(attributes.get("zxUserDtoList").toString()).get("uid"));
            request.getSession().setAttribute("UserzxUseravatar", JSONObject.fromObject(attributes.get("zxUserDtoList").toString()).get("avatar"));


            System.out.println(attributes);
            return "index";
        }else {
            return "index";
        }
    }

}
