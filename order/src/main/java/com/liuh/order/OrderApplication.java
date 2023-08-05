package com.liuh.order;

import com.liuh.common.clients.ProductClient;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author lh141
 */
@EnableFeignClients(clients = ProductClient.class)
//@EnableFeignClients(basePackages = "com.liuh.common.clients")
@EnableDiscoveryClient
@MapperScan("com.liuh.order.mapper")
@SpringBootApplication
public class OrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }
}
