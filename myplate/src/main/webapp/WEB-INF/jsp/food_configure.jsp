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
<link type="text/css" rel="stylesheet" href="${webcontext}/css/food_configure.css"></link>
<script type="text/javascript" src="${webcontext}/js/jquery.min.js"></script>

<title>膳食营养评价系统myplate</title>
</head>
<body>
<div class="content">
<div class="content-detail">
	<div class="content-header">
		<h4 class="content-header-text">请选择体力活力水平</h4>
	</div>
	<div class="content-container">
		<div class="row">
			<div class="row-col">
				<label class="row-label">
					<div class="row-label-radio">
					<input type="radio" value="1" name="power_level" id="power_level1">&nbsp;轻活力水平&nbsp;&nbsp;
					<img class="mt-tip-icon" style="width: 16px;height：16px;"src="${webcontext}/image/question.png">
					</div>
				</label>
			</div>
		</div>
		
		<div class="row" style="margin-top: 38px;margin-left: -120px;">
			<div class="row-col">
				<label class="row-label">
					<div class="row-label-radio">
					<input type="radio" value="1" name="power_level" id="power_level2">&nbsp;中活力水平&nbsp;&nbsp;
					<img class="mt-tip-icon" style="width: 16px;height：16px;"src="${webcontext}/image/question.png">
					</div>
				</label>
			</div>
		</div> 
		
		 <div class="row" style="margin-top: 76px;margin-left: -120px;">
			<div class="row-col">
				<label class="row-label">
					<div class="row-label-radio">
					<input type="radio" value="1" name="power_level" id="power_level3">&nbsp;重活力水平&nbsp;&nbsp;
					<img class="mt-tip-icon" style="width: 16px;height：16px;"src="${webcontext}/image/question.png">
					</div>
				</label>
				
			</div>
		</div>
		</div>
		
		<div class="content-header">
			<h4 class="content-header-text">基础能量需求</h4>
		</div>
	
		<div class="content-container" style="height: 160px;">
			<div class="row energy-row">
				<div class="row-left">基础代谢:</div>
				<div class="row-center">1478</div>
				<div class="row-right">kcal/day</div>
			</div>
			
			<div class="row energy-row">
				<div class="row-left">能量摄入水平(推荐):</div>
				<div class="row-center">1478</div>
				<div class="row-right">kcal</div>
			</div>
			
			<div class="row energy-row">
				<div class="row-left">早餐供能:</div>
				<div class="row-center">14</div>
				<div class="row-right">kcal</div>
			</div>
			
			<div class="row energy-row">
				<div class="row-left">午餐供能:</div>
				<div class="row-center">8</div>
				<div class="row-right">kcal</div>
			</div>
			
			<div class="row energy-row">
				<div class="row-left">晚餐供能:</div>
				<div class="row-center">147118</div>
				<div class="row-right">kcal</div>
			</div>
		</div>
		
		<div class="content-container">
			<input type="button" class="content-next" value="下一步">
		</div>
	
</div>

</div>
</body>
</html>