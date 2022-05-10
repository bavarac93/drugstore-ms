package com.example.dms.security;

import com.example.dms.security.filter.CustomAuthenticationFilter;
import com.example.dms.security.filter.CustomAuthorizationFilter;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
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
        customAuthenticationFilter.setFilterProcessesUrl("/security/login");
        http.addFilter(customAuthenticationFilter);
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.authorizeRequests().antMatchers("/security/login", "/security/token/refresh/**").permitAll();
        http.authorizeRequests().antMatchers(HttpMethod.POST, "/security/user/save").hasAuthority("ROLE_ADMIN");
        http.authorizeRequests().antMatchers(HttpMethod.POST, "/security/user/save").hasAuthority("ROLE_OWNER");
        http.authorizeRequests().antMatchers(HttpMethod.GET, "/role/roles").hasAuthority("ROLE_USER");
        http.authorizeRequests().antMatchers(HttpMethod.GET, "/role/roles").hasAuthority("ROLE_OWNER");
        http.authorizeRequests().antMatchers(HttpMethod.GET, "/role/roles").hasAuthority("ROLE_ADMIN");
        http.authorizeRequests().antMatchers(HttpMethod.POST, "/role/save").hasAuthority("ROLE_ADMIN");
        http.authorizeRequests().antMatchers(HttpMethod.POST, "/role/save").hasAuthority("ROLE_OWNER");
        http.authorizeRequests().antMatchers(HttpMethod.POST, "/security/user/add-role-to-user/").hasAuthority("ROLE_OWNER");
        http.authorizeRequests().antMatchers(HttpMethod.POST, "/security/user/add-role-to-user/").hasAuthority("ROLE_ADMIN");
        http.authorizeRequests().anyRequest().authenticated();
        http.addFilterBefore(new CustomAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
