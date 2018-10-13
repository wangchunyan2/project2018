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
<link type="text/css" rel="stylesheet" href="${webcontext}/css/bmi_test.css"></link>
<script type="text/javascript" src="${webcontext}/js/jquery.min.js"></script>
<title>膳食营养评价系统myplate</title>
</head>
<body>
<div class="content">
<div class="content-detail">
	 <div class="mt-intro-section center-block">
		<div class="pull-left">
		<img alt="" class="bmi_img" src="${webcontext}/image/icn_bmi.png"></div>
		<div class="text">BMI[Body Mass Index] 即BMI指数，也叫身体质量指数，是衡量是否肥胖和标准体重的重要指标。<br>
		适用范围：18至65岁的人士。儿童、发育中的青少年、孕妇、乳母、老人及身型健硕的运动员除外。<br>
		世界卫生组织认为BMI指数保持在22左右是比较理想的。<br></div>
	</div> 
	<div class="weight-height-block" style="margin-top: -24px; height: 61px;">
		<!-- 身高体重信息 -->
		<h4 class="mt-detail-header">身高体重信息</h4>
		<div class="mt-detail-content">
		<div class="row">
		<label>性别：</label>
		<label><input type="radio" name="sex" value="male" checked="checked">男</label>
		<label><input type="radio" name="sex" value="female">女</label>
		</div>
		<div class="row" style="margin-top:40px;margin-left: -133px;">
			<div>
				<label>身高:&nbsp;</label>
				<label><input type="text" name="height" id="height-input" class="input-text"></label>
				<label>&nbsp;cm</label>
				<label>&nbsp;&nbsp;&nbsp;&nbsp;体重:&nbsp;</label>
				<label><input type="text" name="weight" id="weight-input" class="input-text">&nbsp;kg</label>
			</div>
			<div class="mt-test"><input type="button" class="mt-test-button" id="test-button" value="测评"></div>
		</div>
		</div>
	</div>
	<!-- 测评结果 -->
	<div class="test-result">
		<h4 class="mt-detail-header">测评结果</h4>
		<div class="test-result-detail">
			<div class="test-result-row">
			<label>
				<div class="label-left">您的体重指数：</div>
				<div class="label-right"><span id="weight-index"></span></div>
			</label>
			</div>
			<div class="test-result-row">
			<label>
			<div class="label-left">您的体重情况：</div>
			<div class="label-right"><span id="weight-info"></span></div>
			</label></div>
			
			<div class="test-result-row">
			<label>
			<div class="label-left">您的理想体重：</div>
			<div class="label-right"><span id="ideal-weight"></span></div></label>
			</div>
			
		</div>
	</div>
	<!-- 评价标准 -->
	<div class="test-standar">
			<table class="table-bordered">
			 <thead>
		     	<tr><th colspan="2"><font color="#ff7f55">评价标准</font></th></tr>
		  	</thead>
		  	<tbody align="center">
				<tr><td>小于18.5</td><td>体重过低</td></tr>
				<tr><td>18.5~23.9</td><td>正常</td></tr>
				<tr><td>24.0~27.9</td><td>超重</td></tr>
				<tr><td>大于28</td><td>肥胖</td></tr>
		  	</tbody>
			</table>
	</div>
	<!-- <span>评价标准来自：中华人民共和国卫生行业标准，成人体重判定，2013。<br>
		理想体重参考：世界卫生组织(WHO)标准体重计算方法。</span> -->
	</div>
</div>
</body>
</html>
<script type="text/javascript">
$(function(){
	$("#test-button").click(function(){
		var height = $("#height-input").val().trim();
		var weight = $("#weight-input").val().trim();
		if(height=='' || weight==''){
			alert('身高体重不合法！');
			return;
		}
		
		var sex = $('input:radio:checked').val();
		var bmi= weight/(height/100*height/100);
		$('#weight-index').html(bmi.toFixed(2));
		if(bmi<18.5){
			$('#weight-info').html("体重过低");
		}else if(bmi>=18.5 && bmi<=23.9){
			$('#weight-info').html("正常");
		}else if(bmi>=24.0 && bmi<=27.9){
			$('#weight-info').html("超重");
		}else{
			$('#weight-info').html("肥胖");
		}
		if(sex=='male'){
			var idealWeight = (height-80)*0.7;
			$('#ideal-weight').html(idealWeight.toFixed(2));
		}else if(sex=='female'){
			var idealWeight = (height-80)*0.6;
			$('#ideal-weight').html(idealWeight.toFixed(2));
		}
		  
	});
	
});
</script>