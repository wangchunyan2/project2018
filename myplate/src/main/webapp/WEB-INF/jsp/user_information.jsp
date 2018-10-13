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
<%@ include file="common.jsp"%>
<c:set var="webcontext" value="${pageContext.request.contextPath}" />
<link type="text/css" rel="stylesheet" href="${webcontext}/css/user_information.css"></link>
<script type="text/javascript" src="${webcontext}/js/jquery.min.js"></script>

<title>myplate用户个人信息页面</title>
</head>
<body>
<div class="content">
	<div class="content-detail">
		<div class="content-information-header">
			<h4 class="content-information-header-text">个人信息</h4>
		</div>
		<form action="" method="post" id="form_id">
		<div class="content-information-container">
			<div class="row">
			<div class="row-label">
				<label class="content-name">昵称：</label>
				<label><input type="text" id="nickname" class="content-input"></label>
				<label class="content-lable"  style="margin-left: 100px;">性别：</label>
				<label class="content-lable">
				<input type="radio" name="sex" checked="checked" value="male">男</label>
				<label class="content-lable">
				<input type="radio"name="sex" value="female">女</label>
			</div>	
			</div>
			
			<div class="row" style="margin-top: 60px; margin-left: -459px;">
			<div class="row-label">
				<label class="content-height">身高：</label>
				<label><input type="text" id="bodyHeight" class="content-input"></label>&nbsp;cm
				<label class="content-weight"  style="margin-left: 69px;">体重：</label>
				<label><input type="text" id="bodyWeight" class="content-input"style="width: 70px;"></label>&nbsp;kg
			</div>	
			</div>
			
			<div class="row" style="margin-top: 112px; margin-left: -497px;">
			<div class="row-label">
				<label class="content-height">年龄：</label>
				<label><input type="text" id="age" class="content-input"></label>&nbsp;&nbsp;
			</div>	
			</div>
			
			<div class="test-button" style="padding: 135px 353px 35px 37px">
				<input type="submit" class="start-test" id="startTest" value="开始测评">
			</div>
			
		</div>
		</form>
	</div>
</div>
</body>
</html>

<script type="text/javascript">
    $(function(){
        $("#startTest").click(function(){
            var nickname = $("#nickname").val();
            var sex = $('input:radio:checked').val();
            var bodyHeight = $("#bodyHeight").val();
            var bodyWeight = $("#bodyWeight").val();
            var age = $("#age").val();
            $.ajax({
                type: "post",
                url: "${webcontext}/startBodyTest?nickname="+nickname+"&sex="+sex+"&bodyHeight="+bodyHeight+"&bodyWeight="+bodyWeight+"&age="+age,
                dataType: "json",
                async:false,
                success: function(data){
                    if(data){
                        $("#form_id").attr("action","${webcontext}/toFoodConfPage");
                        $("#form_id").submit();
                    }
                },
                error:function(data,type, err){
                    console.log("ajax错误类型："+type);
                    console.log(err);
                }
            });
        });
    });
</script>