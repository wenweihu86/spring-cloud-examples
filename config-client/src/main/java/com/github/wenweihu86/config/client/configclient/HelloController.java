package com.github.wenweihu86.config.client.configclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class HelloController {

    @Value("${key}")
    String key;

    @RequestMapping(value = "/hello")
    public String hello(){
        return "Hello, " + key;
    }
}
