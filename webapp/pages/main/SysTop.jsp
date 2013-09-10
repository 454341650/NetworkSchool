<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/taglibs.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="pragma" content="no-cache" />
<meta http-equiv="cache-control" content="no-cache" />
<meta http-equiv="expires" content="0" />
<title></title>
<link rel="shortcut icon" href="${ctx}/style/website/images/common/favicon.ico" />
<link href="css/sjck.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" language="JavaScript" src="${ctx}/jslib/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
function logout(url) {
	if (!confirm('您确认退出本系统吗?'))
		return;
	window.parent.location.href = url;
}

$(document).ready(function(){
  
});
</script>
</head>
<body>
<div class="sj_top"><h1>网络商学苑<font size="2" >[欢迎您：<span id="user_info">${token.name}</span>&nbsp;&nbsp;<span  onclick="logout('${ctx}/user/logout');"   style="border: 1px solid #0468A2;padding:1px;cursor: pointer">退出系统</span></font>&nbsp;<font size="2"><a href="${ctx}/website/index" target="_blank" style="color: white;">网站首页</a>]&nbsp;&nbsp;</font></h1></div>
</body>
</html>
