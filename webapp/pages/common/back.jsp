<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<script type="text/javascript">
function goBack(){
  document.getElementById("goBackForm").submit();
}
</script>
<!-- 专门用于执行返回操作的form，主要用于返回保持原有分页状态 -->
<form id="goBackForm"  method="post" action="${param.pageUrl}&currentPage=${param.currentPage}">
</form>