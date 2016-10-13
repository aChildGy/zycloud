package demo.config;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserCache;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@Configuration
public class AuthorizationServerConfig extends WebSecurityConfigurerAdapter {
	
	private static final Logger log = LoggerFactory.getLogger(AuthorizationServerConfig.class);

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    	log.debug("-------------------------------------configureGlobal----------------------------------");
    	UserCache uc = new UserCache() {
			private List <UserDetails> users = new ArrayList<UserDetails>();
			@Override
			public void removeUserFromCache(String username) {
				log.debug("-------------------------------------username----------------------------------:"+username);
				
			}
			
			@Override
			public void putUserInCache(UserDetails user) {
				log.debug("-------------------------------------username----------------------------------:"+user.getPassword()
				+user.getUsername());
				users.add(user);
			}
			
			@Override
			public UserDetails getUserFromCache(String username) {
				UserDetails ud = new UserDetails() {
					
					@Override
					public boolean isEnabled() {
						return true;
					}
					
					@Override
					public boolean isCredentialsNonExpired() {
						// TODO Auto-generated method stub
						return false;
					}
					
					@Override
					public boolean isAccountNonLocked() {
						// TODO Auto-generated method stub
						return false;
					}
					
					@Override
					public boolean isAccountNonExpired() {
						// TODO Auto-generated method stub
						return false;
					}
					
					@Override
					public String getUsername() {
						
						return "xx";
					}
					
					@Override
					public String getPassword() {
						
						return "xx";
					}
					
					@Override
					public Collection<? extends GrantedAuthority> getAuthorities() {
						// TODO Auto-generated method stub
						return null;
					}
				};
				
				return ud;
			}
		};
    	
        auth.jdbcAuthentication().userCache(uc);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/resources/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .permitAll()
                .and()
                .csrf().disable();
    }

    @Configuration
    @EnableAuthorizationServer
    protected static class OAuth2Config extends AuthorizationServerConfigurerAdapter {

        @Override
        public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
            clients.inMemory()
                    .withClient("acme")
                    .secret("acmesecret")
                    .authorizedGrantTypes("authorization_code", "refresh_token",
                            "password").scopes("openid");
        }
    }
}
