package com.zc.common;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;

import com.danga.MemCached.MemCachedClient;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zc.constants.AppConstants;

/**
 * 此类是web层所有action的基类.
 * 
 */
public abstract class BaseAction extends ActionSupport {
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -382427500522501943L;

	/** 记录日志的接口. */
	protected static Log log = LogFactory.getLog(BaseAction.class);

	private PrintWriter out;
	/**
	 * 获得服务IP.
	 * 
	 * @return the app_ ip
	 */
	public String getApp_IP() {
		// 取服务IP
		try {
			return InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			return null;
		}
	}

	/**
	 * 获得上下文.
	 * 
	 * @return ActionContext
	 */
	public ActionContext getContext() {
		return ActionContext.getContext();
	}

	/**
	 * 获得当前用户IP.
	 * 
	 * @return the current user ip
	 */
	public String getCurrentUserIP() {
		// 取用户IP
		// return getRequest().getRemoteAddr();
		String ip = getRequest().getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = getRequest().getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = getRequest().getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = getRequest().getRemoteAddr();
		}

		return ip;
	}

	/**
	 * 获得servlet上下文.
	 * 
	 * @return ServletContext
	 */
	public ServletContext getMyServletContext() {
		return ServletActionContext.getServletContext();
	}

	/**
	 * 获得会话对象.
	 * 
	 * @return Map<String, Object>
	 */
	public Map<String, Object> getMySession() {
		return ActionContext.getContext().getSession();
	}
	/**
	 * Gets the parameter.
	 * 
	 * @param name
	 *            the name
	 * @return the parameter
	 */
	public String getParameter(String name) {
		return getRequest().getParameter(name);
	}

	/**
	 * Convenience method to get the request.
	 * 
	 * @return current request
	 */
	protected HttpServletRequest getRequest() {
		HttpServletRequest request = ServletActionContext.getRequest();
		return request;
	}

	/**
	 * Convenience method to get the response.
	 * 
	 * @return current response
	 */
	protected HttpServletResponse getResponse() {
		return ServletActionContext.getResponse();
	}

	protected void write(String content) throws IOException {
		HttpServletResponse response = getResponse();
//		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/plain");
		response.getWriter().write(content);
	}

	/**
	 * Gets the session.
	 * 
	 * @return the session
	 */
	protected HttpSession getSession() {
		return getRequest().getSession();
	}
	/**
	 * 获取登陆用户名.
	 * 
	 */
	public String getLoginUserName() {
		if(getMySession().get(AppConstants.USER_TOKEN) != null){
			UserToken token = (UserToken)getMySession().get(AppConstants.USER_TOKEN);
			return token.getName();
		}
		return null;
		
	}
	
	/**
	 * 获取登陆用户编码.
	 * 
	 */
	public String getLoginUserCode() {
		if(getMySession().get(AppConstants.USER_TOKEN) != null){
			UserToken token = (UserToken)getMySession().get(AppConstants.USER_TOKEN);
			return token.getId();
		}
		return null;
		
	}
	
	
	/**
	 * 获取登陆用户标识.
	 * 
	 */
	public UserToken getUserToken() {
		if(getMySession().get(AppConstants.USER_TOKEN) != null){
			UserToken token = (UserToken)getMySession().get(AppConstants.USER_TOKEN);
			return token;
		}
		return null;
		
	}
	
	/**
	 * 关闭子窗口并且刷新父窗口
	 *
	 * @param alert:关闭窗口之前的提示信息
	 * @param refleshParent:是否要刷新父窗口
	 */
	public void closeWindow(String alert, boolean refleshParent) {
		try {
			out = getResponse().getWriter();
			if (alert != null && !alert.equals("")) {
				// String alertInfo=new String(alert.getBytes(),"iso-8859-1");
				ServletActionContext.getResponse().setContentType("text/html;charset=utf-8"); 
				String alertInfo = new String(alert.getBytes("utf-8"), "utf-8"); 
				out.println("<script>alert('" + alertInfo + "')</script>");
			}
			if (refleshParent) {
				out.println("<script>window.opener.location.reload();</script>");
			}
			out.println("<script>window.close()</script>");
		} catch (Exception e) {
			
		}
	}
}
