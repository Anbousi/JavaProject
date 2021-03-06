package com.axsosacademy.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	private UserDetailsService userDetailsService;
	
	
	
    public WebSecurityConfig(UserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}

	// add Bcyrpt bean
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
	 @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http.
	            authorizeRequests()

	                .antMatchers("/css/**", "/js/**", "/registration","/category" ,"/category/painting/*","/category/**","/","/images/**","/category-photos/**","/painting-photos/**","/send/**" , "/about").permitAll()
	                .antMatchers("/admin/**","/cart/**").hasRole("ADMIN")
	                .antMatchers("/cart/**").hasRole("USER")

	                .anyRequest().authenticated()
	                .and()
	            .formLogin()
	                .loginPage("/login")
	                .permitAll()

//                .defaultSuccessUrl("/", true)
	                .and()
	            .logout()
	            .logoutSuccessUrl("/")
	                .permitAll();
	    }
	 
	 @Autowired
	    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
	    }   

}
