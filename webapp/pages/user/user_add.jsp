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
        <li>子用户添加</li></ul>
     </div>
   <!-- 导航菜单end -->
  <div class="form"> 
    <div class="tinput">  
     <div class="tbody" >
        <form action="${ctx}/user/addUser?" method="post" id="zcForm" encType="multipart/form-data">   
            <table  class="tviewbodyO"  cellSpacing="1"  cellPadding="0"  width="100%"  align="center"  border="0" >
                <tr >
                    <td  class="tabletitleO" >用户名：</td>
                    <td  class="tabletxtO" >
                       <input type="text" name="name" id="name"/>
                    </td>                                    
                </tr>          
                 <tr >
                    <td  class="tabletitleO" >密码：</td>
                    <td  class="tabletxtO" >
                       <input type="password" name="pwd" id="pwd"/>
                    </td>                                    
                </tr>
                <tr >
                    <td  class="tabletitleO" >真实姓名：</td>
                    <td  class="tabletxtO" >
                       <input type="text" name="truename" id="truename"/>
                    </td>                                    
                </tr>   
                <tr >
                    <td  class="tabletitleO" >性别：</td>
                    <td  class="tabletxtO" >
                       <input type="radio" name="sex" value="0"/>女&nbsp;<input type="radio" name="sex" value="1"/>男
                    </td>                                    
                </tr>   
            </table>        
            <table cellspacing=0 cellpadding=0 width="100%" align=center border=0 class="btnbar">
               <tr>
                 <td class="btnbarL"></td>
                 <td class="btnbarC"><input type="submit" class="button" value="提交" >
                &nbsp;<input type="button" class="button" value="返回" onclick="goBack()"></td>
                 <td class="btnbarR"></td>
               </tr>
            </table>            
        </form>
     </div>
  </div>
   </div>   
 </div>
</div>
<%@ include file="../common/footer.jsp"%>
