/**
 * @author Jonas
 */
function printUrl(reportId, companyId, parameter) {
	if (reportId != null && reportId != "" && companyId != null
			&& companyId != "") {
		var host = window.location.host;
		var url = "http://" + host + "/ureport?action=htmlprint&report=db:"
				+ reportId + "-" + companyId + "&fileName=ureport";
		if (parameter != null) {
			url = url + "&" + parameter;
		}
		var printeratn = new dorado.widget.AjaxAction({
			service:"bdf2.reportMaintain#queryPrinter",
			async:false
		});
		printeratn.set("parameter",reportId).execute(function(returnValue){
			if(returnValue){
				url += "&"+"intPrinterIndex="+returnValue;
			}else{
				url += "&"+"intPrinterIndex="+0;
			}
		});
		url = url
				+ "&__spring_security_scpf_applied=true&__spring_security_session_mgmt_filter_applied=true&__spring_security_filterSecurityInterceptor_filterApplied=true";
		return url;

	} else {
		dorado.MessageBox.alert("打印模板ID和所属公司名称定义错误!");
	}
}

// 防止多页面多开情况
function openTabControlVal(caption) {
	var flag = true;
	var tabControl = window.parent.$id("tabControlWorkarea").objects[0];
	var tabs = tabControl.get("tabs");
	tabs.each(function(tab) {
		if (tab.get("caption") == caption) {
			dorado.MessageBox.alert("不允许同一页面多开！");
			flag = false;
			return flag;
		}
	});
	return flag;
}