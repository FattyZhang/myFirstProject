function bindGetDate(url , bindForm , showDispBtn){
	$.get(url,function(data,status){
		if ('success' == status){
			var list = $("#" + bindForm+ " input");
			obj = $("#" + bindForm+ " select");
			for(var i =0; i<obj.length;i++)
				list.push(obj[i]);
			obj = $("#" + bindForm+ " textarea");
			for(var i =0; i<obj.length;i++)
				list.push(obj[i]);					
			bindFormDate(list , data);
			document.getElementById(showDispBtn).click();
		}
	  });
}
function bindGetListDate(url , bindForm , showDispBtn , objName , objValue){
	$.get(url,function(data,status){
		if ('success' == status){
			var list = $("#" + bindForm+ " input");
			obj = $("#" + bindForm+ " select");
			for(var i =0; i<obj.length;i++)
				list.push(obj[i]);
			obj = $("#" + bindForm+ " textarea");
			for(var i =0; i<obj.length;i++)
				list.push(obj[i]);			
			
			bindFormDate(list , data);
			if (objName != undefined && bindForm[objName] != undefined)
				bindForm[objName].value = objValue;
			document.getElementById(showDispBtn).click();
		}
	  });
}
function bindFormDate(bindForm , data){
	for (var i = 0; i< bindForm.length;i++) {
		var tmp = data[bindForm[i].name];
		tmp = tmp == undefined ? '' : tmp;
		if (tmp == '' && bindForm[i].type == 'select-one')
		{
			bindForm[i].value = bindForm[i].options[0].value;
		}else{
			bindForm[i].value = tmp;
			if(i==1 && tmp.length > 0){
				bindForm[i].disabled = 'disabled';
			}
		}
	}
}
function createFormInput(type , name , value){
	var input = document.createElement("input");
	input.setAttribute('type',type);
	input.setAttribute('name', name);
	input.setAttribute('value', value);
	return input
}
function doCheck(obj , allCheckName)
{
	if (obj.checked){
		var o = $("input[name='ids']");
		var flag=true;
		for (var i=0;i<o.length;i++){
			if(o[i].checked == false){
				flag = false;
				break;
			}
		}
		document.getElementById(allCheckName).checked = flag;
	}else{
		document.getElementById(allCheckName).checked = false;
	}
}
function doCheckAll(obj , childName)
{
	var o =$("input[name='" + childName + "']"); 
	for (var i=0;i<o.length;i++){
		o[i].checked = obj.checked;
	}
}
function checkAddFormDate(url , bindForm){
	var date = bindForm.serialize();
	$.post(url,date ,function(data,status){
		if ('success' == status){
			if ('true' == data){
				//if(!window.confirm('该数据已经存在,是否要覆盖!'))
				alert('该数据已经存在,请通过编辑进入修改!');
				return;
			}
			bindForm.attr("onsubmit",'return true;');
			bindForm.submit();
		}else{
			alert('请求error!')
		}
	  });
}