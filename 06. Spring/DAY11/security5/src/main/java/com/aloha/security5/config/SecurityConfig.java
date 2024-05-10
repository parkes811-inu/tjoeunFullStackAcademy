package com.aloha.security5.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.CustomAutowireConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import com.aloha.security5.security.CustomAccessDeniedHandler;
import com.aloha.security5.security.CustomDetailsService;
import com.aloha.security5.security.LoginSuccessHandler;

@Configuration              // 스프링 빈 설정 클래스로 지정
@EnableWebSecurity          // 스프링 시큐리티 설정 빈으로 등록
public class SecurityConfig {

    @Autowired
    private DataSource dataSource;      // application.properties 에 정의한 DB 정보
    
    @Autowired
    private CustomDetailsService customDetailsService;

    /**
     * ✅ 인증 (Authentication)
     *  : 등록된 사용자인지 확인하여 입증
     * 
     * ✅ 인가 (Authorization)
     *  : 사용자의 권한을 확인하여 권한에 따라 자원 사용 범위를 구분하여 허락하는 것
     * 
     */

    /**
     * 🔒 스프링 시큐리티 설정 메소드 👩‍💼
     *  
     * ✅인가 설정
     * ✅로그인 설정
     * ✅로그아웃 설정
     * ✅자동 로그인 설정
     * ✅예외 처리 설정
     * ✅CSRF 방지 기능 설정
     * @param http
     * @return
     * @throws Exception
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // antMatchers("인가 URL")
        //          .permitAll()                    : 모든 사용자 접근 가능        
        //          .hasRole("USER")                : USER 권한 접근 허용
        //          .hasAnyRole("USER", "ADMIN")    : USER, ADMIN 권한 접근 허용
        
        // anyRequest() : 설정하지 않은 경로 외의 모든 요청에 대하여 설정
        // authenticated() : 인증된 사용자만 접근 허용
        http.authorizeRequests(requests -> requests
            .antMatchers("/admin", "/admin/**").hasRole("ADMIN")
            .antMatchers("/user", "/user/**").hasAnyRole("USER", "ADMIN")
            .antMatchers("/css/**", "/js/**", "/img/**").permitAll()
            .antMatchers("/**").permitAll()
            .anyRequest().authenticated())
            ;

        // 폼 기반 로그인 활성화
        // - 기본 설정 : 시큐리티 제공 로그인 페이지
        // - 커스텀 설정 
        //  .defaultSuccessUrl("/경로/경로") : 로그인 성공 시, 이동 경로 지정
        //  .loginPage() : 커스텀 로그인 페이지 지정("/login")
        //  .loginProcessingUrl() : 커스텀 로그인 처리 경로 지정 ("/login")
        //  .usernameParameter("값") : 아이디 요청 파라미터 이름 지정
        //  .passwordParameter("값") : 패스워드 요청 파라미터 이름 지정
        //  .successHandler() : 로그인 성공 시, 처리할 빈 지정
        http.formLogin(login -> login
                .defaultSuccessUrl("/")
                .loginPage("/login")
                .loginProcessingUrl("/loginPro")
                .usernameParameter("id")
                .passwordParameter("pw")
                .successHandler(authenticationSuccessHandler())
                .permitAll());

        // 사용자 정의 인증 설정
        http.userDetailsService(customDetailsService);

        // 🔓 로그아웃 설정
        // logoutSuccessUrl : 로그아웃 성공 시, 이동할 URL을 지정할 수 있다. ("/login")
        // logoutUrl        : 로그아웃 처리 요청 경로 지정 ("/logout")
        http.logout(logout -> logout.logoutSuccessUrl("/")
                .logoutUrl("/logout")
                .permitAll());


        // 👮‍♂️🔐 자동 로그인 설정
        // key()                : 자동 로그인에서 토큰 생서에 사용되는 식별 키 
        // tokenRepository()    : 토큰을 저장할 저장소를 지정하는 키워드 (데이터 소스를 포함한 저장소 객체)
        // tokenValidtySeconds() : 토큰의 유효 기간을 설정
        http.rememberMe(me -> me.key("token")
                .tokenRepository(tokenRepository())
                .tokenValiditySeconds(60 * 60 * 24 * 7));

        // ✅ 인증 에외 처리
        // accessDeniedPage()       : 접근 거부 시, 이동 경로 지정
        // accessDeniedHandler()    : 접근 거부 시, 처리할 빈 지정
        http.exceptionHandling(handling -> handling
                //. accessDeniedPage("/exception");
                .accessDeniedHandler(accessDeniedHandler()));

        // CSRF 방지 설정
        //  : CSRF는 Cross-Site Request Forgery의 약어로 
        //      사용자가 자신의 의지와는 무관하게 공격자가 의도한 행위
        //      (예: 금융 거래, 설정 변경, 계정 삭제 등)를 웹 애플리케이션에서 
        //      실행하게 만드는 공격을 말합니다.
        // http.csrf().disable(); // CSRF 방지 비활성화

        return http.build();
    }


    // 👮‍♂️🔐 사용자 인증 설정
    // - 인메모리 방식 인증
    // - JDBC 인증 방식 인증

    /** 
     * 👮‍♂️🔐 사용자 인증 관리 빈 등록 메소드
     * ⭐ 인메모리 방식 인증
     * - 기본 사용자를 메모링에 등록
     * - user  / 123456
     * - admin / 123456
     * @return
     */
    // @Bean
    // public UserDetailsService userDetailsService() {
    //     UserDetails user = User.builder()
    //                             .username("user")                                      // 아이디
    //                             .password(passwordEncoder().encode("123456"))       // 패스워드
    //                             .roles("USER")                                         // 권한
    //                             .build();
    //     UserDetails admin = User.builder()
    //                             .username("admin")                                     // 아이디
    //                             .password(passwordEncoder().encode("123456"))       // 패스워드
    //                             .roles("USER", "ADMIN")                                // 권한
    //                             .build();
    //     return new InMemoryUserDetailsManager(user, admin);
    // }

    // 👮‍♂️🔐 사용자 인증 관리 빈 등록 메소드
    // JDBC 인증 방식
    // ✅ 데이터 소스 (URL, ID, PW) - application.properties
    // ✅ SQL 쿼리 등록
    //      ⭐ 사용자 인증 쿼리
    //      ⭐ 사용자 권한 쿼리
    // @Bean
    // public UserDetailsService userDetailsService() {
    //     JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager(dataSource);
        
    //     // 사용자 인증 쿼리
    //     String sql1 = " SELECT user_id as username, user_pw as password, enabled "
    //                 + " FROM user "
    //                 + " WHERE user_id = ? "
    //                 ;
    //     // 사용자 권한 쿼리
    //     String sql2 = " SELECT user_id as usernanme, auth "
    //                 + " FROM user_auth "
    //                 + " WHERE user_id = ? "
    //                 ;
    // userDetailsManager.setUsersByUsernameQuery(sql1);
    // userDetailsManager.setAuthoritiesByUsernameQuery(sql2);
    // return userDetailsManager;
    // }





    /**
     * 🍃 AuthenticationManager 빈 등록
     * @param authenticationManager
     * @return
     * @throws Exception
     */
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception{
        return authenticationConfiguration.getAuthenticationManager();
    }

    /**
     * 🍃 암호화 방식 빈 등록
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * 🍃 자동 로그인 저장소 빈 등록
     * ✅ 데이터 소스 지정
     * @return
     */
    @Bean
    public PersistentTokenRepository tokenRepository() {
        JdbcTokenRepositoryImpl repositoryImpl = 
            new JdbcTokenRepositoryImpl();

        // persisten_loings (자동 로그인) 테이블 생성
        // repositoryImpl.setCreateTableOnStartup(true);
        // 토큰 저장소를 사용하는 데이터 소스 지정
        repositoryImpl.setDataSource(dataSource);

        return repositoryImpl;
    }

    // 🍃 접근 거부 에러 처리 빈 등록
    @Bean
    public AccessDeniedHandler accessDeniedHandler() {
        return new CustomAccessDeniedHandler();
    }

    @Bean
    public AuthenticationSuccessHandler authenticationSuccessHandler() {
        return new LoginSuccessHandler();
    }
}