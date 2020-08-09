package com.atoz_develop.mystudyolle.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity  // Spring Security 설정을 커스터마이즈하기 위한 애노테이션
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    // 특정 request는 인증 패스
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                // 메소드와 관계 없이 아래 요청은 모두 허용
                .mvcMatchers(
                        "/",
                        "/login",
                        "/sign-up",
                        "/check-email",
                        "/check-email-token",
                        "/email-login",
                        "/check-email-login",
                        "/login-link")
                .permitAll()

                // /profile/*은 GET만 허용
                .mvcMatchers(
                        HttpMethod.GET,
                        "/profile/*")
                .permitAll()

                // 나머지 요청은 모두 인증 필요
                .anyRequest().authenticated();

        // POST 요청 403 forbidden 방지용 임시 설정
        http.csrf().disable();
    }

    // Static(정적) 리소스 접근 허용
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .requestMatchers(PathRequest.toStaticResources().atCommonLocations());
    }
}
