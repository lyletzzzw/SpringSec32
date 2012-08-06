package com.lyle;

import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


public class CheckUserFilter extends UsernamePasswordAuthenticationFilter {

    public static final String SPRING_SECURITY_FORM_USERNAME_KEY = "username";
    public static final String SPRING_SECURITY_FORM_PASSWORD_KEY = "password";
}
