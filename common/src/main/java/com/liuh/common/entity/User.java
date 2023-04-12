package com.liuh.common.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @PackageName: com.liuh.common.entity
 * @FileName: User
 * @Description: 用户
 * @Author: Liuh
 * @Date: 2023/4/12
 */
@Data
@TableName("shop_user")
public class User {
    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Integer uid;
    /**
     * 用户名
     */
    @TableField("username")
    private String username;
    /**
     * 密码
     */
    @TableField("password")
    private String password;

    /**
     * 手机号
     */
    @TableField("telephone")
    private String telephone;
}
