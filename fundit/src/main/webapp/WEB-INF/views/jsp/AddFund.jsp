<%@include file="include.jsp"%>
<%@ include file="Header.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="utf-8">
	<title>FundIT - Add Funds</title>

<spring:url value="/resources/core/css/animate.css" var="coreCss" />
<spring:url value="/resources/core/css/style.css" var="bootstrapCss" />
<link href="${bootstrapCss}" rel="stylesheet" />
<link href="${coreCss}" rel="stylesheet" />

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
	
	<style>
	body{
	background: white !important;
	}
.login-box {
	max-width: 500px;
}	
	</style>
</head>

<body>
	<div class="container">
	
	

		<div class="login-box animated fadeInUp">
			<div class="box-header">
				<h2>Add Funds - <%= session.getAttribute("projectTitle") %></h2>
			</div>
		
		<form:form id="loginForm" method="post" action="/fund/add" modelAttribute="fundingBean">
			<form:label path="fund_added">Enter Amount in $</form:label>
			<form:input id="fund_added" name="fund_added" path="" required="required"/><br>
			<form:hidden path="project_id" />
			<input type="submit" value="Submit" id="addFundSubmit"/>
		</form:form>
<%
	if (request.getAttribute("message") != null) {
%>
<a><%=request.getAttribute("message")%></a>
<%
	}
%> 
		</div>
	</div>
</body>

<script>
	$(document).ready(function () {
    	$("input:text:visible:first").focus();
	});
	$('#fund_added').focus(function() {
		$('label[for="fund_added"]').addClass('selected');
	});
	$('#username').blur(function() {
		$('label[for="fund_added"]').removeClass('selected');
	});


</script>

</html>