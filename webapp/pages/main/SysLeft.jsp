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
<script type="text/javascript" src="${ctx}/jslib/jquery-1.9.1.min.js" charset="utf-8"></script>
<script type="text/javascript"> 
$(function(){ 
  $(".menuTitle").click(function(){
      var m_class = $(this).next("div").attr("class");
      if(m_class == 'menuContentShow'){
         $(this).next("div").attr("class","menuContentNone");
      }else if(m_class == 'menuContentNone'){
         $(this).next("div").attr("class","menuContentShow");
      }
	  //$(this).next("div").slideToggle("slow").siblings(".menuContent:visible").slideUp("slow");
	  //$(this).toggleClass("activeTitle");
	  //$(this).siblings(".activeTitle").removeClass("activeTitle");
  });
});    
$(function(){ 
  $("a").click(function(){
     $('a').each(function(n) { 
        var oldTitle = $(this).html();
        re = new RegExp("&gt;&gt;","i");  
        var newTitle = oldTitle.replace(re,"");  
        $(this).html(newTitle);
		$(this).css({'color':''});
	 }); 
     $(this).css({'color':'#ce4e21'});
     var oldTitle = $(this).html();
     $(this).html(oldTitle+"&gt;&gt;");
  });
}); 
</script> 
</head>

<body>
<div class="main">
<!-- 菜单栏start [nei show :展开 nei:关闭]-->
<div class="sj_left">
<ul class="wai">


<div class="menuTitle img3">
	课程管理
</div>
<div class="menuContent">
  <ul class="nei show">
	<li><a href="${ctx}/fileUrl/findCouresList" target="mainFrame">课程上传</a></li>
  </ul>
</div>
<div class="menuTitle img3">
	用户管理
</div>
<div class="menuContent">
  <ul class="nei show">
	<li><a href="${ctx}/user/findUserList" target="mainFrame">子用户列表</a></li>
	<li><a href="${ctx}/user/findUserForUpdate2?id=${token.id}" target="mainFrame">更新我的信息</a></li>
  </ul>
</div>
<div class="menuTitle img1">
	接口管理
</div>
<div class="menuContentNone">
  <ul class="nei show">
    <li><a>接口管理</a></li>
  </ul>
</div>

<div class="menuTitle img2">
	开发实例
</div>
<div class="menuContent">
  <ul class="nei show">
	<li><a href="${ctx}/supply/findSupplyList" target="mainFrame">开发实例</a></li>
  </ul>
</div>

</ul>
</div>
<!-- 菜单栏end -->
<div class="sj_right"></div>
</div>

</body>
</html>
