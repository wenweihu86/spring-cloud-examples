package com.github.wenweihu86.order;

import com.github.wenweihu86.inventory.api.InventoryApi;
import com.github.wenweihu86.order.dao.OrderInfoMapper;
import com.github.wenweihu86.order.po.OrderInfo;
import io.micrometer.core.instrument.Counter;
import io.micrometer.prometheus.PrometheusMeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.Date;

@RestController
public class OrderController {

    @Autowired
    private OrderInfoMapper orderInfoMapper;

    @Autowired
    private InventoryApi inventoryApi;

    @Autowired
    private PrometheusMeterRegistry prometheusMeterRegistry;

    private Counter counter;

    @PostConstruct
    public void init() {
        counter = prometheusMeterRegistry.counter("createOrder");
    }

    @RequestMapping(value = "/order/create")
    public String createOrder() {
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setOrderId(123L);
        orderInfo.setInventoryNum(10L);
        orderInfo.setCreateTime(new Date());
        orderInfo.setUpdateTime(new Date());
        orderInfoMapper.insertSelective(orderInfo);
        inventoryApi.subtractInventory(10);
        counter.increment();
        return "SUCCESS";
    }
}
