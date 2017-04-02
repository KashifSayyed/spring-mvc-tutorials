<%@ include file="include.jsp"%>
<%@ include file="Header.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.fundit.beans.ProjectBean" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>FundIT</title>
</head>
<body>
<table id="getProjectTable" class="">
    <thead>
        <tr>
            <th>Project ID</th>
            <th>Project Title</th>
            <th>Project Description</th>
            <th>Project Purpose</th>
            <th>Project Golbal Purpose</th>
            <th>Project Planned Finished Date</th>
            <th>Project Fund required</th>
            <th>Project Fund received</th>
            <th>User ID</th>                                  
        </tr>
    </thead>
    <tbody>
    		<% ProjectBean projects = (ProjectBean) request.getAttribute("projectBean"); %>
            <tr>
                <td><%= projects.getProject_id() %></td>
                <td><%= projects.getProject_title() %></td>
                <td><%= projects.getProject_description() %></td>
                <td><%= projects.getProject_purpose() %></td>
                <td><%= projects.getProject_global_business() %></td>
                <td><%= projects.getProject_planned_finish_date() %></td>
                <td><%= projects.getProject_fund_required() %></td>
                <td><%= projects.getProject_fund_received() %></td>
                <td><%= projects.getUser_id() %></td>                                                
            </tr>       
    </tbody>
</table>

</body>
</html>