package com.zc.security;

public interface PasswordEncoder {

	public String encodePassword(String password,String salt_value);
}
