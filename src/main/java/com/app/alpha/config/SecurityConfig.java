package com.app.alpha.config;


import com.app.alpha.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    BCryptPasswordEncoder encoder;

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
                .and().withUser("user3").password(encoder.encode("123")).roles("USER", "GUEST", "ADMIN");
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
//        http.authorizeRequests().antMatchers("/home/index").permitAll().anyRequest().authenticated();
//        http.authorizeRequests().antMatchers("/home/index").hasAnyRole("USER", "GUEST", "ADMIN").antMatchers("/home/about").hasRole("ADMIN").anyRequest().permitAll();
        http.authorizeRequests().antMatchers("/account/all").hasRole("ADMIN").anyRequest().authenticated();
        //Giao diện đăng nhập
        http.httpBasic();
        http.exceptionHandling().accessDeniedPage("/security/deniedPage");
    }
}

