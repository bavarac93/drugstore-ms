package com.example.dms.config;

import com.example.dms.config.filter.CustomAuthenticationFilter;
import com.example.dms.config.filter.CustomAuthorizationFilter;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.Objects;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private static final String[] ENABLE_SWAGGER_REQUESTS = {
            "/v2/api-docs",
            "/swagger-resources/**",
            "/swagger-ui/**",
            "/webjars/**"
    };
    private final UserDetailsService userDetailsService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public SecurityConfig(final UserDetailsService userDetailsService, final BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userDetailsService = Objects.requireNonNull(userDetailsService, "userDetailsService cannot be null");
        this.bCryptPasswordEncoder = Objects.requireNonNull(bCryptPasswordEncoder, "CryptPasswordEncoder cannot be null");
    }

    @Override
    protected void configure(@NotNull final AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    protected void configure(@NotNull final HttpSecurity http) throws Exception {
        http.csrf().disable();
        CustomAuthenticationFilter customAuthenticationFilter = new CustomAuthenticationFilter(authenticationManagerBean());
        customAuthenticationFilter.setFilterProcessesUrl("/auth/login/");
        http.addFilter(customAuthenticationFilter);
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.authorizeRequests().antMatchers("/auth/login/").permitAll();
        http.authorizeRequests().antMatchers(ENABLE_SWAGGER_REQUESTS).permitAll();
        http.authorizeRequests().antMatchers("/user/**").permitAll();
        http.authorizeRequests().antMatchers("/role/**").hasAnyRole("MODERATOR", "ADMIN", "STAFF");
        http.authorizeRequests().antMatchers("/address/**").hasAnyRole("MODERATOR", "ADMIN", "STAFF", "CUSTOMER");
        http.authorizeRequests().antMatchers("/customer/**").hasAnyRole("MODERATOR", "ADMIN", "STAFF", "CUSTOMER");
        http.authorizeRequests().antMatchers("/inventory/get-items-by-name/**").permitAll();
        http.authorizeRequests().antMatchers("/inventory/get-inventory/**").permitAll();
        http.authorizeRequests().antMatchers("/inventory/**").hasAnyRole("MODERATOR", "ADMIN", "STAFF");
        http.authorizeRequests().antMatchers("/orders/**").hasAnyRole("MODERATOR", "ADMIN", "STAFF");
        http.authorizeRequests().antMatchers("/product_type/**").hasAnyRole("MODERATOR", "ADMIN", "STAFF");
        http.authorizeRequests().antMatchers("/supplier/**").hasAnyRole("MODERATOR", "ADMIN", "STAFF");
        http.authorizeRequests().antMatchers("/facility/get-all-stores/**").permitAll();
        http.authorizeRequests().antMatchers("/facility/**").hasAnyRole("MODERATOR", "ADMIN", "STAFF");
        http.authorizeRequests().anyRequest().authenticated();
        http.addFilterBefore(new CustomAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
