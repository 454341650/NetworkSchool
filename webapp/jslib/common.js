/*共用方法*/
/**
 * 全选
 * @param name
 * @return
 */
function selectAll(name)
{
	var check=document.getElementsByName(name);
	for(var i=0;i<check.length;i++)
	{
		if(check[i].checked)
		{
			check[i].checked=false;
		}else{
		    check[i].checked=true;
		}
	}
}

//判断是否为大于0的正整数
function isPositiveInteger(str)
{
	var reg = /^[1-9]*[1-9][0-9]*$/;
	return reg.test(str);	
}
//判断是否是大于0的小数 ，两位小数
function isPositiveDouble2(str)
{
	var reg1=/^[0-9]+\.?[0-9]{0,2}$/; 
	return reg1.test(str);
	
}
function updateID(url,alertMsg){
	 if(confirm(alertMsg)){
         location.href=url;
     }
}
function checkNum(){//之允许输入数字
    if (event.keyCode<48 || event.keyCode>57){
       event.keyCode=0;
    }
}

//数组去重复
function mergeArray(arr1, arr2) {
	 var _arr = [];
	 for (var i = 0; i < arr1.length; i++) {
	  _arr.push(arr1[i]);
	 }
	 var _dup;
	 for (var i = 0; i < arr2.length; i++){
	  _dup = false;
	  for (var _i = 0; _i < arr1.length; _i++){
	   if (arr2[i] === arr1[_i]){
	    _dup = true;
	    break;
	   }
	  }
	  if (!_dup){
	   _arr.push(arr2[i]);
	  }
	 }
	 return _arr;
	}

/*
	选择部门 
	调用格式
	<div id="dept" ></div>							指定id = "dept"
	<a href="javascript:selectDept()()">选择部门</a>
	<input id="departmentCode" type="text"/>        指定id = departmentCode ,接收返回选中的部门code

*/
function selectDept() {
		$('#dept').colorbox({
			href : web_url+'/pages/common/dept.jsp',
			iframe:true, 
			title:'选择部门',
			width:700, 
			height:400,
			opacity:0.7,
			overlayClose:false
		});
		$('#dept').click();
}

function selectAlltype(t,obj) {
		switch(t)
		{
			case 0: title = "选择产品类型";break;
			case 1: title = "选择OTC类型";break;
			case 2: title = "选择采购商类型";break;
			default: title = "选择产品类型";break;
		}
		$(obj).colorbox({
			href : web_url+'/pages/common/type.jsp?t='+t,
			iframe:true, 
			title:title,
			width:400, 
			height:600,
			opacity:0.7,
			overlayClose:false
		});
		$(obj).click();
}
	
function closeColorbox()
{
	$.fn.colorbox.close();
}


/****选择部门结束****/


/**人员自动提示

调用：
	<input id="salesman" type="text" /> 指定id="salesman"

***/
function formatItem(item) {
	return item.salesman + " (" + item.szm + ")";
	//return item.salesman;
}
function formatResult(item) {
	var str = item.salesman.replace(/[,'"]/g,"");
	return str;
}

function gotAutocomplete()
{
	$("div.ac_results").remove();
	$("#salesman").autocomplete(web_url+'/staff/doSalesmanList', {
		width: 300,
		max:20,//最多20条记录
		cacheLength:20,  
		multiple: false,
		matchContains: true,
		dataType:'text',
		extraParams:{szm:function(){return encodeURIComponent($('#salesman').val());}},
		parse:function(data){
	        var parsed = [];  
	        var ret = eval("("+data+")").dwBaseSalemanList;
	        $.each(ret,function(i){
	        	 parsed[i] = {  
	                    data: ret[i],  
	                    value: ret[i],  
	                    result: ret[i].salesman //返回的结果显示内容  
	            };  
	        });
	        return parsed;
	     },
		//formatResult: formatResult,
		formatItem: formatItem
	
	});
}

/****人员自动提示结束***/
//去前后空格
String.prototype.Trim = function() {
    return this.replace(/(^\s*)|(\s*$)/g, "");
}
//去左空格
String.prototype.LTrim = function() {
    return this.replace(/(^\s*)/g, "");
}
//去右空格
String.prototype.RTrim = function() {
    return this.replace(/(\s*$)/g, "");
}
//去除所有空格
function strTrim(str,is_global) 
{ 
	var result; 
	result = str.replace(/(^\s+)|(\s+$)/g,""); 
	if(is_global.toLowerCase()=="g") 
	result = result.replace(/\s/g,""); 
	return result; 
} 

//当前时间 2013-1-29
function getCurrentDate()
{
	var dateTime = new Date();          
	var yy = dateTime.getFullYear();
	var MM = dateTime.getMonth()+1;
	var dd = dateTime.getDate();
	var now = yy+'-'+MM+'-'+dd;
	return now;
}
//当前年份 2013
function getCurrentYear()
{
	var dateTime = new Date();          
	var yy = dateTime.getFullYear();
	return yy;
}

//去除金额格式千分位读号
function replaceStr(str){
   return str.replace(/,/g,"");
}


//千分位格式
function commafy(num){
   var pointIndex = 0;
   var intPart = 0;
   var pointPart = 0;
   
   if((num+"").Trim()==""){
      return"";
   }
   if(isNaN(num)){
      return"";
   }
   num = num+"";
   if(/^.*\..*$/.test(num)){
      pointIndex = num.lastIndexOf(".");
      intPart = num.substring(0,pointIndex);
      pointPart = num.substring(pointIndex+1,num.length);
      intPart = intPart +"";
       var re =/(-?\d+)(\d{3})/
       while(re.test(intPart)){
          intPart =intPart.replace(re,"$1,$2")
       }
      num = intPart+"."+pointPart;
   }else{
      num = num +"";
       var re =/(-?\d+)(\d{3})/
       while(re.test(num)){
          num =num.replace(re,"$1,$2")
       }
   }
    return num;
}

//获取指定table位置数据
function getTableCellText(tableId,rowNumber,cellNumber){
    var re =  $("#"+tableId+" tr").eq(rowNumber).find("td").eq(cellNumber).text();
    return re;

}

/**
 * 
 * js自定义分布. 
 *count:总记录数 pageStep:每页显示多少个 pageNum:第几页 fnGo:分页跳转函数 
 *
 */
var jsPage = function(count, pageStep, pageNum, fnGo) {
	this.getLink = function(fnGo, index, pageNum, text) {
		var s = '';
		text = text || index;
		if(index == pageNum) {
			s += '<a style="text-decoration: none" class="jsPageACur" ';
			s += '><font color=White>' + text + '</font></a> ';	
		}else{
		    s += '<a style="text-decoration: none" href="#p' + index + '" onclick="' + fnGo + '(' + index + ');" class="jsPage" ';
		    s += '>' + text + '</a> ';	
		}
		
		return s;
	}
	//总页数
	var pageNumAll = Math.ceil(count / pageStep);
	if (pageNumAll == 1) {
		return '<span class="jsPageNo">上一页</span><a style="text-decoration: none" class="jsPageACur"><font color=White>1</font></a><span class="jsPageNo">下一页</span>';
	}
	var itemNum = 5; //当前页左右两边显示个数
	pageNum = Math.max(pageNum, 1);
	pageNum = Math.min(pageNum, pageNumAll);
	var s = '';
	if (pageNum > 1) {
		s += this.getLink(fnGo, pageNum-1, pageNum, '上一页');
	} else {
		s += '<span class="jsPageNo">上一页</span> ';
	}
	var begin = 1;
	if (pageNum - itemNum > 1) {
		s += this.getLink(fnGo, 1, pageNum) + '... ';
		begin = pageNum - itemNum;
	}
	var end = Math.min(pageNumAll, begin + itemNum*2);
	if(end == pageNumAll - 1){
		end = pageNumAll;
	}
	for (var i = begin; i <= end; i++) {
		s += this.getLink(fnGo, i, pageNum);
	}
	if (end < pageNumAll) {
		s += '... ' + this.getLink(fnGo, pageNumAll, pageNum);
	}
	if (pageNum < pageNumAll) {
		s += this.getLink(fnGo, pageNum+1, pageNum, '下一页');
	} else {
		s += '<span class="jsPageNo">下一页</span> ';
	}
	return s;
}
//修改colorBox弹出窗口的标题样式
function showTitle(title){
	$('#cboxTopLeft').css({'height':'30px','repeat':''})
	$('#cboxTopCenter').css({'text-align':'center','height':'30px'})
		.html("<div style='font-size: 18px;padding-top: 12px;'>"+title+"</div><span onclick='javascript:jQuery().colorbox.close();' style='position: absolute;right: 15px;top: 12px;background: url(/style/manager/images/ico_close_16.gif) no-repeat 0px 0px;width: 23px;height: 23px;text-indent: -9999px'>关闭</span>");
	$('#cboxTopRight').css({'':'','height':'30px'});
	$('#cboxClose').remove();
	$('#cboxBottomLeft').css({'height':'10px','background':'url(/jslib/colorbox/images/controls.png) no-repeat 0 -65px'});
	$('#cboxBottomCenter').css({'height':'10px','background':'url(/jslib/colorbox/images/bottom.png) repeat-x bottom left'});
	$('#cboxBottomRight').css({'height':'10px','background':'url(/jslib/colorbox/images/controls.png) -36px -65px'});
};
/*输出自定义格式时间 20120101--2012年01月01日*/
var formatDateStyle = function(date){
	date = date.replace(/^(\s|\u00A0)+/,'').replace(/(\s|\u00A0)+$/,'');
	if(date != null && date != ""){
		if(date.length == 4){
			return date+"年";
		}else if(date.length == 5){
			return date.substring(0,4)+"年第"+date.substring(4,5)+"季度";
		}else if(date.length == 6){
			return date.substring(0,4)+"年"+date.substring(4,6)+"月";
		}else if(date.length == 8){
			return date.substring(0,4)+"年"+date.substring(4,6)+"月"+date.substring(6,8)+"日";
		}
	}else{
		return "";
	}
};