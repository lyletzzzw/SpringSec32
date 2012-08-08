package com.lyle.securityInterceptor;

import java.util.HashSet;
import java.util.Set;

import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

/**
 * 获取用户信息，通过用户名获取用户的权限信息
 * !!!注意本例中并未用到该对用户的认证信息，直接写在applicationContext.xml中
 * 
 * @author lyletzzzw
 */
@Transactional(readOnly = true)
public class UserDetailsServiceImpl implements UserDetailsService {
 
	/**
	 * 获取用户Details信息的回调函数.
	 * 
	 * @author lyletzzzw
	 */
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {

		Set<GrantedAuthority> grantedAuths = new HashSet<GrantedAuthority>();
		grantedAuths.add(new GrantedAuthorityImpl("ROLE_TestUser"));

		
		//-- mini-web示例中无以下属性, 暂时全部设为true. --//
		boolean enabled = true;
		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;
		
		String userId= "userID";
		String userName = "user";
		String authenticator="user";

		UserDetails userdetails = new SecurityUser(userId, userName,  authenticator, enabled,
				accountNonExpired, credentialsNonExpired, accountNonLocked, grantedAuths);

		return userdetails;
	}
}
