package com.lipeng.consul.controller;

import com.lipeng.consul.config.ConsulConfigInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RefreshScope
public class TestController {
    @Value("${config.info}")
    private String configInfo;

    @Resource
    private ConsulConfigInfo consulConfigInfo;

    @RequestMapping("getConfig")
    public Object getConfig(){
      //  return configInfo;
        return consulConfigInfo;
    }
}
