package com.example.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
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
public class SecurityConfiguration {

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		http.csrf(csrf -> csrf.disable())
				.authorizeHttpRequests(
						auth -> auth.requestMatchers("/public/**").permitAll().anyRequest().authenticated())
				.httpBasic(httpBasic->{});
				//.formLogin(formLogin -> {}); by default
		return http.build();
	}
	
	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder(5);
	}
	
	@Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration builder) throws Exception {
        return builder.getAuthenticationManager();
    }
}

/*
@Bean
public UserDetailsService userDetailsService()
{
    UserDetails user1 = User.withUsername("ishwar").password("{noop}ishwar").roles("User").build();
    UserDetails admin = User.withUsername("naveen").password("{noop}naveen").roles("Admin").build();
    return new InMemoryUserDetailsManager(user1,admin);
}
========================================================================================================
@Bean
UserDetailsService userDetailsService() {
	UserDetails user1 = User.withUsername("ishwar").password(passwordEncoder().encode("ishwar")).build();
	UserDetails admin = User.withUsername("naveen").password(passwordEncoder().encode("naveen")).build();
	return new InMemoryUserDetailsManager(user1, admin);
}
========================================================================================================
@Bean
    public UserDetailsService userDetailsService() {
		InMemoryUserDetailsManager manger = new InMemoryUserDetailsManager();
        manger.createUser(User.withUsername("ishwar").password(passwordEncoder().encode("ishwar")).roles("Admin").build());
        return manger;
    }
*/
