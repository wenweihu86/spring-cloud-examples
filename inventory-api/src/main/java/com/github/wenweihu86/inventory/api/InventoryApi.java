package com.github.wenweihu86.inventory.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "inventory-server")
public interface InventoryApi {
    @RequestMapping(value = "/inventory/subtract")
    String subtractInventory(Integer num);
}
