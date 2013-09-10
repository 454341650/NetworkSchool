<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<table width='100%' border='0' align='center' cellpadding='0' cellspacing='0'>
	<tr>
		<td align='right' id="jsPager2">
		<a href="" style='text-decoration: underline'></a>
		</td>
	</tr>
</table>
<%--<table width='100%' border='0' align='center' cellpadding='0' cellspacing='0'>
	<tr>
		<td align='right'>
		<!-- 共${page.totalRow}条,第(${page.currentPage}/${page.totalPage})页,每页${page.pageSize}条 -->
		<s:if test="currentPage - 1 >0">
		  <a href="${ctx}${pageUrl}&currentPage=1">&lt;&lt;首页</a>
		</s:if>
		<s:else>
		  <a href="javascript:void(0)">&lt;&lt;首页</a>
		</s:else>
	    <s:if test="currentPage - 1 >0">
		  <a href="${ctx}${pageUrl}&currentPage=<s:property value='currentPage - 1'/>">&lt;&lt;上一页</a>
		</s:if>
		<s:else>
		  <a href="javascript:void(0);">&lt;&lt;上一页</a>
		</s:else>

		<span style="font-size:12px;">&nbsp;&nbsp;页次 :${currentPage}/${totalPage}页 总记录共有${totalRow}条&nbsp;每页${pageSize}条&nbsp;</span>

        <s:if test="currentPage + 1 > totalPage">
		 <a href="javascript:void(0);">下一页&gt;</a>
		</s:if>
		<s:else>
		  <a href="${ctx}${pageUrl}&currentPage=<s:property value='currentPage + 1'/>">下一页&gt;</a>
		</s:else>
		
		<s:if test="currentPage + 1 > totalPage">
		 <a href="javascript:void(0);">末页&gt;&gt;</a>
		</s:if>
		<s:else>
		  <a href="${ctx}${pageUrl}&currentPage=<s:property value='totalPage'/>">末页&gt;&gt;</a>
		</s:else>
		<span style="font-size:12px;">
			&nbsp;&nbsp;跳至&nbsp;
			<input type="text" size="1" id="goCurrentPage"  class="text" style="height:15px" onkeyup="page_search_go()"/>&nbsp;页
			<a href='javascript:void(0)' onclick='page_search_go2()'>跳转</a>
		</span>
		</td>
	</tr>
</table>
--%><script>
function page_search_go(){
	if (window.event.keyCode==13){
		var currentPage=document.getElementById("goCurrentPage").value;
		if(currentPage!=""&&currentPage>0){
			window.location="${pageUrl}&currentPage="+currentPage;
		}
	}
}
function page_search_go2(){
		 var currentPage=document.getElementById("goCurrentPage").value;
		 if(currentPage!=""&&currentPage>0){
			 window.location="${pageUrl}&currentPage="+currentPage;
			 window.event.returnValue=false;
		 }
}
function goPage(currentPage){
  window.location="${pageUrl}&currentPage="+currentPage;
}
$(function(){
	var pageText = jsPage(${totalRow}, ${pageSize}, ${currentPage}, 'goPage')+"  共${totalRow}条数据";
	pageText+="&nbsp;&nbsp;跳转至第<input id='goCurrentPage' type='text' size='1' onkeyup='page_search_go()'/>页<a style='text-decoration: none' href='javascript:void(0)' onclick='page_search_go2()'>跳转</a>";
	$("#jsPager2").html(pageText);
	
	//document.getElementById("jsPager2").innerHTML = pageText;
});
</script>