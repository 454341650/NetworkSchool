package com.zc.common;

import java.io.Serializable;

public class UserToken implements Serializable {

	private static final long serialVersionUID = 1L;
	/** 用户id **/
	private String id;
	/** 用户名 **/
	private String name;
	/** 密码**/
	private String pwd;
	/** 父账号 **/
	private String parent_id;
	/** 登录次数 **/
	private String login_number;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getParent_id() {
		return parent_id;
	}

	public void setParent_id(String parent_id) {
		this.parent_id = parent_id;
	}

	public String getLogin_number() {
		return login_number;
	}

	public void setLogin_number(String login_number) {
		this.login_number = login_number;
	}

}
