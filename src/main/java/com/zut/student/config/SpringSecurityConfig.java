package com.zut.student.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {

	@Bean
	public SecurityFilterChain filterChain(final HttpSecurity http) throws Exception {

		http
				.formLogin()
				.loginPage("/login.html")
				.failureUrl("/login_error.html")
				.and()
				.logout()
				.logoutSuccessUrl("/login.html")
				.and()
				.exceptionHandling()
				.accessDeniedPage("/403.html");

		return http.build();
	}

}
