<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.util.Calendar"%>
<%@ include file="../common/taglibs.jsp"%>
<html>
	<head>
		<title>网络商学苑</title>
		<meta http-equiv="content-type" content="text/html;charset=UTF-8">
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<link rel="shortcut icon" href="${ctx}/style/website/images/common/favicon.ico" />
		<script type="text/javascript" language="JavaScript"
			src="${ctx}/pages/main/js/main.js"></script>
		<link href="${ctx}/pages/main/css/sjck.css" rel="stylesheet"
			type="text/css" />
	</head>
	<body>
		<table width="100%" height="100%" cellSpacing="0" cellPadding="0"
			border="0">
			<tr>
				<td colspan="3">
					<iframe style="Z-INDEX:1;WIDTH:100%;HEIGHT:40px;VISIBILITY:inherit;border-bottom: 2px solid #4275b4"
						id="topFrame" src="${ctx}/pages/main/SysTop.jsp" name="topFrame"
						scrolling="no" frameBorder="0">
					</iframe>
				</td>
			</tr>
			<tr>
				<td id="frameTitle" height="100%" rowspan="2" width="197">
					<iframe
						style="Z-INDEX:2;WIDTH:197px;HEIGHT:100%;VISIBILITY:inherit;"
						id="leftFrame" src="${ctx}/pages/main/SysLeft.jsp" frameBorder="0"
						name="leftFrame" scrolling="yes">
					</iframe>
				</td>
				<td style="width:10px; overflow:hidden;" onclick="switchSysBar()"
					bgColor="#DEECF7" height="100%" rowspan="2" id="leftTitle"
					title="点击展开">
					<font
						style="font-FAMILY: Webdings; COLOR: #ffffff; font-SIZE: 10px; CURSOR: hand"><span
						id="switchPoint">3</span> </font>
				</td>
			</tr>
			<tr>
				<td height="100%">
					<iframe
						style="Z-INDEX: 4; WIDTH: 100%; HEIGHT: 100%; VISIBILITY: inherit"
						id="mainFrame" marginHeight="16"
						src="${ctx}/pages/main/SysView.jsp" frameBorder="0"
						name="mainFrame" marginWidth="16" scrolling="yes">
					</iframe>
				</td>
			</tr>
		</table>
	</body>
</html>
