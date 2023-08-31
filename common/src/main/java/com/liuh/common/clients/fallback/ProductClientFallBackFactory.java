package com.liuh.common.clients.fallback;

import com.liuh.common.clients.ProductClient;
import com.liuh.common.entity.Product;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @Author: liuhuan
 * @Date: 2023/8/28 9:12
 * @PackageName: com.liuh.common.clients.fallback
 * @ClassName: ProductClientFallBackFactory
 * @Description: TODO
 * @Version 1.0
 */
@Slf4j
@Component
public class ProductClientFallBackFactory implements FallbackFactory<ProductClient> {

    /**
     * 创建 ProductClient 接口实现类，实现其中的方法，编写失败降级的处理逻辑
     */
    @Override
    public ProductClient create(Throwable cause) {
        return p -> {
            log.error("service-product 服务调用异常");
            return new Product();
        };
    }
}
