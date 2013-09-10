<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp"%>
<script type="text/javascript">
function goAdd(){
	location.href = "${ctx}/pages/user/user_add.jsp";
}
function goDel(id){
	if(confirm("确定要删除吗?")){
	document.getElementById("id").value=id;
    var delForm =  document.getElementById("delForm");
    delForm.submit();
	}
}
function viewDetail(id) {
	location.href = "${ctx}/user/findUser?id="+id;
};
function goUpdate(id) {
	location.href = "${ctx}/user/findUserForUpdate?id="+id;
};
</script>
<!-- 到详情页form,一下参数必填，这样才能返回保持住状态 -->
<form id="delForm" name="delForm" method="post" action="${ctx}/user/delUser?">
<input type="hidden" id="id" name="id"/>
</form>
<div id="maincontent">
  <div id="maincontent_inner">
   <!-- 导航菜单start -->
     <div class="title">
        <span class="titletxt">您现在的位置：</span>
        <ul><li class="root">首页</li>
        <li>子用户列表</li></ul>
     </div>
   <!-- 导航菜单end -->
  <div class="form"> 
    <!-- 查询框start -->
    <div class="tinput">  
     <table align=center border=0 cellSpacing=0 cellPadding=0 width="100%" class="ptitle">
         <tbody>
          <tr>
             <td class="ptitleL"></td>
             <td class="ptitleC"><span class="ptitletxt">条件查询</span></td>
             <td class="ptitleC" align="right"></td>
             <td class="ptitleR"></td>
          </tr>
         </tbody>
     </table> 
     <div class="tbody" >
        <form action="${ctx}/user/findUserList" method="post" id="searchForm">   
            <table  class="tviewbody"  cellSpacing="1"  cellPadding="0"  width="100%"  align="center"  border="0" >
                <tr >
                    <td  class="tabletitle" >用户名：</td>
                    <td  biddingCol="1"   class="tabletxt" >
                       <input type="text" name="name" id="name" value="${model.name}"/>
                    </td>                                    
                    <!-- <td  class="tabletitle" ></td>
                    <td  biddingCol="1"   class="tabletxt" >
                    </td>	 -->     
                </tr>    
            </table>        
            <table cellspacing=0 cellpadding=0 width="100%" align=center border=0 class="btnbar">
               <tr>
                 <td class="btnbarL"></td>
                 <td class="btnbarC"><input type="submit" class="button" value="查 询" >
                &nbsp;<input type="reset" class="button" value="重 置"></td>
                 <td class="btnbarR"></td>
               </tr>
            </table>            
        </form>
     </div>
  </div>
 <!-- 查询框end-->
   
  <!-- 列表start--> 
  <div class="tlist">    
     <table cellSpacing=0 cellPadding=0 width="100%" align=center border=0 class="ptitle">
         <tbody>
           <tr>
             <td class="ptitleL">&nbsp;</td>
             <td class="ptitleC"><span class="ptitletxt">查询结果显示</span></td>
             <td class="ptitleC" align=right></td>
             <td class="ptitleR"><a href="javascript:void(0)"><font color="#d16a4f">删除</font></a><a href="javascript:goAdd()"><font color="#d16a4f"> 新增</font></a></td>
           </tr>
         </tbody>
      </table>
      <div class="tbody">    
        <table id="L0"  class="tlistbody"  width="100%"  border="0"  align="center"  cellPadding="0"  cellSpacing="1"  id="L0"  >
            <thead>
            <tr  class="tablehead">
                 <th>ID</th>     
			     <th>用户名</th>
			     <th>真实姓名</th>
			     <th>最后登录时间</th>     
			     <th>操作</th>
            </tr>
            </thead>
            <tbody id="sale_data">           
                   <s:iterator value="recordList" status="stuts" >
                     <tr class="rowOdd" onMouseOver="this.className='rowHover'" onmouseout="this.className='rowOdd'">
							<td>${id}</td>
							<td>${name}</td>
							<td>${truename}</td>
							<td>${lastposttime}</td>
							<td>
								<a href="javascript:viewDetail('${id}')">详情</a>
								<a href="javascript:goUpdate('${id}')">编辑</a>
								<a href="javascript:goDel('${id}')">删除</a>
							</td>
					 </tr>
				   </s:iterator>
            </tbody>                 
        </table> 
        <!--翻页 begin-->
        <table class="pagenavigator" cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
            <tr>
                <td>
                   <%@ include file="../common/page.jsp"%>
                </td>
            </tr>
        </table>
        <!--翻页 end-->
     </div>
  </div>                    
  <!-- 列表end--> 
   </div>   
 </div>
</div>
<%@ include file="../common/footer.jsp"%>
