package com.liuh.common.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @PackageName: com.liuh.common.entity
 * @FileName: Product
 * @Description: 商品
 * @Author: Liuh
 * @Date: 2023/4/12
 */
@Data
@TableName("shop_product")
public class Product {

    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Integer pid;
    /**
     * 商品名称
     */
    @TableField("p_name")
    private String pName;
    /**
     * 商品价格
     */
    @TableField("p_price")
    private Double pPrice;
    /**
     * 库存
     */
    @TableField("stock")
    private Integer stock;
}
