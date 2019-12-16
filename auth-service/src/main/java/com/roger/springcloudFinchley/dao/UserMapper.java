package com.roger.springcloudFinchley.dao;

import com.roger.springcloudFinchley.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by yulei on 2019/12/14.
 */

@Component
@Mapper
public interface UserMapper {
    List<User> findByUserName(String username);
}
