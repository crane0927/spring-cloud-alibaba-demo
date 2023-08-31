package com.liuh.order.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.liuh.common.clients.ProductClient;
import com.liuh.order.service.SentinelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: liuhuan
 * @Date: 2023/8/24 9:54
 * @PackageName: com.liuh.order.controller
 * @ClassName: SentinelController
 * @Description: Sentinel 测试接口
 * @Version 1.0
 */
@RestController
@Slf4j
@RequestMapping("/sentinel")
public class SentinelController {

    @Autowired
    private SentinelService sentinelService;

    @GetMapping("/select")
    public String select() {
        System.out.println("select 接口调用" + sentinelService.linkTest());
        return "查询接口";
    }

    @GetMapping("/insert")
    public String insert() {
        System.out.println("insert 接口调用" + sentinelService.linkTest());
        return "新增接口";
    }

    @SentinelResource("get")
    @GetMapping("/get")
    public String get(Long id) {
        return "热点参数限流测试：" + id;
    }
}
