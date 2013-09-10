<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page language="java" pageEncoding="UTF-8" isELIgnored="false" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台登入页面</title>
<link href="${ctx}/style/manager/css/login.css" rel="stylesheet" type="text/css" />
</head>

<body>
<script type="text/javascript">
		
	function CheckInfo()
    {
	 if (window.event) 
		{
		 var key=window.event.keyCode
		 if(key==13){
			 yanzheng(); 
		 }
		} 
    }
		

       function yanzheng(){
        
         var loginName=document.getElementById("name");
         var loginPassword=document.getElementById("pwd");
         if(loginName.value==""){
           alert("请输入用户名");
           loginName.focus();
           return false;
         }
         if(loginPassword.value==""){
           alert("请输入密码");
           loginPassword.focus();
           return false;
         }
         document.getElementById("loginForm").submit();
       }
</script>
<div class="C_main">
<div class="main">
<div class="header">
  
   

</div>
<div class="name">珍诚网络科技有限公司</div>
<div class="login">
<div class="L_left"></div>
<div class="L_right">
<div class="Lr_tit"></div>
<div class="Lr_cen">
<div ><s:if test="%{#info!=''}">
     			<font style="color:#f00; font-size:13px;
     			"> ${info } </font></s:if></div>
<form name="loginForm" id="loginForm" method="post" action="${ctx}/user/login">
<ul>
<li>用户名：<input name="name" id="name" type="text"  onkeypress="CheckInfo()" value=""/></li>
<li>密&nbsp;码：<input type="password" id="pwd" value="" name="pwd"   onkeypress="CheckInfo()"/></li>
<li>
<a href="#" onclick="yanzheng()">登&nbsp;&nbsp;录</a>
&nbsp;&nbsp;<a href="${ctx}/pages/user/register.jsp">注&nbsp;&nbsp;册</a>
<!--  <a href="#"><img style="margin-left:30px;" src="${ctx}/style/manager/images/zhuce.gif" /></a></li> -->
</ul>
</form>
</div>
</div>
</div>
<div class="footer">

Coryright 2003-2011 版权所有：<a href="http://www.zc511.com" target="_blank">浙江珍诚医药在线股份有限公司</a>  技术支持：杭州珍诚网络科技有限公司<br />

</div>
</div>
</div>
</body>
</html>