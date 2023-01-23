package com.example.metrovias2.seguridad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.example.metrovias2.servicio.UsuarioServicio;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration{

	@Autowired
	private UsuarioServicio usuarioServicio;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
		auth.setUserDetailsService(usuarioServicio);
		auth.setPasswordEncoder(passwordEncoder());
		return auth;
	}
	
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.authenticationProvider(authenticationProvider());
//	}

	@Bean
	protected SecurityFilterChain filterChain (HttpSecurity http) throws Exception {
		http.csrf().disable()
				.authorizeHttpRequests((authz)-> {
					try {
						authz
								.requestMatchers( "/registro**","/js/**","/css/**","/img/**").permitAll()
								.anyRequest().authenticated()
								.and()
								.formLogin()
								.loginPage("/login")
								.permitAll()
								.and()
								.logout()
								.invalidateHttpSession(true)
								.clearAuthentication(true)
								.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
								.logoutSuccessUrl("/login?logout")
								.permitAll();
					} catch (Exception e) {
						throw new RuntimeException(e);
					}
				}).httpBasic(withDefaults());

		return http.build();
	}
}






