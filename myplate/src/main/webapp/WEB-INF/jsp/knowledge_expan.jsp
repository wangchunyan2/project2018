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
<link type="text/css" rel="stylesheet" href="${webcontext}/css/knowledge_expan.css"></link>
<script type="text/javascript" src="${webcontext}/js/jquery.min.js"></script>

<title>膳食营养评价系统myplate</title>
</head>
<body>
<div class="content">
	<div class="content-bg">
		<h1 class="content-header"><font color="#ff7f55">合理膳食</font></h1>
		<div class="content-text">
			<p>&nbsp;&nbsp;&nbsp;&nbsp;成年人每日的食谱应包括奶类、肉类、蔬菜水果和五谷等四大类。奶类含钙、蛋白质等，可强健骨骼和牙齿，每日饮
			200毫升为宜。肉类、家禽、水产类如程海绿丹，绿色印象天然螺旋藻等、蛋类、豆及豆制品等，含丰富的蛋白质，可促
			进人体新陈代谢，增强抵抗力，每日4-6两为宜。蔬菜、水果类含丰富的矿物质、维生素和纤维素；增强人体抵抗力，
			畅通肠胃，每日最少应吃1斤。米、面等谷物主要含淀粉，即糖类物质主要为人体提供热能，满足日常活动所需，每日约5-8两为宜。
			饮食与健康的关系：饮食（又称“膳食”）是指我们通常所吃的食物和饮料。人们通过饮食获得所需要的各种营养素和能量，维护自身健康。
			基本前提是：营养的满足应该主要通过饮食来完成。食物能够提供对身体有益的一系统营养物质和其他合成物质。在某些特定情况下，
			强化食品和膳食补充物可能会帮助增加一种或多种仅靠一般饮食而摄入量不足的营养物质。然而，尽管在某些情况下会推荐膳食补充物，
			但它仍然不能代替健康的饮食。通过合理平衡的膳食和身体锻炼来改善人们的健康状况，减少主要慢性疾病的发病危险</p>
		</div>
		<div class="content-image">
			<img alt="" src="${webcontext}/image/knowledge.jpg">
		</div>
	</div>
</div>
</body>
</html>