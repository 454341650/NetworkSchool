package com.zc.security;

/**
 * 密码处理类.
 *
 */
public class Md5PasswordEncoder implements PasswordEncoder{

	/**
	 * 加密.
	 * @param inputPassword 新输入的密码
	 * @param salt_value 盐值
	 */
	public String encodePassword(String inputPassword, String salt_value) {
		String newPwd = inputPassword+salt_value;
		return Md5encode.MD5(newPwd);
	}
	
}
