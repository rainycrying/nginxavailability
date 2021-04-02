package com.rainycrying.nginxavailability.Controllers;

import org.jasig.cas.client.authentication.AttributePrincipal;
import org.jasig.cas.client.util.AbstractCasFilter;
import org.jasig.cas.client.validation.Assertion;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.jasig.cas.client.util.AssertionHolder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class IndexController {
    @RequestMapping("/")
    public String Index_html(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getSession().getAttribute("UserName")==null){
            response.sendRedirect(request.getContextPath() + "/admin/login");
            return "Admin/index";
        }
        return "Admin/index";
    }
    @RequestMapping("/user/domainreliability/historyhtml")
    public String domainreliability_html(HttpServletRequest request, HttpServletResponse response) throws IOException {
        return "Admin/Domainqps";
    }

}

