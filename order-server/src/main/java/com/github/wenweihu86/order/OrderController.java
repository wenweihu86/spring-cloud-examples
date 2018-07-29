package com.github.wenweihu86.order;

import com.github.wenweihu86.inventory.api.InventoryApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    private InventoryApi inventoryApi;

    @RequestMapping(value = "/order/create")
    public String createOrder() {
        return inventoryApi.subtractInventory(10);
    }
}
