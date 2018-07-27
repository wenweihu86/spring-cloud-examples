package com.github.wenweihu86.order;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class OrderController {

    @Value("${key}")
    String key;

    @RequestMapping(value = "/order/create")
    public String createOrder(){
        return "new orderId=" + key;
    }
}
