package com.liuh.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liuh.common.entity.User;
import org.springframework.stereotype.Repository;

/**
 * @PackageName: com.liuh.user.mapper
 * @FileName: UserMapper
 * @Description:
 * @Author: Liuh
 * @Date: 2023/4/12
 */
@Repository
public interface UserMapper extends BaseMapper<User> {
}
