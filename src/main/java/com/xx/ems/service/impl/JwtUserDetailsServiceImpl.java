package com.xx.ems.service.impl;

import com.xx.ems.mapper.entity.Role;
import com.xx.ems.mapper.entity.User;
import com.xx.ems.service.IRoleService;
import com.xx.ems.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private IUserService userService;

    @Autowired
    private IRoleService roleService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userService.getUserInfoByUsername(s);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("%s.这个用户不存在", s));
        }
        Role role = roleService.getById(user.getRoleId());
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        if (role != null){
            SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(role.getRoleName());
            authorities.add(simpleGrantedAuthority);
        }

        return new User(user.getId(), user.getUsername(), user.getPassword(), user.getStatus(), authorities);
    }
}
