package com.rainycrying.nginxavailability.Controllers;

import com.rainycrying.nginxavailability.Dao.DomainReliability;
import com.rainycrying.nginxavailability.Dao.Host;
import com.rainycrying.nginxavailability.Services.DomainReliabilityService;
import com.rainycrying.nginxavailability.Services.HostService;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/html")
public class HtmlController {
    @Autowired
    private HostService hostService;
    @Autowired
    private DomainReliabilityService domainreliabilityservice;

    @RequestMapping("/All_Host")
    public String get_All_Host(Model model) {
        List<Host> hosts = new ArrayList<>();
        List<Host> people = hostService.selectAllHost();
        JSONArray json = JSONArray.fromObject(people);
        model.addAttribute("tables",json);
        return "hostlist";
    }

    @RequestMapping("/Disable_Host")
    public String get_Disable_Host(Model model) {
        List<Host> hosts = new ArrayList<>();
        List<Host> people = hostService.selectAllDisableHost();
        JSONArray json = JSONArray.fromObject(people);
        model.addAttribute("tables",json);
        return "hostlist";
    }
    @RequestMapping("/Enable_Host")
    public String get_Enable_Host(Model model) {
        List<Host> hosts = new ArrayList<>();
        List<Host> people = hostService.selectAllEnableHost();
        JSONArray json = JSONArray.fromObject(people);
        model.addAttribute("tables",json);
        System.out.println("Enable_Host+model"+model);
        return "hostlist";
    }
    @RequestMapping("/test")
    public String test(Model model) {
        List<Host> hosts = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Host host = new Host();
            host.setId(1);
            host.setProduct("测试");
            host.setSysname("ilxshow-ilxshow-ilxtest-9.wxxdc");
            host.setIp("127.0.0.1");
            host.setOp_manager("zhangzh@zenmen.com");
            host.setStatus(0);
            hosts.add(host);
        }
        System.out.println(hosts);
        List<Host> people = hostService.selectAllEnableHost();
        JSONArray json = JSONArray.fromObject(people);
        //        model.addAttribute("tables",hosts);
        model.addAttribute("tables",json);
        return "hostlist";
    }


    @RequestMapping("/sendmail/html")
    public String sendmail_Get_Domail_Html(Model model) {
        List<Host> hosts = new ArrayList<>();
        List<DomainReliability> people = domainreliabilityservice.select_ALL_1000(100);
//        for (int i = 0; i < 10; i++) {
//            DomainReliability domainReliability = new DomainReliability();
//            domainReliability.setEs_index("ngpool");
//            domainReliability.setId(i);
//            domainReliability.setReliability((float) i);
//            domainReliability.setTotal_Throughput(i);
//            hosts.add(domainReliability);
//        }
        JSONArray json = JSONArray.fromObject(people.get(0));
        System.out.println(json.get(0));
        model.addAttribute("tables",people);
        System.out.println("Enable_Host+model"+model);
//        System.out.println(hosts);
//        model.addAttribute("tables",hosts);
//        System.out.println("model+"+model);
        return "Admin/DomainReliability";
    }
}