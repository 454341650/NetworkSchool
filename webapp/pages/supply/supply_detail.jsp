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
        <li>供求列表</li>
        <li>供求详情</li></ul>
     </div>
   <!-- 导航菜单end -->
  <div class="form"> 
    <div class="tinput">  
     <div class="tbody" >
        <form action="${ctx}/supply/findSupplyList?" method="post" id="zcForm">   
            <table  class="tviewbodyO"  cellSpacing="1"  cellPadding="0"  width="100%"  align="center"  border="0" >
                <tr >
                    <td  class="tabletitleO" >标题：</td>
                    <td  class="tabletxtO" >
                       <input type="text" name="title" id="title" value="${title}"/>
                    </td>                                    
                </tr>    
                 <tr >
                    <td  class="tabletitleO">按类别：</td>
                    <td  class="tabletxtO" >
                        <input type="text"  value="${title}">
                    </td>     		     
                </tr>    
                 <tr >
                    <td  class="tabletitleO" >标题：</td>
                    <td  class="tabletxtO" >
                       <input type="text" name="title" id="title" value="${title}"/>
                    </td>                                    
                </tr>    
                 <tr >
                    <td  class="tabletitleO">按类别：</td>
                    <td  class="tabletxtO" >
                        <input type="text"  value="${title}">
                    </td>     		     
                </tr>    
                 <tr >
                    <td  class="tabletitleO" >标题：</td>
                    <td  class="tabletxtO" >
                       <input type="text" name="title" id="title" value="${title}"/>
                    </td>                                    
                </tr>    
                 <tr >
                    <td  class="tabletitleO">按类别：</td>
                    <td  class="tabletxtO" >
                        <input type="text"  value="${title}">
                    </td>     		     
                </tr>    
                <tr >
                    <td  class="tabletitleO">按类别：</td>
                    <td  class="tabletxtO" >
                        <input type="text"  value="${title}">
                    </td>     		     
                </tr>   
                <tr >
                    <td  class="tabletitleO">备注：</td>
                    <td  class="tabletxtO" >
                        <textarea rows="5" ></textarea>
                    </td>     		     
                </tr>     
                 <tr >
                    <td  class="tabletitleO">详情：</td>
                    <td  class="tabletxtO" >
                        <textarea rows="20" ></textarea>
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
