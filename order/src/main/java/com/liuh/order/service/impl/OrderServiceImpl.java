package com.liuh.order.service.impl;

import com.liuh.common.entity.Order;
import com.liuh.order.mapper.OrderMapper;
import com.liuh.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @PackageName: com.liuh.order.service.impl
 * @FileName: OrderServiceImpl
 * @Description:
 * @Author: Liuh
 * @Date: 2023/4/12
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    /**
     * 保存订单
     *
     * @param order 订单
     */
    @Override
    public void save(Order order) {
        orderMapper.insert(order);
    }
}
