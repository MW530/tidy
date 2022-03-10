package priv.mw.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import priv.mw.filter.TidyJWTAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

    @Bean
    public TidyJWTAuthenticationFilter authenticationTokenFilterBean() throws Exception {
        TidyJWTAuthenticationFilter authenticationTokenFilter = new TidyJWTAuthenticationFilter();
        authenticationTokenFilter.setAuthenticationManager(authenticationManagerBean());
        return authenticationTokenFilter;
    }

//    @Bean
//    public UserDetailsService userDetailsService() {
//        UserBuilder userBuilder = User.withDefaultPasswordEncoder();
//        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//        manager.createUser(userBuilder.username("mw").password("123").roles("admin").build());
//        manager.createUser(userBuilder.username("ming").password("000").roles("anonymous").build());
//        manager.createUser(userBuilder.username("uzi").password("111").roles("member").build());
//        return manager;
//    }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.authorizeRequests().anyRequest().permitAll();
            http.addFilterBefore(authenticationTokenFilterBean(), UsernamePasswordAuthenticationFilter.class);
        }
}
