package com.github.wenweihu86.inventory.server;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class InventoryController {

    @Value("${key}")
    String key;

    @RequestMapping(value = "/inventory/subtract")
    public String subtractInventory(Integer num) {
        return "success, key=" + key;
    }
}
