package com.rainycrying.nginxavailability.Controllers;

import com.rainycrying.nginxavailability.Utils.RedisUtil;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.http.HTTPException;

import java.io.IOException;
@RestController
public class VoiceController {
    @Value("${web.config.cas-client-server-name}")
    private String adminAddresses;
    @RequestMapping(value = "/voice/callback", method = RequestMethod.POST)
    public boolean voicepost(@RequestBody JSONObject jsonObject) throws HTTPException, IOException {
        return true ;
    }

    @RequestMapping(value = "/voice/callback", method = RequestMethod.GET)
    public void userLogin(HttpServletResponse response) throws IOException {
        response.sendRedirect(adminAddresses);
    }
    private static int ExpireTime = 60;   // redis中存储的过期时间60s
    @Resource
    private RedisUtil redisUtil;

    @Autowired
    private RedisTemplate redisTemplate;



}