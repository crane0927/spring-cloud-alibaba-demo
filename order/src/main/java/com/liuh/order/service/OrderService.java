package com.liuh.order.service;

import com.liuh.common.entity.Order;

/**
 * @PackageName: com.liuh.order.service
 * @FileName: OrderService
 * @Description:
 * @Author: Liuh
 * @Date: 2023/4/12
 */
public interface OrderService {

    /**
     * 保存订单
     *
     * @param order 订单
     */
    void save(Order order);
}
