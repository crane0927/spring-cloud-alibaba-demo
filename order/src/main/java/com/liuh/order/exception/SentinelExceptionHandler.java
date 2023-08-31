package com.liuh.order.exception;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.BlockExceptionHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.authority.AuthorityException;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowException;
import com.alibaba.csp.sentinel.slots.system.SystemBlockException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: liuhuan
 * @Date: 2023/8/31 9:35
 * @PackageName: com.liuh.order.exception
 * @ClassName: BlockExceptionHandler
 * @Description: TODO
 * @Version 1.0
 */
@Component
public class SentinelExceptionHandler implements BlockExceptionHandler {
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, BlockException e) throws Exception {
        String msg;
        int status = 429;
        if (e instanceof FlowException) {
            msg = "限流异常";
        } else if (e instanceof ParamFlowException) {
            msg = "热点参数限流的异常";
        } else if (e instanceof DegradeException) {
            msg = "降级异常";
        } else if (e instanceof AuthorityException) {
            msg = "授权规则异常";
            status = 401;
        } else if (e instanceof SystemBlockException) {
            msg = "系统规则异常";
        } else {
            msg = "未知异常";
        }

        Map<String, Object> map = new HashMap<>(2);
        map.put("msg", msg);
        map.put("status", status);
        httpServletResponse.setContentType("application/json;charset=utf-8");
        httpServletResponse.setStatus(status);
        httpServletResponse.getWriter().println(map);
    }
}
