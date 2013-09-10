
function switchSysBar() {
	if (switchPoint.innerText == 3) {
	    document.getElementById("leftTitle").title="点击展开左侧菜单";
		switchPoint.innerText = 4 ;
		document.all("frameTitle").style.display = "none";
	} else {
	    document.getElementById("leftTitle").title="点击收缩左侧菜单";
		switchPoint.innerText = 3;
		document.all("frameTitle").style.display = "";
	}
}

//菜单开关
function menuToggle(objId){
    var obj = document.getElementById(objId);
    if(obj.style.display=='none'){
       obj.style.display = "";
    }else{
       obj.style.display = "none";
    }
}