package com.aloha.security5.dto;


import java.util.Collection;
import java.util.stream.Collectors;

import javax.annotation.Generated;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

/**
 * UserDetailsService 
 * : Spring Security에서 사용자 정보를 데이터베이스에서 가져와서,
 *   사용자 인증을 수행하기 위한 인터페이스
 * * 위 인터페이스를 구현하여 loadUserByUsername() 재정의하면,
 * * 데이터베이스나 다른 소스로부터 사용자 인증정보를 가져와서 스프링 시큐리티에 전달해줄 수 있다.
 */
@Slf4j
@Data
@ToString
@Getter
public class CustomUser implements UserDetails {
    
    // 사용자 DTO
    private Users user;

    public CustomUser(Users user) {
        this.user = user;
    }

    /**
     * 권한 정보 메소드
     * UserDetails 를 CustomerUser로 구현하여,
     * Spring Security의 User 대신 사용자 정의 인증 객체(CustomUser)로 적용
     * ** CustomUser 적용 시, 권한을 사용할 때 'ROLE_' 를 붙혀서 사용한다. 
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return user.getAuthList().stream()
                                 .map((auth) -> new SimpleGrantedAuthority(auth.getAuth()))
                                 .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return user.getUserPw();
    }

    @Override
    public String getUsername() {
        return user.getUserId();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;    
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;    
    }

    @Override
    public boolean isEnabled() {
        return user.getEnabled() == 0 ? false : true;
    }
    
    
}