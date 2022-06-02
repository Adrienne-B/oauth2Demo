package com.tts.oauth2Demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration  extends WebSecurityConfigurerAdapter{
	@Override
	protected void configure(HttpSecurity http)throws Exception{
		http
			.authorizeRequests()
					.antMatchers("/", "/error").permitAll()
					.anyRequest().authenticated()
				.and()
				.exceptionHandling()
					.authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
				.and()
				.oauth2Login().defaultSuccessUrl("/", true);
					
		
	}

}
