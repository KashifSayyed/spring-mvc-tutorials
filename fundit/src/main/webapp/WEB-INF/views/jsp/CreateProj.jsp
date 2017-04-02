<%@ include file="Header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>FundIT - Create A Proposal</title>
<meta http-equiv="X-UA-Compatible"
	content="IE=EmulateIE7; IE=EmulateIE9">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no" />

<spring:url value="/resources/core/css/form_style.css" var="coreCss" />
<spring:url value="/resources/core/css/demo.css" var="bootstrapCss" />
<link href="${bootstrapCss}" rel="stylesheet" media="all" />
<link href="${coreCss}" rel="stylesheet" media="all" />

<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>

<style>
.headerStyle{
font-size: 19px !important;
font-weight: bold !important;
padding-top: 1% !important;
padding-bottom: 2% !important;
margin-left: 43% !important;
}
.classLink{
margin-left:38% !important;
font-size:22px !important;
font-weight:bold;
color: #665769 !important;
}
header{
padding-top: 1% !important;
}
</style>

</head>
<body>



<!--/ freshdesignweb top bar --> <header>
<%
	if (request.getAttribute("message") != null) {
%>
<a class="classLink"><%=request.getAttribute("message")%></a>
<%
	}
%> 
<h1 class="headerStyle">Create A Proposal</h1>
</header>
<div class="form"><form:form id="contactform" method="post"
	action="/project/add" modelAttribute="projectBean">
	<p class="contact"><label for="name">Title *</label></p>
	<form:input path="" id="project_title" name="project_title"
		placeholder="Please enter the title"
		title="Please enter the title" required="required" tabindex="1"
		type="text" />

	<p class="contact"><label for="projectDescription">Description *</label></p>
	<textarea rows="10" cols="60" name="project_description"
		id="project_description" required=""
		title="Please enter the brief descripion"
		id="projectDescription" tabindex="1"
		placeholder="Please enter the brief description (Maximum length is 500 charcters)"></textarea>

	<p></p>
	<label>Category *</label>
	<fieldset title="Please select a global business"><label
		class="Please select a purpose" required=""> <form:select
		class="select-style" name="project_purpose" path=""
		id="project_purpose" tabindex="1">
		<form:option value="">Please select a category</form:option>
		<form:option value="Business">Business</form:option>
		<form:option value="Technology">Technology</form:option>
		<form:option value="Operation">Operation</form:option>
		<form:option value="Regulatory Compliance">Regulatory Compliance</form:option></label> </form:select></fieldset>

	<p class="contact"></p>

	<label>Global business *</label>
	<fieldset title="Please select a global business"><label
		class="Please select a global business"> <form:select
		class="select-style" name="project_global_business"
		id="project_global_business" path="" tabindex="1">
		<form:option value="">Please select a global business</form:option>
		<form:option value="Investment">Investment</form:option>
		<form:option value="Private">Private</form:option>
		<form:option value="Commercial">Commercial</form:option>
		<form:option value="Retail">Retail</form:option></label> </form:select></fieldset>

	<p class="contact"></p>

	<form:label path="">Planned finished date *<span></span>
	</form:label>
	<form:input path="" class="birthday" type="text" 
		name="project_planned_finish_date" id="project_planned_finish_date"
		placeholder="mm/dd/yyyy" required="required" tabindex="1"
		title="Please enter the date in mm/dd/yyyy" />

	<p class="contact"><form:label for="projectFundRequired" path="">Total fund required (in $)</form:label></p>
	<form:input id="project_fund_required" name="project_fund_required"
		path="" placeholder="Please enter the amount"
		title="Please enter the fund required in dollars" tabindex="1"
		type="text" />

	<p class="contact"><form:label path="" for="projectMyFund">My funds(in $)</form:label></p>
	<form:input id="project_my_fund" name="project_my_fund"
		path="" placeholder="Please enter the amount"
		title="Please enter the funds you contribute in dollars" tabindex="1"
		type="text" />

	<p class="contact"></p>

	<input type="submit" value="Cancel"  tabindex="1"/>

	<input type="submit" value="Submit" tabindex="1"/>
</form:form></div>
</div>

</body>

<script>
	$(function() {
		$("#project_planned_finish_date").datepicker();
	});
</script>

</html>