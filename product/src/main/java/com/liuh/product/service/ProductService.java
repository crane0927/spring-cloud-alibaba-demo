package com.liuh.product.service;

import com.liuh.common.entity.Product;

/**
 * @PackageName: com.liuh.product.service
 * @FileName: ProductService
 * @Description:
 * @Author: Liuh
 * @Date: 2023/4/12
 */
public interface ProductService {

    /**
     * 通过商品 id 获取商品信息
     *
     * @param pid 商品 id
     * @return 商品信息
     */
    public Product findByPid(Integer pid);
}
