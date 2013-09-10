<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="pages/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>管理员登录</title>
<link rel="shortcut icon" href="${ctx}/style/website/images/common/favicon.ico" />
<link href="${ctx}/style/admin/manager/css/login.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	function doclick() {
		dosubmit();
	}
	function dokeycode() {
		if (event.keyCode == 13) {
			dosubmit();
		}
	} 
	
	function dosubmit() {
		var username = null;
		var password = null;
		var code = null;
		username = document.getElementById('j_username').value.replace(/\s+/g,
				"");
		password = document.getElementById('j_password').value.replace(/\s+/g,
				"");

		if (!username) {
			alert("请输入用户名！");
			document.getElementById('j_username').focus();
			return false;
		}

		if (!password) {
			alert("请输入密码！");
			document.getElementById('j_password').focus();
			return false;
		}

		if (username && password) {
			//document.getElementById('j_username').value=username+" "+checkcode;
			document.getElementById('loginForm').submit();
			return false;
		}

	}
	function init() {

		document.getElementById('j_username').focus();

	}
	if('${message}'!=''){
	   alert('${message}');
	}
</script>
</head>
<body style="background:url(${ctx}/style/common/images/login/backbigbg.jpg) repeat-x;">
<form id="loginForm" name="loginForm" action="${ctx}/admin/login" method="post">
<div class="backlogin">
<div class="backlogin_cen"><h1><span></span>管理员登录</h1>
<ul>
<li>用户名：<input id="j_username" name="userName"  value="administrator" onkeydown="dokeycode()"/></li>
<li>密&nbsp;&nbsp;&nbsp;码：<input id="j_password" name="userPwd" type="password" value="111111" onkeydown="dokeycode()" /></li>
<!--  
<li>验证码：<input class="qian" name="" type="text" />
  <img src="${ctx}/common/images/login/number.gif" width="87" height="30" /></li>
-->
<li><input class="btn" name="" type="button" onclick="doclick()"/></li>
</ul>
</div>
<div class="backlogin_footer">管理员登录 <a href="${ctx}/website/index">网站主页</a></div>
</div>
</form>
</body>
</html>