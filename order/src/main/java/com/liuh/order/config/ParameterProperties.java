package com.liuh.order.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author: liuhuan
 * @Date: 2023/8/4 15:49
 * @PackageName: com.liuh.order.config
 * @ClassName: ParameterProperties
 * @Description: TODO
 * @Version 1.0
 */
@Component
@Data
@ConfigurationProperties(prefix = "parameter")
public class ParameterProperties {

    private String dateformat;

    private String name;
}
