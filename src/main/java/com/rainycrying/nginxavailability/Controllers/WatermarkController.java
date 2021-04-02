package com.rainycrying.nginxavailability.Controllers;

import org.jasig.cas.client.util.AbstractCasFilter;
import org.jasig.cas.client.util.AssertionHolder;
import org.jasig.cas.client.validation.Assertion;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@RestController
public class WatermarkController {
    private AdminController adminController;

    @Value("${web.config.cas-client-server-name}")
    private String adminAddresses;

    @GetMapping("/rest/api/user/current")
    //@ResponseBody>>>>>>将java对象转为json格式的数据。
    public String watermark_current(HttpServletRequest request) {
        Object UserName = request.getSession().getAttribute("UserName");
        String watermark_current = "{\"username\": \"" + UserName + "\"}";
        System.out.println(watermark_current);
        return watermark_current;
    }
}
