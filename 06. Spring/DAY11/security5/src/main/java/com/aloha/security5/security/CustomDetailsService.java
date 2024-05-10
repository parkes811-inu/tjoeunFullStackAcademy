package com.aloha.security5.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.aloha.security5.dto.CustomUser;
import com.aloha.security5.dto.Users;
import com.aloha.security5.mapper.UserMapper;

@Service
public class CustomDetailsService implements UserDetailsService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // MyBatis를 사용해서 사용자 정보 조회
        Users user = userMapper.login(username);
        
        if(user == null) {
            throw new UsernameNotFoundException("사용자를 찾을 수 없습니다." + username);
        }

        // customUser -> UserDetails
        CustomUser customUser = new CustomUser(user);
        return customUser; 
    }
    
}
