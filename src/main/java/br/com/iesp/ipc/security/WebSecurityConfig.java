package br.com.iesp.ipc.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;




@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private ImplUserDetailsService userDetailsService;
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf()
			.disable()
				.authorizeRequests()
				.antMatchers("/usuarios/listar").hasAuthority("ROLE_ADMIN")
				.antMatchers("/bootstrap/css/*").permitAll()
				.antMatchers("/bootstrap/js/*").permitAll()
				.antMatchers("/imgs/*").permitAll()
				.antMatchers("/plugins/animate-css/*").permitAll()
				.antMatchers("/plugins/bootstrap/*").permitAll()
				.antMatchers("/plugins/jquery/*").permitAll()
				.antMatchers("/plugins/jquery-datatable/*").permitAll()
				.antMatchers("/plugins/jquery-slimscroll/*").permitAll()
				.antMatchers("/plugins/node-waves/*").permitAll()
				.antMatchers("/").authenticated()
				.anyRequest().authenticated()
		.and()
			.formLogin()
				.loginPage("/login")
				.permitAll()
		.and()
			.logout()
				.logoutSuccessUrl("/login?logout");
			
		
			
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
		
	}
	
	

	
	

}
