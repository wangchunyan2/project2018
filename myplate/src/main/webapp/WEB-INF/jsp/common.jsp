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
<link type="text/css" rel="stylesheet" href="${webcontext}/css/common.css"></link>
<script type="text/javascript" src="${webcontext}/js/jquery.min.js"></script>

<title>膳食营养评价系统myplate</title>
</head>
<body>
<div class="top-container">
	<div class="top-right">
		<div><a class="" href="">登录</a><span>&nbsp;|&nbsp;</span><a class="" href="">注册</a></div>
	</div>
</div>
<div class="left-container">
	<div class="bg"><image class="img" src="${webcontext}/image/logo.png"></image></div>
	<div class="list">
		<ul>
		<li><a href="${webcontext}/buildMenu">首页</a></li>
		<li><a href="${webcontext}/toInforPage">用户信息</a></li>
		<li><a href="${webcontext}/toFoodConfPage">食谱配置</a></li>
		<li><a href="${webcontext}/toNutrEvaluatePage">营养评价</a></li>
		<li><a href="${webcontext}/toBmiTestPage">体质评测</a></li>
		<li><a href="${webcontext}/toKnowledgeExpanPage">知识拓展</a></li>
		</ul>
	</div>
</div>
<!-- <div class="footer">
<p>版权所有 © 均衡营养评价系统.All right reserved</p>
</div> --> 

</body>
</html>