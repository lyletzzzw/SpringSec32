package com.lyle.securityInterceptor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

/**
 * 获取资源对应的角色信息
 * 
 * @author 访问资源对应的角色信息，用户是否具备
 *
 */
public class MyInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {


	/**
	 * string -> resource
	 * Collection<ConfigAttribute> -> role
	 */
	private static Map<String, Collection<ConfigAttribute>> resourceMap = null;

	public void updateResource() {
		synchronized (resourceMap) {
			resourceMap.clear();
			loadMap();
		}
	}

	private void loadMap() {
		resourceMap = new HashMap<String, Collection<ConfigAttribute>>();
		Collection<ConfigAttribute> atts = new ArrayList<ConfigAttribute>();  
		ConfigAttribute ca = new SecurityConfig("ROLE_TestUser");  
		atts.add(ca);
		resourceMap.put("/index.jsp", atts);
		resourceMap.put("/login.jsp", atts);
		resourceMap.put("/j_spring_security_check", atts);
		
	}
	
	/**
	 * return 资源对应的可以访问的所有角色
	 */
	@Override
	public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
		if (resourceMap == null) {
			loadMap();
		}
		String url = ((FilterInvocation) object).getRequestUrl();
		return resourceMap.get(url);
	}

	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes() {
		return null;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return true;
	}

}
