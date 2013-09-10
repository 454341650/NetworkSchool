<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">   
<html>
<head>
<title>部门选择</title>
<script type="text/javascript" src="<%=request.getContextPath() %>/jslib/jquery-1.8.3.min.js" charset="utf-8"></script>
<style>
#main{}
#main a{text-decoration: none;}
#letter{padding: 5px 5px; border-bottom: solid 1px #cecece}
#letter a{font: 16px/20px "微软雅黑";}
#letter a:hover,#letter a.current{color: #ff5500}
ul,li{list-style-type: none;}
ul{ padding:0px 5px;}
ul li{margin:10px 0px; margin-right:10px; display:inline; padding:0;  float: left;}
ul li a{background: #ff5500; padding: 5px 5px; color: #ffffff}
</style>

<script>
	$(function(){
		init();
		$("#commendDept").click(function(){init();});
		
	});
	
	//初始化推荐
	function init()
	{
		/*推荐部门*/
		var commendHtml = "<li><a href='#' p='0209'>浙江市场部</a></li>";
			commendHtml += "<li><a href='#' p='0215'>客服VIP部</a></li>";
			commendHtml += "<li><a href='#' p='0111'>中药事业部</a></li>";
			commendHtml += "<li><a href='#' p='0248'>VIP大客户部</a></li>";
			commendHtml += "<li><a href='#' p='0224'>业务三部</a></li>";
			commendHtml += "<li><a href='#' p='0213'>调拨销售部</a></li>";
			commendHtml += "<li><a href='#' p='0249'>医院营销部</a></li>";
			commendHtml += "<li><a href='#' p='0110'>期货代理中心</a></li>";
			commendHtml += "<li><a href='#' p='0217'>江苏市场部</a></li>";
			commendHtml += "<li><a href='#' p='02'>浙江珍诚在线</a></li>";
			commendHtml += "<li><a href='#' p='0227'>业务六部</a></li>";
			commendHtml += "<li><a href='#' p='0216'>珍中部</a></li>";
			commendHtml += "<li><a href='#' p='0238'>沪皖苏市场部</a></li>";
			commendHtml += "<li><a href='#' p='0241'>沪皖大区</a></li>";
			commendHtml += "<li><a href='#' p='0250'>基药销售部</a></li>";
			commendHtml += "<li><a href='#' p='0212'>拓展部</a></li>";
			commendHtml += "<li><a href='#' p='0211'>杭州市场部</a></li>";
		
		$("#department").html(commendHtml);
		binder();
	}
	
	function getDepartment(py)
	{
		$.ajax({
			  type: "post",
			  url: "<%=request.getContextPath() %>/staff/doDepartmentList",
			  data: "py="+py+"",
			  dataType: "text",
			  success:function(data){
			  var result = eval("("+data+")");
			  var html = "";
		  		if(result.resultMap.length > 0)
		  		{
				  	$.each(result.resultMap,function(i){
				  			html += "<li><a href='#' p='"+result.resultMap[i].department_code+"'>"+result.resultMap[i].department_name+"</a></li>";
				  	});
		  		}
		  		else
			  	{
				  	html += "无相关部门！";
			  	}
		  		$("#department").html(html);
		  		binder();
			  }
			});
	}
	
	
	function binder()
	{
		$("#department li a").each(function(){
 			var o = $(this).attr("p");
 			var n = $(this).html();
 			$(this).click(function(){
 				$("#departmentCode",parent.document).val(o);
 				$("#departmentName",parent.document).val(n);
 				parent.closeColorbox();
 			});
 		});
	}
</script>
  </head>
  
  <body>
  	<div id="main">
  		<div id="letter">
  			<a href="javascript:void(0)" id="commendDept">推荐部门</a>&nbsp;|
		  	<a href="javascript:getDepartment('A')">A</a>&nbsp;<a href="javascript:getDepartment('B')">B</a>&nbsp;
		  	<a href="javascript:getDepartment('C')">C</a>&nbsp;<a href="javascript:getDepartment('D')">D</a>&nbsp;
		  	<a href="javascript:getDepartment('E')">E</a>&nbsp;<a href="javascript:getDepartment('F')">F</a>&nbsp;
		  	<a href="javascript:getDepartment('G')">G</a>&nbsp;<a href="javascript:getDepartment('H')">H</a>&nbsp;
		  	<a href="javascript:getDepartment('I')">I</a>&nbsp;<a href="javascript:getDepartment('J')">J</a>&nbsp;
		  	<a href="javascript:getDepartment('K')">K</a>&nbsp;<a href="javascript:getDepartment('L')">L</a>&nbsp;
		  	<a href="javascript:getDepartment('M')">M</a>&nbsp;<a href="javascript:getDepartment('N')">N</a>&nbsp;
		  	<a href="javascript:getDepartment('O')">O</a>&nbsp;<a href="javascript:getDepartment('P')">P</a>&nbsp;
		  	<a href="javascript:getDepartment('Q')">Q</a>&nbsp;<a href="javascript:getDepartment('R')">R</a>&nbsp;
		  	<a href="javascript:getDepartment('S')">S</a>&nbsp;<a href="javascript:getDepartment('T')">T</a>&nbsp;
		  	<a href="javascript:getDepartment('U')">U</a>&nbsp;<a href="javascript:getDepartment('V')">V</a>&nbsp;
		  	<a href="javascript:getDepartment('W')">W</a>&nbsp;<a href="javascript:getDepartment('X')">X</a>&nbsp;
		  	<a href="javascript:getDepartment('Y')">Y</a>&nbsp;<a href="javascript:getDepartment('Z')">Z</a>&nbsp;
  		</div>
		
		<ul id="department"></ul>
  	</div>
  	
   </body>
</html>
  	
