<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<script type='text/javascript' src='${ctx}/jslib/swfobject.js'></script>
<html xmlns="http://www.w3.org/1999/xhtml" lang="en" xml:lang="en">
	<head>
		<title>SWFObject 2 static publishing example page</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8 />
		<script type='text/javascript' src='${ctx}/jslib/swfobject.js'></script>
		<script type="text/javascript">
		
		</script>
	</head>
	<body>
		<div>	
			<object id="myId" classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" width="800" height="820">
				<param name="movie" value="${ctx}${model.file_url}" />
        		<!--[if !IE]>-->
				<object type="application/x-shockwave-flash" data="${ctx}${model.file_url}" width="800" height="700">
				<!--<![endif]-->
				<div>
					<h1>Alternative content</h1>
					<p><a href="http://www.adobe.com/go/getflashplayer"><img src="http://www.adobe.com/images/shared/download_buttons/get_flash_player.gif" alt="Get Adobe Flash player" /></a></p>
				</div>
				<!--[if !IE]>-->
				</object>
				<!--<![endif]-->
			</object>
		</div>
	</body>
</html>