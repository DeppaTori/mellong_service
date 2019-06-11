package com.deppatori.mellong.configuration;

import com.deppatori.mellong.security.jwt.JwtParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

      private String testText;

//    @Autowired
//    UserDetailsService userDetailService;

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .csrf().disable()
//                .authorizeRequests()
//                .antMatchers("/admin/**").hasAnyRole("ADMIN")
////	          .antMatchers("/user_list").hasRole("USER")
//               .antMatchers("/","/login","/test").permitAll()
//                .antMatchers("/api/v1/users/**").permitAll()
////                .antMatchers(HttpMethod.DELETE,"/api/v1/users/**").permitAll()
////                .antMatchers(HttpMethod.PUT,"/api/v1/users/**").permitAll()
////                .antMatchers(HttpMethod.DELETE,"/api/v1/users/**").permitAll()
////                .antMatchers(HttpMethod.GET,"/api/v1/users/**").permitAll()
//
//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                .loginPage("/login")
//                .permitAll()
//                .and()
//                .logout()
//                //  .logoutSuccessUrl("/login")
//                .permitAll()
//                .and()
//                .exceptionHandling().accessDeniedPage("/access-denied");
//    }



//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailService).passwordEncoder(passwordEncoder());
//    }

//
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }

    @Autowired
    private JwtParams jwtParams;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and()
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/api/public").permitAll()
                .anyRequest().authenticated()
                .and()
              //  .addFilter(new JwtAuthenticationFilter(authenticationManager()))
                .addFilter(getJwtAuthenticationFilter(authenticationManager()))
                .addFilter(getJwtAuthorizationFilter(authenticationManager()))
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user")
                .password(passwordEncoder().encode("password"))
                .authorities("ROLE_USER");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());

        return source;
    }

    public JwtAuthenticationFilter getJwtAuthenticationFilter(AuthenticationManager authenticationManager){

            JwtAuthenticationFilter jwtAuthenticationFilter = new JwtAuthenticationFilter(authenticationManager);
            jwtAuthenticationFilter.setJwtParams(jwtParams);
            jwtAuthenticationFilter.setFilterProcessesUrl(jwtParams.getAuthLoginUrl());
            return jwtAuthenticationFilter;

    }

    public JwtAuthorizationFilter getJwtAuthorizationFilter(AuthenticationManager authenticationManager){

        JwtAuthorizationFilter filter = new JwtAuthorizationFilter(authenticationManager);
        filter.setJwtParams(jwtParams);
        return filter;

    }


}
