package br.com.salao.bellafashion.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import br.com.salao.bellafashion.repository.UsuarioRepository;

@EnableWebSecurity
@Configuration
public class SecurityConfigurations extends WebSecurityConfigurerAdapter {

	@Autowired
	private AutenticacaoService autenticacaoService;
	
	
	@Autowired
	private TokenService tokenService;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	@Bean
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}

	// Configuracoes de autenticacao
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(autenticacaoService).passwordEncoder(new BCryptPasswordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/bemvindo/**").permitAll()
			.antMatchers("/contato/**").permitAll()
			.anyRequest().authenticated()
			.and()
				.formLogin(form -> 	form.loginPage("/login")
								.defaultSuccessUrl("/caixageral", true).permitAll())	
				
				.logout(logout -> logout.logoutUrl("/logout").logoutSuccessUrl("/bemvindo")).csrf().disable();
		
			
			
			

	}

	// Configuracoes de recursos estaticos(js, css, imagens, etc.)
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/imagens/**", "/css/*", "/**.js", "/**.css", "/**.html", "/v2/api-docs",
				"/webjars/**", "/configuration/**", "/resources/**");
	}

}
