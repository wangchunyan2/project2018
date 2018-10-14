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
<link type="text/css" rel="stylesheet" href="${webcontext}/css/nur_evaluate.css"></link>
<script type="text/javascript" src="${webcontext}/js/jquery.min.js"></script>

<title>食谱配置模块</title>
</head>
<body>
<div class="content">
<div class="content-detail">
<div class="content-top">
<div class="content-left">
	<div class="content-header">
		<h4 class="content-header-text">我的营养素摄入</h4>
	</div>
	<div class="content-meals">
		<div class="row">
			<div class="row-left">早餐摄入量：</div>
			<div class="row-center">
			<input type="text" class="content-input" id="breakfast">&nbsp;&nbsp;kcal</div>
		</div>
		
		<div class="row">
			<div class="row-left">午餐摄入量：</div>
			<div class="row-center">
			<input type="text" class="content-input" id="lunch">&nbsp;&nbsp;kcal</div>
		</div>
		
		<div class="row">
			<div class="row-left">晚餐摄入量：</div>
			<div class="row-center">
			<input type="text" class="content-input" id="dinner">&nbsp;&nbsp;kcal</div>
		</div>
		
		<div class="row">
			<div class="row-left">其&nbsp;&nbsp;&nbsp;&nbsp;他：</div>
			<div class="row-center">
			<input type="text" class="content-input" id="other">&nbsp;&nbsp;kcal</div>
		</div>
	</div>
		
	<div class="content-meals" style="height: 60px;">
		<input type="button" class="start-test" id="start-test" value="开始测评">
	</div>
</div>
<div class="content-right">
	<h4 class="content-header-text">部分食物热量表</h4>
	<table class="content-table">
	<tbody>
		<tr><td>食物<br>(100g)</td><td>热量<br>(千焦)</td><td>食物<br>(100g)</td><td>热量<br>(千焦)</td><td>食物<br>(100g)</td><td>热量<br>(千焦)</td></tr>
		<tr><td>米饭</td><td>125</td><td>豆浆</td><td>40</td><td>牛奶</td><td>70</td></tr>
		<tr><td>鲫鱼</td><td>120</td><td>鸡蛋</td><td>165</td><td>挂面</td><td>330</td></tr>
		<tr><td>河虾</td><td>75</td><td>海参</td><td>65</td><td>牛肉</td><td>300</td></tr>
		<tr><td>鸡肉</td><td>110</td><td>鸭肉</td><td>135</td><td>羊肉</td><td>305</td></tr>
		<tr><td>西红柿</td><td>30</td><td>辣椒</td><td>15</td><td>白菜</td><td>10</td></tr>
		<tr><td>香蕉</td><td>90</td><td>梨</td><td>40</td><td>桃</td><td>30</td></tr>
		<tr><td>酸奶</td><td>72</td><td>鸭蛋</td><td>180</td><td>香肠</td><td>508</td></tr>
		<tr><td>烤鸡</td><td>240</td><td>烤鸭</td><td>436</td><td>豆腐</td><td>81</td></tr>
	</tbody>
	</table>	
</div>
</div>
	<div class="content-below">
			<p class="test-result-message" style="margin-top: 70px;">&nbsp;&nbsp;&nbsp;您的膳食摄入总量较适宜，今日总能量摄入为
				<span id="result-kcal"></span>千卡。</p>
		<div class="test-result-graph">
			<div>
				<div class="test-result-graph-text">推荐摄入量<br>2400kcal</div>
			</div>
			<div class="test-result-progress">  
    		<span class="bar" id="bar"></span>  
 			</div> 
		</div>
	</div>
	
</div>
</div>
</body>
<script type="text/javascript">
$(function(){
	$("#start-test").click(function(){
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
            url: "${webcontext}/nutrEvaluate?breakfast="+breakfast+"&lunch="+lunch+"&dinner="+dinner+"&other="+other,
            dataType: "json",
            async:false,
            success: function(data){
                debugger
                console.info("营养配置调用成功！")
            	//渲染基础能量需求
            	//var bar = document.getElementById("bar");
        		//bar.style.setProperty('width','10%');
        		//$('#bar').html("10%"); 
            }
         });
	});
});
</script>
</html>