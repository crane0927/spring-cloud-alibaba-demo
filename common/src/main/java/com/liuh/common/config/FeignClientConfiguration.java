package com.liuh.common.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;

/**
 * @Author: liuhuan
 * @Date: 2023/8/2 15:31
 * @PackageName: com.liuh.common.config
 * @ClassName: FeignClientConfiguration
 * @Description: TODO
 * @Version 1.0
 */
public class FeignClientConfiguration {

    @Bean
    public Logger.Level feignLevel() {
        return Logger.Level.NONE;
    }
}
