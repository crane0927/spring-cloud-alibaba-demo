package com.liuh.order.service.impl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.liuh.order.service.SentinelService;
import org.springframework.stereotype.Service;

/**
 * @Author: liuhuan
 * @Date: 2023/8/24 10:59
 * @PackageName: com.liuh.order.service.impl
 * @ClassName: SentinelServiceImpl
 * @Description: TODO
 * @Version 1.0
 */
@Service
public class SentinelServiceImpl implements SentinelService {

    /**
     * 链路测试
     *
     * @return
     */
    @SentinelResource("linkTest")
    @Override
    public String linkTest() {
        return "链路测试";
    }
}
