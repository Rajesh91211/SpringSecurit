package com.example.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		http.csrf().disable()
		.authorizeHttpRequests(auth-> auth.anyRequest()
				.authenticated())
		        .formLogin(Customizer.withDefaults());
		http.httpBasic(Customizer.withDefaults());
		
		
		return http.build();
	}
	
	@Bean
	public UserDetailsService users()
	{
		UserDetails user= User.builder()
				.username("Rajesh")
				.password(encoder().encode("Rajesh21"))
				.roles("USER")
				.build();
		
		UserDetails admin= User.builder()
				.username("Admin")
				.password(encoder().encode("Admin12"))
				.roles("ADMIN")
				.build();
		return new InMemoryUserDetailsManager(user,admin);
				
	}
	
	@Bean
	public PasswordEncoder encoder()
	{
		return new BCryptPasswordEncoder();
	}
	

}
