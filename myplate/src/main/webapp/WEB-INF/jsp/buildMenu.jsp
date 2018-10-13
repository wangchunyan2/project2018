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
<%@ include file="common.jsp" %>
<c:set var="webcontext" value="${pageContext.request.contextPath}" />
<%-- <link type="text/css" rel="stylesheet" href="${webcontext}/css/common.css"></link> --%>
<link type="text/css" rel="stylesheet" href="${webcontext}/css/jquery.bxslider.css"></link>
<script type="text/javascript" src="${webcontext}/js/jquery.min.js"></script>
<script type="text/javascript" src="${webcontext}/js/jquery.bxslider.js"></script>
<script type="text/javascript">
$(function(){ 
	  $('.slider1').bxSlider({
         	mode:'horizontal',
           auto:true,
           pager:true,
           autoControls: true,
           pause: 2000
         });
});
</script>
<style type="text/css">
.buildMenuCon{
overflow: hidden;
margin-top: 40px;
}
 .slider1 img{
 width: 100%;
 }
</style>
<title>膳食营养评价系统myplate</title>
</head>
<body>
 <div class="container buildMenuCon">
	  <div class="main_banner">
        <ul class="slider1">
            <li><img src="${webcontext}/image/diet.png" /></li>
            <li><img src="${webcontext}/image/diet5.jpg" /></li>
        </ul>
    </div>
 </div>
</body>
</html>