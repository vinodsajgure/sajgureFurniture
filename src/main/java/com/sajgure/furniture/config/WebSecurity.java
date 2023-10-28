package com.sajgure.furniture.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.sajgure.furniture.security.UserDetailsServiceImpl;

@Configuration
public class WebSecurity extends WebSecurityConfigurerAdapter {
	
	
	@Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsServiceImpl();
    }
     
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
     
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
         
        return authProvider;
    }
 
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

	@Override
	public void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
		.antMatchers("/").permitAll()
		.antMatchers("/css/**").permitAll()
		.antMatchers("/js/**").permitAll()
		.antMatchers("/plugins/**").permitAll()
		.antMatchers("/images/**").permitAll()
		.antMatchers("/fonts/**").permitAll()
		.antMatchers("/admin/**").permitAll()
		.antMatchers("/webjars/**").permitAll()
		.antMatchers("/welcome").authenticated()
		.antMatchers("/admin").hasAnyAuthority("ADMIN")
		.antMatchers("/enquiry").permitAll()
		.antMatchers("/carousel").permitAll()
		
		// Any other URLs which are not configured in above antMatchers
		// generally declared aunthenticated() in real time
		.anyRequest().authenticated()
		//Login Form Details
		.and()
		.formLogin()
		.defaultSuccessUrl("/admin", true)
		
		//Logout Form Details
		.and().csrf().disable()
		.logout()
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				
		//Exception Details		
		.and()	
		.exceptionHandling()
		.accessDeniedPage("/access-denied");

	}

//	@Autowired
//	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication().withUser("user").password("password").roles("USER");
//	}
}