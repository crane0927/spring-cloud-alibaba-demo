package com.liuh.product.controller;


import com.alibaba.fastjson.JSON;
import com.liuh.common.entity.Product;
import com.liuh.product.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @PackageName: com.liuh.product.controller
 * @FileName: ProductController
 * @Description:
 * @Author: Liuh
 * @Date: 2023/4/12
 */
@RestController
@Slf4j
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/findByPid/{pid}")
    public Product findByPid(@PathVariable("pid") Integer pid) {
        Product product = productService.findByPid(pid);
        if (pid == 1) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // 当 id = 2 抛出运行时异常
        if (pid == 2) {
            throw new RuntimeException();
        }

        log.info("查询到商品:" + JSON.toJSONString(product));
        return product;
    }
}
