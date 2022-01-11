<%@page import="com.bstek.bdf2.core.context.ContextHolder" %>
<%@page import="com.bstek.dorado.core.Configure" %>
<%@ page import="org.springframework.security.web.WebAttributes" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge">
    <title>用户登录</title>
    <%!
        private String getAuthenticationExceptionMessage() {
            Exception exp = (Exception) ContextHolder.getHttpSession().getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
            ContextHolder.getHttpSession().setAttribute(WebAttributes.AUTHENTICATION_EXCEPTION, null);
            if (exp == null) {
                exp = (Exception) ContextHolder.getRequest().getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
            }
            if (exp != null) {
                return exp.getMessage();
            }
            return null;
        }
    %>
    <%
        String errormessage = getAuthenticationExceptionMessage();
    %>
    <link rel="stylesheet" type="text/css" href="css/base.css">
    <link rel="stylesheet" type="text/css" href="css/styles.css">
    <link rel="stylesheet" type="text/css" href="css/newlogin.css"/>
    <script type="text/javascript" src="libraries/js/jquery-1.10.2.min.js"></script>
    <script type="text/javascript">
        function test() {
            document.getElementById("captchaImg").src = '<%=request.getContextPath()+Configure.getString("bdf2.generateCaptchaUrl")+Configure.getString("bdf2.controllerSuffix")%>?width=181&height=38&random=' + Math.random();
        }

        //设置cookie
        function setCookie(name, value, day) {
            var date = new Date();
            date.setDate(date.getDate() + day);
            document.cookie = name + '=' + value + ';expires=' + date;
        }

        //获取cookie
        function getCookie(name) {
            var reg = RegExp(name + '=([^;]+)');
            var arr = document.cookie.match(reg);
            if (arr) {
                return arr[1];
            } else {
                return '';
            }
        }

        var win_h = $(window).height();
        if (win_h < 800) {
            $(".login_main").css("margin-top", "362px");
        }
        var useCaptcha = "<%=Configure.getString("bdf2.useCaptchaForLogin")%>";
        window.checkForm = function () {
            var errorInfo = $("#errorInfo");
            var username = $("#usernamLe_").val();
            var password = $("#password_").val();
            var comp = $("#comp_list").val();
            setCookie('selComp', comp);
            if (username == "") {
                errorInfo.html("<span class=\"error\">用户名不能为空！</span>");
                $("#usernamLe_").focus();
                return false;
            } else {
                //setCookie('user',username);
            }s;
            if (password == "") {
                errorInfo.html("<span class=\"error\">密码不能为空！</span>");
                $("#password_").focus();
                return false;
            } else {
                //setCookie('pswd',password);
            }

        };
        $(document).ready(function () {
            var oUser = getCookie('user');
            var oPswd = getCookie('pswd');
            var comp = getCookie('selComp');
            $("#comp_list ").val(comp);
            //alert(oUser+"/"+oPswd);

            var error = "<%=errormessage%>";
            if (error && error != "" && error != "null" && error != null) {
                if (error == "Bad credentials") {
                    error = "用户名或密码不正确！";
                } else if (error == "验证码不正确" || error == "验证码过期" || error == "验证码不能为空") {
                    if (oUser && oUser != "" && oUser != null) {
                        $("#usernamLe_").val(oUser);
                    }
                    if (oPswd && oPswd != "" && oPswd && oPswd != "请输入您的密码" && oPswd != null) {
                        $("#password_").val(oPswd);
                        document.getElementById("password_").type = "password";
                    }
                } else if (error == "密码无效") {
                    if (oUser && oUser != "" && oUser != null) {
                        $("#usernamLe_").val(oUser);
                    }
                }
                $("#errorInfo").html("<span class=\"error\">" + error + "</span>");
            }
            if (useCaptcha == "true") {
                $("#captchaContainer").show();
            } else {
                $("#captchaContainer").hide();
            }
            $("#username_").focus();
        });


        var pwd = document.getElementById("password_");
        pwd.onfocus = function () {
            if (this.value == '请输入您的密码') {
                this.value = '';
                this.type = "password";
            }
        };
        pwd.onblur = function () {
            if (this.value == '') {
                this.value = '请输入您的密码';
                this.type = "text";
            }
        };
    </script>
</head>
<style type="text/css">
    body, html {
        width: 100%;
        height: 100%;
    }
</style>
<body style="overflow:hidden">
<table class="login_box_bg">
    <form name="loginForm" onsubmit="return checkForm()" method="post"
          action="<%=request.getContextPath()+Configure.getString("bdf2.loginProcessUrl")%>">
        <!--登录 -->

        <div class="login_box_bg">
            <div class="login_pic" ></div>

            <div class="login_box">
                <div class="login_main">
                    <!--错误时显示  显示时移除class "hide" -->
                    <div id="errorInfo">
                    </div>
                    <div id="errorInfos">
                        <div class="input_item item_1">
                            <input id="usernamLe_" tabindex="1" type="text" name="username_" class="login_1"
                                   value="请输入您的账号" title="用户名" onFocus="if(this.value=='请输入您的账号') this.value = ''"
                                   onBlur="if(this.value=='') this.value='请输入您的账号'"/>
                        </div>
                        <div class="input_item item_2">
                            <input id="password_" tabindex="2" type="password" name="password_" class="login_1"
                                   value="请输入您的密码" title="密码"/>
                        </div>
                        <div class="input_item">
                            <input class="login_2" id="captcha_" name="captcha_" type="text" value="请输入验证码"
                                   onFocus="if(this.value=='请输入验证码') this.value = ''"
                                   onBlur="if(this.value=='') this.value='请输入验证码'"/>
                            <img id="captchaImg" onclick="test()"
                                 src="<%=request.getContextPath()+Configure.getString("bdf2.generateCaptchaUrl")+Configure.getString("bdf2.controllerSuffix")+"?width=181&height=38"%>"/>
                        </div>

                        <div class="login_sub">
                            <input class="login_sub_1" name="btn_Login" type="submit" value="确认"/>
                            <input class="login_sub_2" name="" type="reset" value="取消"/>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </form>
</table>


</body>

</html>