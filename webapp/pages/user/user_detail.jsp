<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp"%>
<!-- 从分页列表过来返回列表需要保留分页状态时用到begin -->
<%@ include file="../common/back.jsp"%>
<!-- 从分页列表过来返回列表需要保留分页状态时用到end -->
<div id="maincontent">
  <div id="maincontent_inner">
   <!-- 导航菜单start -->
     <div class="title">
        <span class="titletxt">您现在的位置：</span>
        <ul><li class="root">首页</li>
        <li>子用户列表</li>
        <li>子用户更新</li></ul>
     </div>
   <!-- 导航菜单end -->
  <div class="form"> 
    <div class="tinput">  
     <div class="tbody" >
	     <table  class="tviewbodyO"  cellSpacing="1"  cellPadding="0"  width="100%"  align="center"  border="0" >
         	<tr >
            	<td  class="tabletitleO" >用户名：</td>
            	<td  class="tabletxtO" >${model.name}</td>                                    
            </tr>
            <tr >
                <td  class="tabletitleO" >真实姓名：</td>
                <td  class="tabletxtO" >${model.truename}</td>                                    
            </tr>   
            <tr >
                <td  class="tabletitleO" >性别：</td>
                <td  class="tabletxtO" >
					<c:choose>
                    	<c:when test="${model.sex=='0'}">女</c:when>
                    	<c:when test="${model.sex=='1'}">男</c:when>
                    </c:choose>
                </td>                                    
            </tr>
			<tr >
                <td  class="tabletitleO" >最后登录时间：</td>
                <td  class="tabletxtO" >${model.lastposttime}</td>                                    
            </tr> 
            <tr >
                <td  class="tabletitleO" >登录次数：</td>
                <td  class="tabletxtO" >${model.login_number}</td>                                    
            </tr> 
		</table>        
		<table cellspacing=0 cellpadding=0 width="100%" align=center border=0 class="btnbar">
			<tr>
            	<td class="btnbarL"></td>
                <td class="btnbarC">
					<input type="button" class="button" value="返回" onclick="goBack()">
				</td>
                <td class="btnbarR"></td>
			</tr>
        </table>            
     </div>
  </div>
   </div>   
 </div>
</div>
<%@ include file="../common/footer.jsp"%>
