//package br.com.abaloneapi.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//@Configuration
//public class SegurancaConfig extends WebSecurityConfigurerAdapter {
//
//	@Bean
//	PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
//
//	@Override
//	public void configure(AuthenticationManagerBuilder builder) throws Exception {
//		builder
//		.inMemoryAuthentication()
//		.withUser("usuario1")
//		.password(passwordEncoder().encode("123456"))
//		.roles("ADMIN");
//	}
//	
//	@Override
//	public void configure(HttpSecurity http) throws Exception {
//		http
//		.antMatcher("/api/cadastrar").authorizeRequests()
//		.antMatchers("/api/buscar").permitAll()
//		.anyRequest().authenticated()
//		.and()
//		.formLogin().loginPage("/login").permitAll();
//		
//		http.csrf().disable();
//		http.headers().frameOptions().disable();
//	}
//}