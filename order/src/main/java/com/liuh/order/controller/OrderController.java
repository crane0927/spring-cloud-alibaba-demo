package com.liuh.order.controller;

import com.alibaba.fastjson.JSON;
import com.liuh.common.entity.Order;
import com.liuh.common.entity.Product;
import com.liuh.order.service.OrderService;
import com.liuh.common.clients.ProductClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @PackageName: com.liuh.order.controller
 * @FileName: OrderController
 * @Description:
 * @Author: Liuh
 * @Date: 2023/4/12
 */
@RestController
@Slf4j
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductClient productClient;

    /**
     * 新增订单
     *
     * @param pid 商品 id
     * @return
     */
    @GetMapping("/add/{pid}")
    public Order add(@PathVariable("pid") Integer pid) {
        log.info(">> 客户下单，调用商品微服务查询商品信息");

        // 通过 Fegin 调用商品微服务
        Product product = productClient.findByPid(pid);
        log.info(">> 商品信息，查询结果：" + JSON.toJSONString(product));

        Order order = new Order();
        order.setUid(1);
        order.setUsername("测试用户");
        assert product != null;
        order.setPid(product.getPid());
        order.setPName(product.getPName());
        order.setPPrice(product.getPPrice());
        order.setNumber(1);
        orderService.save(order);
        return order;
    }
}
