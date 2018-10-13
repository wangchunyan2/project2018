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
<%-- <%@ include file="common.jsp"%> --%>
<c:set var="webcontext" value="${pageContext.request.contextPath}" />
<link type="text/css" rel="stylesheet" href="${webcontext}/css/admin.css"></link>
<script type="text/javascript" src="${webcontext}/js/jquery.min.js"></script>


<title>膳食营养评价系统myplate</title>
</head>
<body style="background-color: #f3f3f3; margin: 0; padding: 0;">
<div class="content">
<div class="content-detail">
		<h1 class="content-header-text">我的膳食营养评价系统-后台管理页面</h1>
		<div class="content-search">
				<lable class="row-left">创建人：</lable>
				<input type="text" class="content-input">
				<lable class="row-center">性别：</lable>
				<select class="content-row-select" name="female"> 
					<option value="0">请选择</option> 
					<option value="1">男</option> 
					<option value="2">女</option> 
				</select> 
				<lable class="row-right">活力水平：</lable>
				<select class="content-row-select" name="power_level"> 
					<option value="0">请选择</option> 
					<option value="1">轻活力水平</option> 
					<option value="2">中活力水平</option> 
					<option value="3">重活力水平</option> 
				</select>
		</div>
		<div class="row">
				<input type="button" class="content-button" id="query" value="查询">
			</div>
	<div class="content-result">
		<table class="content-table" align="center">
		  <thead>
		     <tr>
		       <th>创建人</th>
		       <th>性别</th>
		       <th>身高</th>
		       <th>体重</th>
		       <th>活力水平</th>
		       <th>营养素摄入</th>
		     </tr>
		  </thead>
		  <tbody>
		   <tr align="center">
			<td>创建人</td><td>性别</td><td>身高</td><td>体重</td><td>活力水平</td><td>营养素摄入</td></tr>
		  </tbody>
		</table> 
	</div> 
</div>
</div>
</body>
<script type="text/javascript">
$(function(){
	$("#query").click(function(){
		var breakfast = $("#breakfast").val().trim();
		var lunch = $("#lunch").val().trim();
		var dinner = $("#dinner").val().trim();
		var other = $("#other").val().trim();
		if(breakfast=='' || lunch=='' || dinner=='' || other=='' ){
			alert('营养素摄入输入不合法！');
			return;
		}
		var kcal =  parseInt(breakfast)+parseInt(lunch)+parseInt(dinner)+parseInt(other);
		$('#result-kcal').html(kcal); 
		$.ajax({
            type: "post",
            url: "${webcontext}/XXX=",
            dataType: "json",
            async:false,
            success: function(data){
            	//渲染基础能量需求
            	//var bar = document.getElementById("bar");
        		//bar.style.setProperty('width','10%');
        		//$('#bar').html("10%"); 
            }
         });
	});
});
</html>