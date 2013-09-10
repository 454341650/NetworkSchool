<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp"%>
<script type="text/javascript">
function goAdd(){
	location.href="${ctx}/pages/courseware/coures_add.jsp";
}
function goDel(id){
	if(confirm("确定要删除吗?")){
	document.getElementById("id").value=id;
    var delForm =  document.getElementById("delForm");
    delForm.submit();
	}
}
function viewFalsh(thisObj,id) {
	jQuery(thisObj).colorbox({
		href : "${ctx}/fileUrl/findCoures?id="+id,
		iframe:true, 
		title:'详情',
		width:1000, 
		innerWidth: "100%",
		height:700,
		opacity:0.7,
		overlayClose:false
	});
};
function flashAdd(thisobj) {
	jQuery(thisobj).colorbox({
		href : "${ctx}/ckfinder/ckfinder.html",
		iframe:true, 
		title:'详情',
		width:1000, 
		innerWidth: "100%",
		height:700,
		opacity:0.7,
		onClosed: function(){window.location.href=window.location;},
		overlayClose:false
	});
};
/*
var finder = new CKFinder();
finder.basePath = '/ckfinder/';
finder.create();*/
</script>
<!-- 到详情页form,一下参数必填，这样才能返回保持住状态 -->
<form id="delForm" name="delForm" method="post" action="${ctx}/fileUrl/delCoures?">
<input type="hidden" id="id" name="id"/>
</form>
<div id="maincontent">
  <div id="maincontent_inner">
   <!-- 导航菜单start -->
     <div class="title">
        <span class="titletxt">您现在的位置：</span>
        <ul><li class="root">首页</li>
        <li>课件列表</li></ul>
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
        <form action="${ctx}/supply/findSupplyList" method="post" id="searchForm">   
            <table  class="tviewbody"  cellSpacing="1"  cellPadding="0"  width="100%"  align="center"  border="0" >
                <tr >
                    <td  class="tabletitle" >标题：</td>
                    <td  biddingCol="1"   class="tabletxt" >
                       <input type="text" name="title" id="title" value="${title}"/>
                    </td>                                    
                    <td  class="tabletitle" >按类别：</td>
                    <td  biddingCol="1"   class="tabletxt" >
                        <input type="text"  value="">
                    </td>     		     
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
             <td class="ptitleR"><a href="javascript:void(0)"><font color="#d16a4f">删除</font></a><a onclick="flashAdd(this)"><font color="#d16a4f"> 新增</font></a></td>
           </tr>
         </tbody>
      </table>
      <div class="tbody">    
        <table id="L0"  class="tlistbody"  width="100%"  border="0"  align="center"  cellPadding="0"  cellSpacing="1"  id="L0"  >
            <thead>
            <tr  class="tablehead">
                 <th>ID</th>     
			     <th>课件名称</th>
			     <th>创建时间</th>     
			     <th>操作</th>
            </tr>
            </thead>
            <tbody id="sale_data">           
                   <s:iterator value="recordList" status="stuts" >
                     <tr class="rowOdd" onMouseOver="this.className='rowHover'" onmouseout="this.className='rowOdd'">
							<td>${id}</td>
							<td><a onclick="flashAdd(this)">${course_name}</a></td>
							<td>${create_date}</td>
							<td>
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
