package com.liuh.product.service.impl;

import com.liuh.common.entity.Product;
import com.liuh.product.mapper.ProductMapper;
import com.liuh.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @PackageName: com.liuh.product.service.impl
 * @FileName: ProductServiceImpl
 * @Description:
 * @Author: Liuh
 * @Date: 2023/4/12
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    /**
     * 通过商品 id 获取商品信息
     *
     * @param pid 商品 id
     * @return 商品信息
     */
    @Override
    public Product findByPid(Integer pid) {
        Product product = productMapper.selectById(pid);
        return product;
    }
}
