<%@page import="com.bstek.bdf2.core.context.ContextHolder"%>
<%@page import="com.bstek.dorado.core.Configure"%>
<%@page import="org.springframework.security.web.WebAttributes"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<title>用户登录</title>
<%!
	private String getAuthenticationExceptionMessage(){
	    Exception exp=(Exception)ContextHolder.getHttpSession().getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
	    if(exp==null){
	        exp=(Exception)ContextHolder.getRequest().getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
	    }
	    if(exp!=null){
	        return exp.getMessage();
	    }
	    return null;
	     
	}
%>
<%
	String errormessage = getAuthenticationExceptionMessage();
%>
<link rel="stylesheet" type="text/css" href="css/newlogin.css" />
<script type="text/javascript" src="libraries/js/jquery-1.10.2.min.js"></script>
<script type="text/javascript">

function myReload() {  
    document.getElementById("captcha_").src = document  
            .getElementById("captcha_").src;
}  
</script>
</head>
<body>
<table width="100%" height="100%">
		<tr height="100%" >
		<td width="80%">
		<img src="images/login/loginbg.jpg" height="100%" width="100%"/>
		</td>
		<td width="20%" valign="center">
<form name="loginForm"onsubmit="return checkForm()" method="post" action="<%=request.getContextPath()+Configure.getString("bdf2.loginProcessUrl")%>">
	<!--登录 -->
	<div>
		<!-- <img src="images/login/loginbg.jpg" alt="" class="loginbg">	 -->
		<!--<img src="images/login/fly.png" alt="" class="fly">		-->
		<!--<img src="images/login/word.png" alt="" class="word">-->
		<div>
		<div>
	        <div>
	        	
	            <div class="logo-box">
					<!--错误时显示  显示时移除class "hide" -->
					<div  id="errorInfo">
					</div>            
	                <input id="usernamLe_" tabindex="1"  type="text" name="username_" class="logo-user" placeholder="用户名" title="用户名">
	                <input id="password_" tabindex="2"  type="password" name="password_" class="logo-user" placeholder="密码" title="密码">
	                                                          验证码：<input type="text" name="captcha_" id = "captcha_" class="logo-user">
	                 <img  src="generate.captcha.action?width=150&height=60"><br>
	                  <a href="" onclick="myReload()" class="logo-user">看不清,换一个</a>
		            <!--  <div class="self-motion">
		             	<label><span style="float: left;">自动登录：</span><input type="checkbox" name="remember_me_" style="margin-top: 5px"></label>
		             </div> -->
		             <input type="submit" name="btn_Login" class="center" value="登&nbsp;&nbsp;&nbsp;录">
	            </div>
	    	</div>
	    	<!--	页面底部-->
			<div class="bottom"> 
				<a href="http://www.lucky56.com.cn/f" style="color: white;">Copyright © 2013-2017 云上贵州 
				<br>
				版权所有    ******        
				</a>
			</div>	
    	</div>

		</div>
	</div>
</form>
    	</td>
		</tr>
		</table>

<!--	右测悬浮-->
<!--/*浏览器不是谷歌或者火狐的样式*   显示时移除hide/-->
<div class="explorer-warp hide">
		<div class="warpbg"></div>
		<div class="close"></div>
		<div class="explorer">			
			<p>请使用以下浏览器进行访问 : </p>
			<div class="bgc">
				<a href="http://www.google.cn/chrome/browser/desktop/index.html" target="_blank">
					 <img src="images/login/chrome.jpg" alt="" >
					 <span>chrome</span>
				</a>
				<a href="http://rj.baidu.com/soft/detail/11843.html?ald" target="_blank">
					 <img src="images/login/firefox.jpg" alt="">
					 <span>Firefox</span>
				</a>
				<a href="http://rj.baidu.com/soft/detail/14917.html" target="_blank">
					 <img src="images/login/ie.jpg" alt="">
					 <span>ie8以上</span>
				</a>
			</div>
		</div>
</div>


<%-- <div class="bottom">
	版权所有&copy;信运通信息科技有限公司&nbsp;&nbsp;&nbsp;&nbsp;鄂ICP备13002219号&nbsp;&nbsp;&nbsp;&nbsp;客服电话：400-027-2456
	
<%
 		String ip = ToolKits.getIp();
		int lastIndex = ip.lastIndexOf(".");
		out.println("<label style='color:white;font-size:0.01px'>"+ip.substring(lastIndex+1)+"</label>"); 
	%>
</div> --%>
</body>
<script type="text/javascript">
var useCaptcha="<%=Configure.getString("bdf2.useCaptchaForLogin")%>";
window.checkForm=function(){
	var errorInfo=$("#errorInfo");
	var username=$("#usernamLe_").val();
	if(username==""){
		errorInfo.html("<span class=\"error\">用户名不能为空！</span>");
		$("#usernamLe_").focus();
		return false;
	}
	var password=$("#password_").val();
	if(password==""){
		errorInfo.html("<span class=\"error\">密码不能为空！</span>");
		$("#password_").focus();
		return false;
	}	
}
$(document).ready(function(){
	
	var error="<%=errormessage%>";
	if(error && error!="" && error!="null" && error != null){
		if(error=="Bad credentials"){
			error="用户名或密码不正确！";
		}/* 
		else{
			error="请检查您的用户名及密码！";
		}; */
		$("#errorInfo").html( "<span class=\"error\">" +error+ "</span>");
	}
	if(useCaptcha=="true"){
		$("#captchaContainer").show();
	}else{
		$("#captchaContainer").hide();
	}	
	$("#username_").focus();
});

window.resetPW = function(){
	window.open('bdf2.core.view.frame.ResetPW.d','重置密码',null);
// 	window.open('bdf2.core.view.frame.ResetPW.d','重置密码','height=140,width=435,top=50%,left=50%,toolbar=no,menubar=no,scrollbars=no, resizable=no,location=no, status=no');
}
</script>

<script>
// 打开网上营业厅登录窗口
function openReport() {  
   window.open("http://www.lucky56.com.cn/f?tn=hall");
} 
$(function(){
	$('.explorer-warp .close').click(function(){
		$('.explorer-warp').hide();
	})	
	$('.icon a').hover(function(){
			//移入第几个盒子,让第几个盒子显示出来		
			var num=$(this).index();
			$('.ewm div').eq(num).show().siblings().hide();
		},function(){
			$('.download').hide();
			//	$('.online-customer').hide()
	});
	$('.online-customer').mouseleave(function(){
		$(this).hide();
	});
	
		
	// 浏览器是谷歌\火狐\ie8+时，遮罩移除
	function warp(){
		$(".explorer-warp").addClass('hide');
	}
	// 浏览器是ie8—时，遮罩增加
	function addwarp(){
		$(".explorer-warp").removeClass('hide');
	}
	//点击删除，遮罩移除
	$(".close").click(function(){
		warp();
	});
	// 判断ie11
 	  var u = window.navigator.userAgent.toLocaleLowerCase(),
  	  ie11 = /(trident)\/([\d.]+)/,
  	  b = u.match(ie11);
 	  if(b){
		   warp();       
 	  }
	//判断当前浏览类型  
	   function BrowserType()  
	   {  
	      var userAgent = navigator.userAgent; //取得浏览器的userAgent字符串  
	      var isOpera = userAgent.indexOf("Opera") > -1; //判断是否Opera浏览器  
	      var isIE = userAgent.indexOf("compatible") > -1 && userAgent.indexOf("MSIE") > -1 && !isOpera; //判断是否IE浏览器  
	      var isEdge = userAgent.indexOf("Edge") > -1; //判断是否IE的Edge浏览器  
	      var isFF = userAgent.indexOf("Firefox") > -1; //判断是否Firefox浏览器  
	      var isSafari = userAgent.indexOf("Safari") > -1 && userAgent.indexOf("Chrome") == -1; //判断是否Safari浏览器  
	      var isChrome = userAgent.indexOf("Chrome") > -1 && userAgent.indexOf("Safari") > -1; //判断Chrome浏览器  
	  
	      if (isIE)   
	      {  
	           var reIE = new RegExp("MSIE (\\d+\\.\\d+);");  
	           reIE.test(userAgent);  
	           var fIEVersion = parseFloat(RegExp["$1"]);  
	           if(fIEVersion == 7){
	            	addwarp();
	        	}  
	           else if(fIEVersion == 8){
	            	addwarp();
	        	}  
	           else if(fIEVersion == 9){
	            	warp();
	        	}  
	           else if(fIEVersion == 10){
	            	warp();
	        	}   
	           else{
	           		addwarp();
	        	}  
	       }//isIE end  
	       
	       if (isFF) { 
	       		warp();
	       	}  
	       if (isOpera) {  
	       		addwarp();
	       	}  
	       if (isSafari) {  
	       		addwarp();
	       	}  
	       if (isChrome) { 
	       		warp();
	       	}  
	       if (isEdge) { 
	       		addwarp();
	       	}  
	   }//myBrowser() end  
	   
	   BrowserType();

	   
		
  	
	  // ie兼容placehoder
	   var JPlaceHolder = {
	    //检测
	    _check : function(){
	        return 'placeholder' in document.createElement('input');
	    },
	    //初始化
	    init : function(){
	        if(!this._check()){
	            this.fix();
	        }
	    },
	    //修复
	    fix : function(){
	        jQuery(':input[placeholder]').each(function(index, element) {
	            var self = $(this), txt = self.attr('placeholder');
	            self.wrap($('<div></div>').css({position:'relative', zoom:'1', border:'none', background:'none', padding:'none', margin:'none'}));
	            var pos = self.position(), paddingleft = self.css('padding-left');
	            var holder = $('<span></span>').text(txt).css({position:'absolute', left:pos.left, top:pos.top, height:'40px', lineHeight:'40px', paddingLeft:paddingleft, color:'#aaa'}).appendTo(self.parent());
	            self.focusin(function(e) {
	                holder.hide();
	            }).focusout(function(e) {
	                if(!self.val()){
	                    holder.show();
	                }
	            });
	            holder.click(function(e) {
	                holder.hide();
	                self.focus();
	            });
	        });
	    }
	};
	//执行
	jQuery(function(){
	    JPlaceHolder.init();    
	});
	   
	   
})  
</script>

</html>