package com.rainycrying.nginxavailability.Controllers;

import com.rainycrying.nginxavailability.Dao.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class JsonController {

    @GetMapping("/api/all_host")
    //@ResponseBody>>>>>>将java对象转为json格式的数据。
    public List<Host> getHostALL(){
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
        return hosts;
    }
}
