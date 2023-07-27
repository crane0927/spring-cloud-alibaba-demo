# Spring Cloud Alibaba 学习

## 2023 年 04 月 12 日

### 1 微服务环境搭建相关 SQL

1. 用户微服务

```sql
-- 创建用户数据库

CREATE
    DATABASE `user` /*!40100 DEFAULT CHARACTER SET utf8 */;


-- `user`.shop_user definition

CREATE TABLE `shop_user`
(
    `uid`       int(11) NOT NULL AUTO_INCREMENT COMMENT '用户 id',
    `username`  varchar(1000) DEFAULT NULL COMMENT '用户名',
    `password`  varchar(1000) DEFAULT NULL COMMENT '密码',
    `telephone` varchar(1000) DEFAULT NULL COMMENT '手机号',
    `stock`     int(11)       DEFAULT NULL COMMENT '库存',
    PRIMARY KEY (`uid`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 5
  DEFAULT CHARSET = utf8;
```

2. 商品微服务

```sql
-- 创建商品数据库

CREATE
    DATABASE `product` /*!40100 DEFAULT CHARACTER SET utf8 */;

-- product.shop_product definition

CREATE TABLE `shop_product`
(
    `pid`     int(11) NOT NULL AUTO_INCREMENT COMMENT '商品 id',
    `p_name`  varchar(1000) DEFAULT NULL COMMENT '商品名称',
    `p_price` double        DEFAULT NULL COMMENT '商品价格',
    `stock`   int(11)       DEFAULT NULL COMMENT '库存',
    PRIMARY KEY (`pid`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 5
  DEFAULT CHARSET = utf8;

-- 插入数据

INSERT INTO shop_product VALUE (NULL, '小米', '1000', '5000');
INSERT INTO shop_product VALUE (NULL, '华为', '2000', '5000');
INSERT INTO shop_product VALUE (NULL, '苹果', '3000', '5000');
INSERT INTO shop_product VALUE (NULL, 'OPPO', '4000', '5000');
```

3. 订单微服务

```sql
-- 创建订单数据库

CREATE
    DATABASE `order` /*!40100 DEFAULT CHARACTER SET utf8 */;


-- `order`.shop_order definition

CREATE TABLE `shop_order`
(
    `oid`      int(11) NOT NULL AUTO_INCREMENT COMMENT '订单 id',
    `uid`      int(11)       DEFAULT NULL COMMENT '用户 id',
    `username` varchar(1000) DEFAULT NULL COMMENT '用户名',
    `pid`      int(11)       DEFAULT NULL COMMENT '商品 id',
    `p_name`   varchar(1000) DEFAULT NULL COMMENT '商品名称',
    `p_price`  double        DEFAULT NULL COMMENT '商品单价',
    `number`   int(11)       DEFAULT NULL COMMENT '购买数量',
    PRIMARY KEY (`oid`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 2
  DEFAULT CHARSET = utf8;
```

### 2 实现微服务间远程调用

## 2023 年 04 月 25 日

1. 将用户、商品、订单微服务注册到 Nacos，并通过 Nacos 实现微服务之间的调用

## 2023 年 07 月 27 日

1. 版本升级
    1. Spring Boot : 2.1.3.RELEASE -> 2.1.13.RELEASE
    2. Spring Cloud : Greenwich.RELEASE -> Greenwich.SR6
    3. Spring Cloud Alibaba : 2.1.0.RELEASE -> 2.1.4.RELEASE
2. 订单微服务引入 Fegin 实现远程调用