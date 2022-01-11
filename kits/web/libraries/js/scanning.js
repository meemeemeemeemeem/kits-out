/**
 * @author Yaohuiqun
 */
function ChangeDiv(divId, divName, zDivCount) //divID --当前DIV的ID号；divName--要改变的这一组DIV的命名前缀；zDivCount --这一组DIV的个数-1,与SPAN相对应
{
	if(divId=='0'){
		document.getElementById("first").className="selected";
		document.getElementById("second").className="unSelected";
	}else if(divId=='1'){
		document.getElementById("second").className="selected";
		document.getElementById("first").className="unSelected";
	}
	
    for (i = 0; i <= zDivCount; i++) 
    {
        document.getElementById(divName + i).style.display = "none";
    }
    document.getElementById(divName + divId).style.display = "block";
//    console.log(divName + divId);
}
function getQueryString(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
	var r = window.location.search.substr(1).match(reg);
	if (r != null)
		return unescape(r[2]);
	return null;
}
var href = window.location.href;
var wayId = getQueryString("wayId");
var posturl = href.substring(0, href.lastIndexOf("/html"))
		+ "/app/waybillInfo/getScanWaybillRecord/{wayId:" + wayId + "}";
var posturlDetail = href.substring(0, href.lastIndexOf("/html"))
		+ "/app/waybillInfo/getScanWaybillDetail/{wayId:" + wayId + "}";
var posturlGoods = href.substring(0, href.lastIndexOf("/html"))
+ "/app/waybillInfo/getScanGoods/{wayId:" + wayId + "}";
var result, resultObj, rows, detail, detailObj, cydh, sfz, ddz, fhrmc, fhrdh, fhrdz, shrmc, shrdh, shrdz, hwmc, hwsl, zt, mdd,goods,goodsObj;
// 字符串转化成object
function toObject(a) {
	return (new Function('return ' + a))();
};
$.get(posturlGoods, function(data) {
	goods = JSON.stringify(data);
	goodsObj = toObject(goods).rows;
	var goodsNames='';
	var goodsPiece='';
	for (i = 0; i < goodsObj.length; i++) {
		if(i!=goodsObj.length-1){
			goodsNames+=goodsObj[i].GOODS_NAME+","
		}
		else{
			goodsNames+=goodsObj[i].GOODS_NAME;
		}
		goodsPiece+=goodsObj[i].PIECES;
	}
	$("#hwsl").text(goodsPiece+"件");
    $("#hwmc").text(goodsNames);
//	console.log(goodsObj);
});
$.get(posturl, function(data) {
	result = JSON.stringify(data);
	resultObj = toObject(result);
	rows = resultObj.rows;
//	console.log(rows);
	for (i = 0; i < rows.length; i++) {
		var a =new Date(rows[i].CREATE_DATE);
		var year = a.getFullYear();
	    var month = a.getMonth()+1;
	    var date = a.getDate();
	    var hour=a.getHours();
	    var minute=a.getMinutes();
	    var second=a.getSeconds();
	    var time=year+"-"+month+"-"+date+" "+hour+":"+minute+":"+second
		var b = data.rows[i].WAYBILL_NODE;
		var c = data.rows[i].BELONG_NAME;
		var d = data.rows[i].USER_NAME;
		if (i == 0) {
			$(".jindu").append(
					"<li class='first'><div class='time'>"
							+ "<span class='span_blue'>" + time + "</span> </div>"
							+ "<div class='tubiao'>" + "</div>"
							+ "<div class='txtblue'>【<span>" + b
							+ "</span>】操作部门：<span>" + c + "</span>，操作人：<span>"
							+ d + "</span></div></li>");
		} else {
			$(".jindu").append(
					"<li><div class='time'>" + "<span>" + time + "</span> </div>"
							+ "<div class='tubiao'>"
							+ "<div class='xian'></div>" + "</div>"
							+ "<div class='txt'>【<span>" + b
							+ "</span>】操作部门：<span>" + c + "</span>，操作人：<span>"
							+ d + "</span></div></li>");
		}
	}
});
$.get(posturlDetail, function(data) {
	detail = JSON.stringify(data);
	detailObj = toObject(detail).rows;
	cydh = detailObj.WAYBILL_NO;
	fhrmc = detailObj.SHIPPER;
	fhrdh = detailObj.SHIPPER_PHONE;
	fhrdz = detailObj.SHIPPER_ADDRESS;
	shrmc = detailObj.CONSIGNEE;
	shrdh = detailObj.CONSIGNEE_PHONE;
	shrdz = detailObj.CONSIGNEE_ADDRESS;
	sfz = detailObj.DEPARTURE_STATION;
	ddz = detailObj.DESTINATION_STATION;
	mdd = detailObj.DESTINATION_NAME;
	switch (detailObj.WAYBILL_STATUS) {
	case '0':
		zt = "已承运";
		break;
	case '1':
		zt = "已装车";
		break;
	case '2':
		zt = "在途中";
		break;
	case '3':
		zt = "已到站";
		break;
	case '4':
		zt = "已中转";
		break;
	case '5':
		zt = "送货中";
		break;
	case '6':
		zt = "已签收";
		break;
	case '7':
		zt = "异常";
		break;
	default:
		break;
	}
//	console.log(detailObj);
	/* hwmc=detaiObj. */
	if(cydh!=""&&cydh!=null){
		$("#cydh").text(cydh);
	}
	if(sfz!=""&&sfz!=null){
		$("#sfz").text(sfz);
	}
	if(zt!=""&&zt!=null){
		$("#zt").text(zt);
	}
	if(fhrmc!=""&&fhrmc!=null){
		$("#fhrmc").text(fhrmc);
	}
	if(fhrdh!=""&&fhrdh!=null){
		$("#fhrdh").text(fhrdh);
	}
	if(fhrdz!=""&&fhrdz!=null){
		$("#fhrdz").text(fhrdz);
	}
	if(shrmc!=""&&shrmc!=null){
		$("#shrmc").text(shrmc);
	}
	if(shrdh!=""&&shrdh!=null){
		$("#shrdh").text(shrdh);
	}
	if(shrdz!=""&&shrdz!=null){
		$("#shrdz").text(shrdz);
	}

	if (ddz != "" && mdd == "") {
		if(ddz!=null){
			$("#ddz").text(ddz);
		}
	} else if ((ddz == "" && mdd != "") || (ddz != "" && mdd != "")) {
		if(mdd!=null){
			$("#ddz").text(mdd);
		}
	}
})
