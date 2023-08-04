package com.liuh.order.controller;

import com.liuh.order.config.ParameterProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: liuhuan
 * @Date: 2023/8/4 15:39
 * @PackageName: com.liuh.order.controller
 * @ClassName: ParameterController
 * @Description: TODO
 * @Version 1.0
 */
@RestController
@Slf4j
@RequestMapping("/parameter")
public class ParameterController {


    @Autowired
    private ParameterProperties parameterProperties;


    @GetMapping("/get")
    public String get() {
        Date now = new Date();
        String format = new SimpleDateFormat(parameterProperties.getDateformat()).format(now);
        return format;
    }

    @GetMapping("/getName")
    public String getName() {
        return parameterProperties.getName();
    }
}
