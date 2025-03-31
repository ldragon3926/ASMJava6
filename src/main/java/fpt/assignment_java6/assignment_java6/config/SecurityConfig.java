package fpt.assignment_java6.assignment_java6.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public PasswordEncoder  passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        List<UserDetails> list = new ArrayList<>();
        PasswordEncoder encoder = passwordEncoder();
         UserDetails admin = User.builder()
                 .username("admin")
                 .password(encoder.encode("admin"))
                 .roles("ADMIN")
                 .build();
        UserDetails user = User.builder()
                .username("user")
                .password(encoder.encode("user"))
                .roles("USER")
                .build();
         list.add(admin);
        list.add(user);
        return new InMemoryUserDetailsManager(list); //Quản lý các user detail của mình đấy
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
httpSecurity.authorizeHttpRequests(
req -> req.requestMatchers("/admin/**").hasRole("ADMIN")
                .anyRequest().permitAll()
        ).formLogin(login ->login.loginProcessingUrl("/login"));
        return httpSecurity.build();
    }
}
