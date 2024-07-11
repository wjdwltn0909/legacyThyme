package com.nc13.spring_legacy.service;

import com.nc13.spring_legacy.model.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomDetailService implements UserDetailsService {
    //@Setter(onMethod_ = @Autowired)
    // setter 에 autowired 적용시킴
    private UserService userService;

    @Autowired
    public CustomDetailService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userService.selectOne(username);
    }


}
