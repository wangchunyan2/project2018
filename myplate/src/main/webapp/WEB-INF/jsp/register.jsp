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

<title>myplate注册页面</title>
</head>
<body>
<div class="login_bgimg">
<img src="${webcontext}/image/login_bgimg.png"></div>
<div class="login">
<form action="" method="post" id="form_id">
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
		<li class="clearfix pb15">
			<div class="row">
				<label class="fl f14 pl5">确认密码：</label>
				<span class="db fl input_bg">
					<input type="password" name="comformPwd" id="comformPwd"></span>
			</div>
		</li>
	</ul> 
	<div class="mt10">
	<input type="submit" class="button mr10" id ="register" value="注册"> 
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
	$("#userName").blur(function(){
		var username = $("#userName").val();
		if(!username == null){
			 $('#emptyValidator').html("用户名不能为空！"); 
			 return;
		}
	});
	$("#password").blur(function(){
		var password = $("#password").val();
		if(!password){
			 $('#emptyValidator').html("密码不能为空！"); 
			 return false;
		}
	});
	$("#comformPwd").blur(function(){
		var comformPwd = $("#comformPwd").val();
		if(!comformPwd){
			$('#emptyValidator').html("确认密码不能为空！"); 
			 return false;
		}
	});
	
	$("#register").click(function(){
		var username = $("#userName").val();
		var password = $("#password").val();
		var comformPwd = $("#comformPwd").val();
		 if(!password){
			 $('#emptyValidator').html("密码不能为空！"); 
			 return false;
		}
		if(!comformPwd){
			 $('#emptyValidator').html("确认密码不能为空！"); 
			 return false;
		} 
		if(password != comformPwd){
			$('#emptyValidator').html("两次密码不一致！"); 
			 return false;
		}
		if(username == null){
			 $('#emptyValidator').html("用户名不能为空！"); 
			 return false;
		}
		$.ajax({
            type: "post",
            url: "${webcontext}/login/validateUser?username="+username,
            dataType: "json",
            async:false,
            success: function(data){
            	if(data){
            		console.log("success:"+data);
            		$("#form_id").attr("action","${webcontext}/login/register");
               		$("#form_id").submit();
            	}
           	 /* if(!data){
           		 $('#emptyValidator').html("用户已存在！"); 
           		 return false;
           	 }else if(data){
           		
           	 } */
            },
            error:function(data,type, err){
   	         console.log("ajax错误类型："+type);
   	         console.log(err);
            }
        });
	});
}); 
</script>
