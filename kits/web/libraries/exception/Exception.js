dorado.beforeInit(function(){
  if(dorado.Exception){
	  
      dorado.Exception.alertException = function(e){
      	//dorado.MessageBox.alert("系统检测您的网络不稳定，已经自动连接到最近服务器，请刷新后重试！");
    	  if(e=="TypeError: Cannot read property '|<' of undefined" || e=="TypeError: Cannot read property 'push' of undefined"){
        	  dorado.MessageBox.alert("您的电脑分辨率较低，请切换到1366*768以上或缩放浏览器百分比再试！");
        	  return;
    	  }else if(e.indexOf("HTTP")>-1||e.indexOf("http")>-1){
    		  dorado.MessageBox.alert("您的网络出现异常，请检查网络后刷新页面！");
    		  return;
    	  }
    		  dorado.MessageBox.alert("加载异常，请重试或者联系系统管理员！");
      };
	  
	  function translateMessage(items, messages) {
          messages.each(function (message) {
              var item = dorado.Object.clone(message);
              if (item.entity && item.property) {
                  var pd = item.entity.getPropertyDef(item.property);
                  if (pd) {
                      item.propertyCaption = pd.get("label");
                  }
              }
              items.push(item);
          });
      }
	  
      dorado.widget.UpdateAction.alertException = function(e){
    	  var items = [], validateContext = e.validateContext;
          if (validateContext) {
              if (validateContext.error) {
                  translateMessage(items, validateContext.error);
              }
              if (validateContext.warn) {
                  translateMessage(items, validateContext.warn);
              }
          }
        var errorinfo = "\n";
        items.each(function(item){
        	var state = "";
        	if(item.state=="warn"){
        		state = "警告：";
        	}else if(item.state=="error"){
        		state = "错误：";
        	}
        	errorinfo += state + item.propertyCaption + " " +item.text + "\n";

        });
    	dorado.MessageBox.alert(e.message+"\n"+errorinfo,{title:"警告：",icon:"WARNING"});
      };
      
  }
});