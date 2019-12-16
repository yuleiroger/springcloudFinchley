package com.roger.springcloudFinchley.service.impl;

import com.roger.springcloudFinchley.dao.UserMapper;
import com.roger.springcloudFinchley.entity.Role;
import com.roger.springcloudFinchley.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2019/12/6.
 */
@Service
public class UserService implements UserDetailsService {
    @Autowired
    UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<User> userList = userMapper.findByUserName(username);
        if (userList.isEmpty()) {
            throw new UsernameNotFoundException(username);
        }
        List<Role> authorities = new ArrayList<>();
        for (User user : userList) {
            Role role = new Role();
            role.setId(user.getRoleId());
            role.setName(user.getRoleName());
            authorities.add(role);
        }

        User user = userList.get(0);
        user.setAuthorities(authorities);
        return user;

    }
}
