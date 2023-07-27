package com.liuh.order.controller;

import com.alibaba.fastjson.JSON;
import com.liuh.common.entity.Order;
import com.liuh.common.entity.Product;
import com.liuh.order.service.OrderService;
import com.liuh.order.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Random;

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
    private ProductService productService;

//    @Autowired
//    private RestTemplate restTemplate;
//
//    @Autowired
//    private DiscoveryClient discoveryClient;

    /**
     * 新增订单
     *
     * @param pid 商品 id
     * @return
     */
    @GetMapping("/add/{pid}")
    public Order add(@PathVariable("pid") Integer pid) {
        log.info(">>客户下单，调用商品微服务查询商品信息");

        // 从 Nacos 中获取服务地址列表
//        List<ServiceInstance> instances = discoveryClient.getInstances("service-product");
        // 自定义规则实现随机挑选服务
//        int index = new Random().nextInt(instances.size());
//        ServiceInstance serviceInstance = instances.get(index);
//        String url = serviceInstance.getHost() + ":" + serviceInstance.getPort();

        // 直接使用微服务名字， 从 Nacos 中获取服务地址
//        String url = "service-product";
//        log.info(url);
        // 通过 restTemplate 调用商品微服务
//        Product product = restTemplate.getForObject("http://" + url + "/product/product/findByPid/" + pid, Product.class);
        // 通过 Fegin 调用商品微服务
        Product product = productService.findByPid(pid);
        log.info(">>商品信息，查询结果：" + JSON.toJSONString(product));

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
