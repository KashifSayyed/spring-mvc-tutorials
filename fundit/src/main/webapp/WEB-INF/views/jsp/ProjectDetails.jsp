<%@ include file="include.jsp"%>
<%@ include file="Header.jsp"%>
<%@ page import="com.fundit.beans.ProjectBean"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Explore Projects</title>
<spring:url value="/resources/core/css/style_explore.css" var="coreCss" />
<link href="${coreCss}" rel="stylesheet" />

        <style>
.pricing-grid1,.pricing-grid2,.pricing-grid3 {
margin-left:15% !important;
width: 68% !important;
}
    </style>

</head>

<body>

<!--
Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE HTML>
<html>
<head>
<title>Explore Proposal</title>

<!-- Custom Theme files -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Pricing Tables Design ,Flat Pricing Tables Design ,Popup Pricing Tables Design,Clean Pricing Tables Design " ./>
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
</script>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<!--webfonts-->
<link
	href='http://fonts.googleapis.com/css?family=Lato:100,300,400,700,900,100italic,300italic,400italic,700italic'
	rel='stylesheet' type='text/css'>
<!--//webfonts-->
<spring:url value="/resources/core/js/jquery.colorbox.js" var="coreJs" />
<spring:url value="/resources/core/js/jquery.colorbox-min.js" var="bootstrapJs" />
 
<script src="${coreJs}"></script>
<script src="${bootstrapJs}"></script>

<spring:url value="/resources/core/css/colorbox.css" var="coreCss" />
<link href="${coreCss}" rel="stylesheet" />
</head>
<body>


<!--start-pricing-tablel-->


<script>
	$(document).ready(function() {
		$('.popup-with-zoom-anim').magnificPopup( {
			type : 'inline',
			fixedContentPos : false,
			fixedBgPos : true,
			overflowY : 'auto',
			closeBtnInside : true,
			preloader : false,
			midClick : true,
			removalDelay : 300,
			mainClass : 'my-mfp-zoom-in'
		});

		$(".popup-with-zoom-anim").colorbox();
	});
</script>
<div class="pricing-plans">
<div class="wrap">

<div class="pricing-grids">
<% ProjectBean projects = (ProjectBean) request.getAttribute("projectBean"); %>
<div class="pricing-grid1">
<div class="price-value">
<h2><a>Title: <%= projects.getProject_title() %></a></h2>
<div class="sale-box"><span class="on_sale title_shop">NEW</span>
</div>

</div>
<div class="price-bg">
<ul>
	<li class="whyt"><a href="#">Description : <%= projects.getProject_description() %> </a></li>
	<li class="whyt"><a href="#">Category : <%= projects.getProject_purpose() %></a></li>
	<li class="whyt"><a href="#">Global Business : <%= projects.getProject_global_business() %></a></li>
	<li class="whyt"><a href="#">Planned Finished Date: <%= projects.getProject_planned_finish_date() %></a></li>
	<li class="whyt"><a href="#">Fund Required: <%= projects.getProject_fund_required() %></a></li>
	<li class="whyt"><a href="#">Fund Received :<%= projects.getProject_fund_received() %></a></li>
	<li class="whyt"><a href="#">Owners Funds :<%= projects.getProject_my_fund() %></a></li>
	<li class="whyt"><a href="#">Proposal Submitted By : <%= projects.getUser_id() %></a></li>
</ul>
<div class="cart1"><a class="popup-with-zoom-anim"
	href="/fund/<%=projects.getProject_id() %>">Add Funds</a></div>
</div>
</div>

</div>
<div class="clear"></div>

</div>

</div>
<!--//End-pricingplans-->
<!-- /start-copyright-->
<div class="footer">
<div class="wrap">
<p>&copy; 2015 All rights Reserved &nbsp;<a href="#">FundIT</a></p>
</div>
</div>
<!--//End-copyright-->
</body>
</html>
</body>
</html>
