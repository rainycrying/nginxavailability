package com.rainycrying.nginxavailability.Controllers;

import com.rainycrying.nginxavailability.Dao.Host;
import com.rainycrying.nginxavailability.Dao.Result;
import com.rainycrying.nginxavailability.Services.HostService;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@RestController
public class HostController {
    @Autowired
    private HostService hostService;

    @PostMapping(value = "/api/host/add")
    public Result Hosts_add (@RequestParam("product") String product, @RequestParam("sysname") String sysname, @RequestParam("ip") String ip, @RequestParam("op_manager") String op_manager) {
        Result result = new Result();
        Host hosts = new Host();
        Host people = hostService.selectByPersonIp(ip);
        System.out.println(hostService.selectByPersonIp(ip));
        if ((hostService.selectByPersonIp(ip)!=null) ) {
            JSONArray json = JSONArray.fromObject(people);
            result.setData(json);
            result.setMsg(302);
            return result;
        }
        System.out.println(product+sysname+ip+op_manager);
        hosts.setProduct(product);
        hosts.setSysname(sysname);
        hosts.setIp(ip);
        hosts.setOp_manager(op_manager);
        hosts.setStatus(0);
        int status_code = hostService.insertPerson(hosts);
        Host people_new = hostService.selectByPersonIp(ip);
        JSONArray json_add = JSONArray.fromObject(people_new);
        result.setData(json_add);
        result.setMsg(200);
        return result;
    }
    @RequestMapping(value = "/api/host/list/id/{id}",method = RequestMethod.GET)
    public Result Hosts_list (@PathVariable int id) {
        Result result = new Result();
        Host people = hostService.selectByPersonId(id);
        if ((people!=null) ) {
            JSONArray json_add = JSONArray.fromObject(people);
            result.setData(json_add);
            result.setMsg(200);
            return result;
        }
        result.setMsg(404);
        return result;
    }
    @PostMapping(value = "/api/host/search")
    public Result Search_Hosts (@RequestParam("ip") String ip) {
        Result result = new Result();
        System.out.println(ip);
        Host people = hostService.selectByPersonIp(ip);
        System.out.println(people);
        if ((people!=null) ) {
            JSONArray json = JSONArray.fromObject(people);
            result.setData(json);
            result.setMsg(200);
            return result;
        }
        return result;
    }
    @GetMapping("/api/host/all_host_list")
    public List<Host> getHostALL(){
        List<Host> people = hostService.selectAllHost();
        JSONArray json = JSONArray.fromObject(people);
        return json;
    }
    @PostMapping("/api/host/Disable")
    public int set_Disable_Host(@RequestParam("id") int id, @RequestParam("status") String status){
        System.out.println(id);
        System.out.println(status);
        int code_status = hostService.updateByHostId(id, status);
        return code_status;
    }

}
