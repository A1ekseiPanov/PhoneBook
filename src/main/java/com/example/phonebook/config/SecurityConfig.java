package com.example.phonebook.config;


import com.example.phonebook.models.security.User;
import com.example.phonebook.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import java.util.Optional;


@Configuration
@Slf4j
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public UserDetailsService DetailsService(UserService userService) {
            return username -> {
            Optional<User> user = userService.getUserByUsername(username);
            if (user.isPresent()) {
                return user.get();
            }
            throw new UsernameNotFoundException("User ‘" + username + "’ not found");
        };
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http.csrf().disable()
                .authorizeRequests()

                .antMatchers("/auth/login","error","/register").permitAll() //допускает не аутентифицированного пользователя
                .anyRequest().authenticated()//все остальные запросы через аутентификацию
                .and()
                .formLogin()//настройка формы для входа
                .loginPage("/auth/login")//адрес для страницы входа
                .loginProcessingUrl("/process_login") //куда мы будем отправлять данные с формы(см.login.html)
                .defaultSuccessUrl("/",true)//переходим после успешной
                .failureUrl("/auth/login?error")// в случае неуспешной аунт
                .and()
                .logout()//разлогиниваение
                .logoutUrl("/logout")
                .logoutSuccessUrl("/auth/login")
                .and()
                .build();

    }





}
