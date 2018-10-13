<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="edge" />
<html>
<head>
<c:set var="webcontext" value="${pageContext.request.contextPath}" />
<link type="text/css" rel="stylesheet" href="${webcontext}/css/login.css"></link>
<script type="text/javascript" src="${webcontext}/js/jquery.min.js"></script>

<title>膳食营养评价系统myplate</title>
</head>
<body>
<div class="login_bgimg">
<img src="${webcontext}/image/login_bgimg.png"></div>
<div class="login">
<form action="${webcontext}/login/userLogin" method="post" id="form_id">
<div class="content" id="content">
	<div class="login_bg">
	<ul>
		<li style="visibility: visible;" id="emptyValidatorLi">
			<span id="emptyValidator"></span>
		</li>
		<li class="clearfix pb15">
		<div class="row">
			<label class="fl f14 pl5">账&nbsp;&nbsp;&nbsp;号：</label>
			<span class="db fl input_bg">
			<input type="text" name="userName" id="userName"></span>
		</div>
		</li>
		<li class="clearfix pb15">
			<div class="row">
				<label class="fl f14 pl5">密&nbsp;&nbsp;&nbsp;码：</label>
				<span class="db fl input_bg">
					<input type="password" name="password" id="password"></span>
			</div>
		</li>
		<li>${error_msg}</li>
	</ul> 
	<div class="mt10">
	<input type="submit" class="button mr10" id ="login" value="登录"> 
		<!-- <a class="button mr10" href="" id ="login">登&nbsp;录</a> -->
		<a class="" id="loginUrl" href="${webcontext}/login/toRegisterPage">注册</a>
	</div>
	</div>
</div>
</form>
<p class="copyright">版权所有 © 均衡营养评价系统.All right reserved</p>
</div>

</body>
</html>

<script type="text/javascript">
$(function(){
	 $("#login").click(function(){
		 var username = $("#userName").val();
			var pwd = $("#password").val();
			if(username.length == 0){
				$('#emptyValidator').html("用户名不能为空！");
				return false;
			}
			if(pwd.length == 0){
				$('#emptyValidator').html("密码不能为空！");
				return false;
			}
			$("#form_id").submit();
	});  
}); 
</script>
