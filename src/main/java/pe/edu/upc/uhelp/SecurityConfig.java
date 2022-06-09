package pe.edu.upc.uhelp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import pe.edu.upc.uhelp.serviceimplements.JpaUserDetailsService;



@EnableGlobalMethodSecurity(securedEnabled = true)
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	
	@Autowired
	private JpaUserDetailsService userDetailsService;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	/*@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder BCryptPasswordEncoder=new BCryptPasswordEncoder();
		return BCryptPasswordEncoder;
	}*/
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests()
			.antMatchers("/telefonos/**")
				.hasRole("ADMIN")
			.antMatchers("/personas/**")
				.hasRole("USER")
			.antMatchers("/inicio")
				.hasAnyRole("USER","ADMIN")
			.and()
				.formLogin()
			.and()	
				.exceptionHandling().accessDeniedPage("/error")
			;
	}
	@Autowired
	public void configurerGlobal(AuthenticationManagerBuilder build) throws Exception {
		build.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
	}
}
