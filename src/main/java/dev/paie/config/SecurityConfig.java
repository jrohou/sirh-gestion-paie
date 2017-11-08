package dev.paie.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@Import(ServicesConfig.class)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired private PasswordEncoder passwordEncoder;
	@Autowired private DataSource dataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	auth.jdbcAuthentication()
		.dataSource(dataSource)
		.passwordEncoder(passwordEncoder)
		.usersByUsernameQuery("select nomUtilisateur, motDePasse, estActif from UTILISATEUR where nomUtilisateur=?")
		.authoritiesByUsernameQuery("select nomUtilisateur, ROLE from UTILISATEUR where nomUtilisateur = ?");
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	http
		.authorizeRequests()
		.antMatchers("/mvc/connexion/**","/css/**","/font/**","/js/**").permitAll()
		.anyRequest()
		.authenticated()
		.and()
		.formLogin()
		.loginPage("/mvc/connexion")
		.defaultSuccessUrl("/mvc/employes/lister");
	}

}
