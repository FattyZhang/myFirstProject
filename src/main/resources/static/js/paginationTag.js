function pageTag(value){
    var pageForm = document.getElementById("pageForm");
    document.getElementById("pageNum").value = value;	
	pageForm.submit();
}
function initPage(){
	var formId = document.getElementById("formId").value;
	var pageForm = document.getElementById("pageForm");
	var obj = $("#" + formId + " input");
	for (var i = 0; i< obj.length;i++) {
		pageForm.appendChild(createFormInput('hidden',obj[i].name,obj[i].value));
	}  
	obj = $("#" + formId + " select");
	for (var i = 0; i< obj.length;i++) {
		pageForm.appendChild(createFormInput('hidden',obj[i].name,obj[i].value));
	} 
}
initPage();