package com.liuh.gateway.filter;

import lombok.Data;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: liuhuan
 * @Date: 2023/8/5 15:23
 * @PackageName: com.liuh.gateway.filter
 * @ClassName: LogGatewayFilterFactory
 * @Description: TODO
 * @Version 1.0
 */
@Component
public class LogGatewayFilterFactory extends AbstractGatewayFilterFactory<Config> {

    public LogGatewayFilterFactory() {
        super(Config.class);
    }


    /**
     * 过滤器逻辑
     *
     * @param config
     * @return
     */
    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            if (config.isConsoleLog()) {
                System.out.println("开启 console Log ......");
            }
            if (config.isCacheLog()) {
                System.out.println("开启 cache Log ......");
            }
            return chain.filter(exchange);
        };
    }


    /**
     * 读取配置文件中的参数 赋值到配置类中
     *
     * @return
     */
    @Override
    public List<String> shortcutFieldOrder() {
        return Arrays.asList("consoleLog", "cacheLog");
    }

}

@Data
class Config {
    private boolean consoleLog;
    private boolean cacheLog;
}
