package com.liuh.common.clients;

import com.liuh.common.entity.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author: liuhuan
 * @Date: 2023/7/26 17:42
 * @PackageName: com.liuh.common.clients
 * @ClassName: ProductService
 * @Description: TODO
 * @Version 1.0
 */
@FeignClient("service-product")
public interface ProductClient {

    /**
     * 查询商品信息
     * 第一个 /product：配置文件中配置的 context-path: /product
     * 第二个 /product：方法类上配置的 @RequestMapping("/product")
     * /findByPid/{pid}：方法上配置的 @GetMapping("/add/{pid}")
     *
     * @param pid 商品 ID
     * @return
     */
    @GetMapping(value = "/product/product/findByPid/{pid}")
    Product findByPid(@PathVariable("pid") Integer pid);
}
