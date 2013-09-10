package com.zc.filter;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.dispatcher.ng.filter.StrutsPrepareAndExecuteFilter;

import com.zc.common.UserToken;
import com.zc.constants.AppConstants;
import com.zc.util.CookieUtil;

public class ZcStrutsPrepareAndExecuteFilter extends StrutsPrepareAndExecuteFilter {

	private static Set<String> excludes = new HashSet<String>();//不过滤的访问地址
	private static Set<String> memberExcludes = new HashSet<String>();//要过滤的访问地址
	static {
		excludes.add("/error/");
		excludes.add("/jslib/");
		excludes.add("/lib/");
		excludes.add("/style/");
		excludes.add("/upload/");
		excludes.add("/admin.jsp");
		excludes.add("/index.jsp");
		excludes.add("/jvm.jsp");
		excludes.add("/login.jsp");
		excludes.add("/admin/login");
		excludes.add("/admin/logout");
		excludes.add("/favicon.ico");
		excludes.add("/website/");
		excludes.add("/common/");
		excludes.add("/test/");
		
	}

	private boolean contains(String requestUri,Set<String> excludes) {
		for (String exclude : excludes) {
			if (requestUri.indexOf(exclude) > -1) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException,
			ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String requestUri = request.getRequestURI();
		String basePath = request.getContextPath();
		/*if(requestUri.equals(basePath+"/")){
			response.sendRedirect(basePath+"/website/index");
			return;  
		}
		if(requestUri.indexOf("/member/") > -1){
			String user_code = CookieUtil.getUserCodeByName(request, AppConstants.COOKIE_TOKEN);//从cookie里取user_code
			if(user_code == null){
				response.sendRedirect(basePath+"/login.jsp");
				return;
			}
			UserToken token = (UserToken)request.getSession().getAttribute(AppConstants.USER_TOKEN);
			if(token == null){
				response.sendRedirect(basePath+"/login.jsp");
				return;
			}
			//此处目的：不允已登陆在会员中心的用户通过地址访问管理后台，管理后台反之。
			String loginType = token.getLogin_type();
			if(loginType.equals("1")){
				if(requestUri.indexOf("/member/") > -1){
					response.sendRedirect(basePath+"/error/illegal/illegal_access.html");
					return;
				}
			}
		}
		if (!contains(requestUri,excludes)) {//如果访问地址不在排除的地址中，则执行以下操作
			UserToken token = (UserToken)request.getSession().getAttribute(AppConstants.USER_TOKEN);
			String user_code = CookieUtil.getUserCodeByName(request, AppConstants.COOKIE_TOKEN);//从cookie里取user_code
			if(user_code == null){
				response.sendRedirect(basePath+"/error/404/404.html");
				return;  
			}
			if(token == null){
				response.sendRedirect(basePath+"/error/404/404.html");
				return;  
			}
			//此处目的：不允已登陆在会员中心的用户通过地址访问管理后台，管理后台反之。
			String loginType = token.getLogin_type();
			if(loginType.equals("1")){
				if(requestUri.indexOf("/member/") > -1){
					response.sendRedirect(basePath+"/error/illegal/illegal_access.html");
					return;
				}
			}else if(loginType.equals("2")){
				if(requestUri.indexOf("/member/") == -1){
					response.sendRedirect(basePath+"/error/illegal/illegal_access.html");
					return;
				}
			}
		}*/
			
	/* if(requestUri.contains("servlet")){
            ((HttpServletResponse) response).sendRedirect("/FCExporter.servlet");
        }*/
	  super.doFilter(req, res, chain);
	}
	/*
	 * @Override public void doFilter(ServletRequest req, ServletResponse res,
	 * FilterChain chain) throws IOException, ServletException {
	 * HttpServletRequest request = (HttpServletRequest) req;
	 * HttpServletResponse response = (HttpServletResponse) res;
	 * 
	 * // 不过滤的url,可以不断添加 String requestUri = request.getRequestURI();
	 * 
	 * if (requestUri.indexOf("/syn/") != -1) { chain.doFilter(req, res); return
	 * ; }
	 * 
	 * try { prepare.setEncodingAndLocale(request, response);
	 * prepare.createActionContext(request, response);
	 * prepare.assignDispatcherToThread(); if (excludedPatterns != null &&
	 * prepare.isUrlExcluded(request, excludedPatterns)) {
	 * chain.doFilter(request, response); } else { request =
	 * prepare.wrapRequest(request); ActionMapping mapping =
	 * prepare.findActionMapping(request, response, true);
	 * 
	 * if (mapping == null) { boolean handled =
	 * execute.executeStaticResourceRequest(request, response);
	 * 
	 * if (!handled) { chain.doFilter(request, response); } } else {
	 * SecurityContext securityContext = SecurityContextHolder.getContext();
	 * 
	 * if (securityContext == null || null ==
	 * securityContext.getAuthentication() ||
	 * securityContext.getAuthentication().getName().equals("anonymousUser")) {
	 * // request.getRequestDispatcher("/login.html").forward(request, response);
	 * // response.sendRedirect("/login.html");
	 * 
	 * response.setStatus(WmsHttpStatus.SESSION_INVALIDATE); // return ; }
	 * 
	 * execute.executeAction(request, response, mapping); } } } finally {
	 * //prepare.cleanupRequest(request); } }
	 */
}