package com.liuh.common.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;


/**
 * @PackageName: com.liuh.common.entity
 * @FileName: Order
 * @Description: 订单
 * @Author: Liuh
 * @Date: 2023/4/12
 */
@Data
@TableName("shop_order")
public class Order {
    /**
     * 订单 id
     */
    @TableId(type = IdType.AUTO)
    private Long oid;
    /**
     * 用户 id
     */
    @TableField("uid")
    private Integer uid;
    /**
     * 用户名
     */
    @TableField("username")
    private String username;

    /**
     * 商品 id
     */
    @TableField("pid")
    private Integer pid;
    /**
     * 商品名称
     */
    @TableField("p_name")
    private String pName;

    /**
     * 商品单价
     */
    @TableField("p_price")
    private Double pPrice;
    /**
     * 购买数量
     */
    @TableField("number")
    private Integer number;
}
