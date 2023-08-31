package com.liuh.order.parser;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.RequestOriginParser;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: liuhuan
 * @Date: 2023/8/31 9:08
 * @PackageName: com.liuh.order.parser
 * @ClassName: HeaderOriginParser
 * @Description: TODO
 * @Version 1.0
 */
@Slf4j
@Component
public class HeaderOriginParser implements RequestOriginParser {

    /**
     * 当请求头包含 origin 参数 返回该参数 否则返回 null
     *
     * @param httpServletRequest
     * @return
     */
    @Override
    public String parseOrigin(HttpServletRequest httpServletRequest) {
        String origin = httpServletRequest.getHeader("origin");
        return StringUtils.isEmpty(origin) ? "blank" : origin;
    }
}
