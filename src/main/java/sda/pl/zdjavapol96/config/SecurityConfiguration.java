package sda.pl.zdjavapol96.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import sda.pl.zdjavapol96.service.UserAppService;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    private final UserAppService userAppService;
    public SecurityConfiguration(UserAppService userAppService) {
        this.userAppService = userAppService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.csrf().disable()
                .headers()
                .and()
                .authorizeRequests()
                .antMatchers("/**").permitAll()
                .anyRequest().permitAll()
                .and()
                .headers().frameOptions().disable();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}