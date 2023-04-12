package com.liuh.order.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liuh.common.entity.Order;
import org.springframework.stereotype.Repository;

/**
 * @PackageName: com.liuh.order.mapper
 * @FileName: OrderMapper
 * @Description:
 * @Author: Liuh
 * @Date: 2023/4/12
 */
@Repository
public interface OrderMapper extends BaseMapper<Order> {
}
