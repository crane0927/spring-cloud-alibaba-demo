package com.liuh.gateway.predicates;

import lombok.Data;
import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @Author: liuhuan
 * @Date: 2023/8/5 10:53
 * @PackageName: com.liuh.gateway.predicates
 * @ClassName: AgeRoutePredicateFactory
 * @Description: TODO
 * @Version 1.0
 */
@Component
public class AgeRoutePredicateFactory extends AbstractRoutePredicateFactory<Config> {


    public AgeRoutePredicateFactory() {
        super(Config.class);
    }

    /**
     * 断言
     *
     * @param config
     * @return
     */
    @Override
    public Predicate<ServerWebExchange> apply(Config config) {
        return serverWebExchange -> {
            // 从 serverWebExchange 获取传入的参数
            String ageStr = serverWebExchange.getRequest().getQueryParams().getFirst("age");
            if (StringUtils.isNotEmpty(ageStr)) {
                int age = Integer.parseInt(ageStr);
                return age > config.getMinAge() && age < config.getMaxAge();
            }
            return true;
        };
    }


    /**
     * 用于从配置文件中获取参数值赋值到配置类中的属性上
     *
     * @return
     */
    @Override
    public List<String> shortcutFieldOrder() {
        List<String> strings = Arrays.asList("minAge", "maxAge");
        return Arrays.asList("minAge", "maxAge");
    }

}

@Data
class Config {
    private Integer minAge;
    private Integer maxAge;
}