package com.example.perfectionnement.eduLine.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.example.perfectionnement.eduLine.enums.userRole;
import com.example.perfectionnement.eduLine.services.jwt.UserService;

import lombok.RequiredArgsConstructor;

import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests(authorizeRequests ->
                authorizeRequests 
                .antMatchers("/api/auth/**").permitAll()
                .antMatchers("/api/admin/teacher").permitAll()
                .antMatchers("/api/admin/teachers").permitAll()
                .antMatchers("/api/admin/teacher/{id}").permitAll()
                .antMatchers("/api/admin/course").permitAll()
                .antMatchers("/api/admin/courses").permitAll()
                .antMatchers("/api/admin/course/enrollments").permitAll()
                .antMatchers("/api/admin/course/enrollment/{enrollmentId}/{status}").permitAll()
                .antMatchers("/api/customer/courses").permitAll()
                .antMatchers("/api/customer/teachers").permitAll() 
                .antMatchers("/api/customer/course/enroll").permitAll()
                .antMatchers("/api/customer/course/{courseId}").permitAll()
                .antMatchers("/api/customer/course/enrollments/{userId}").permitAll()
                .antMatchers("/api/admin/course/{id}").permitAll()
                .antMatchers("/api/admin/**").hasAuthority("ROLE_" + userRole.ADMIN.name())
                .antMatchers("/api/customer/**").hasAuthority("ROLE_" + userRole.CUSTOMER.name())
                .anyRequest().authenticated())
            .csrf(AbstractHttpConfigurer::disable)
            .authenticationProvider(authenticationProvider())
            .formLogin(formLogin ->
                formLogin
                    .loginPage("/login")
                    .defaultSuccessUrl("/home")
                    .permitAll())
            .logout(logout ->
                logout
                    .logoutUrl("/logout")
                    .permitAll())
            // Add this line to ignore CORS preflight requests
            .addFilterBefore(new SimpleCorsFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userService.userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    public void configure(WebSecurity web) {
        // Additional configuration for static resources if needed
    }

}
