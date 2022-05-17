package com.example.dms.config;

import com.example.dms.config.filter.CustomAuthenticationFilter;
import com.example.dms.config.filter.CustomAuthorizationFilter;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
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
    private static final String[] ENABLE_SWAGGER_REQUESTS = {
            "/v2/api-docs",
            "/swagger-resources/**",
            "/swagger-ui/**",
            "/webjars/**"
    };

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
        customAuthenticationFilter.setFilterProcessesUrl("/user/login/");
        http.addFilter(customAuthenticationFilter);
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.authorizeRequests().antMatchers("/user/login/").permitAll();
        http.authorizeRequests().antMatchers(ENABLE_SWAGGER_REQUESTS).permitAll();
        http.authorizeRequests().antMatchers("/user/**").hasAnyAuthority("ROLE_MODERATOR","ROLE_ADMIN", "ROLE_STAFF","ROLE_CUSTOMER");
        http.authorizeRequests().antMatchers("/role/**").hasAnyAuthority("ROLE_MODERATOR","ROLE_ADMIN", "ROLE_STAFF");
        http.authorizeRequests().antMatchers(HttpMethod.POST,"/role/**").hasAnyAuthority("ROLE_ADMIN");
        http.authorizeRequests().antMatchers("/address/**").hasAnyAuthority("ROLE_MODERATOR","ROLE_ADMIN", "ROLE_STAFF","ROLE_CUSTOMER");
        http.authorizeRequests().antMatchers("/customer/**").hasAnyAuthority("ROLE_MODERATOR","ROLE_ADMIN", "ROLE_STAFF","ROLE_CUSTOMER");
        http.authorizeRequests().antMatchers("/inventory/**").hasAnyAuthority("ROLE_MODERATOR","ROLE_ADMIN", "ROLE_STAFF","ROLE_CUSTOMER");
        http.authorizeRequests().antMatchers(HttpMethod.GET,"/inventory/**").hasAnyAuthority("ROLE_GUEST");
        http.authorizeRequests().antMatchers("/orders/**").hasAnyAuthority("ROLE_MODERATOR","ROLE_ADMIN", "ROLE_STAFF");
        http.authorizeRequests().antMatchers("/product_type/**").hasAnyAuthority("ROLE_MODERATOR","ROLE_ADMIN", "ROLE_STAFF");
        http.authorizeRequests().antMatchers("/supplier/**").hasAnyAuthority("ROLE_MODERATOR","ROLE_ADMIN", "ROLE_STAFF");
        http.exceptionHandling().accessDeniedPage("/authentication/login");
        http.authorizeRequests().anyRequest().authenticated();
        http.addFilterBefore(new CustomAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
    }
    @Bean
    public RoleHierarchy roleHierarchy() {
        RoleHierarchyImpl roleHierarchy = new RoleHierarchyImpl();
        String hierarchy = "ROLE_MODERATOR > ROLE_ADMIN \n ROLE_ADMIN > ROLE_STAFF \n ROLE_STAFF > ROLE_CUSTOMER \n ROLE_CUSTOMER > ROLE_GUEST";
        roleHierarchy.setHierarchy(hierarchy);
        return roleHierarchy;
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
