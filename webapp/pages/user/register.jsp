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
<div id="maincontent">
  <div id="maincontent_inner">
  <div class="form"> 
    <div class="tinput">  
     <div class="tbody" >
        <form action="${ctx}/user/register?" method="post" id="zcForm" encType="multipart/form-data">   
            <table  class="tviewbodyO"  cellSpacing="1"  cellPadding="0"  width="100%"  align="center"  border="0" >
                <tr >
                    <td  class="tabletitleO" >用户名：</td>
                    <td  class="tabletxtO" >
                       <input type="text" name="name" id="name"/>
                       <span id="info"></span>
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
<script type="text/javascript">
	function goBack() {
		location.href = "${ctx}/login.jsp";
	}
</script>
</body>
