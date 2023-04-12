package com.liuh.product.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liuh.common.entity.Product;
import org.springframework.stereotype.Repository;

/**
 * @PackageName: com.liuh.product.mapper
 * @FileName: ProductMapper
 * @Description:
 * @Author: Liuh
 * @Date: 2023/4/12
 */
@Repository
public interface ProductMapper extends BaseMapper<Product> {
}
