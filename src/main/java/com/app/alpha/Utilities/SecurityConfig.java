package com.app.alpha.Utilities;

import com.app.alpha.Model.Accounts;
import com.app.alpha.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.NoSuchElementException;
import java.util.stream.Collectors;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    BCryptPasswordEncoder encoder;

    @Autowired
    AccountService accountService;

    //Mã hoá mật khẩu
    @Bean
    public BCryptPasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //Quản lý dữ liệu người dùng

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("user1").password(encoder.encode("123")).roles("GUEST")
                .and().withUser("user2").password(encoder.encode("123")).roles("USER", "GUEST")
                .and().withUser("user3").password(encoder.encode("")).roles("USER", "GUEST", "ADMIN");
    }
    //        auth.userDetailsService(username -> {
//            try {
//                Accounts user = accountService.getByUsername(username);
//                String password = encoder.encode(user.getPassword());
//                String[] roles = user.getAuthorities().stream().map(er -> er.getRole().getId()).collect(Collectors.toList()).toArray(new String[0]);
//                return User.withUsername(username).password(password).roles(roles).build();
//            }catch (NoSuchElementException e){
//                throw new UsernameNotFoundException("username"+ "not found");
//            }
//        });



//Phân quyền người sử dụng và hình thức đăng nhập

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //CSRF, CORS - disable đi để tự cấu hình lại cho CSRF, CORS
        http.csrf().disable().cors().disable();

        //Phân quyền sử dụng - bắt buộc đăng nhập khi truy cập vào bất kỳ URL nào
        http.authorizeRequests().antMatchers("/accounts/all").permitAll().anyRequest().authenticated();

        //Giao diện đăng nhập
        http.httpBasic();
    }
}
