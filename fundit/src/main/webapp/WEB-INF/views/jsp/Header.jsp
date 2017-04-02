<%@include file="include.jsp"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html >
  <head>
    <meta charset="UTF-8">

    <style type="text/css">
    body {
	background-size: cover;
	font-size: 15px;
	font-family: 'Lato', sans-serif;
	font-weight: 300;
	margin: 0;
	color: #666;
}
    .linkShape1{
    width: 115px;
    height: 25px;
    background: #99cc33;
    padding: 8px;
    text-align: center;
    border-radius: 5px;
    color: white;
    font-weight: bold;
    margin-left: 18%!important;
    text-decoration:none;
    }
    
    .linkShape{
    width: 115px;
    height: 25px;
    background: #99cc33;
    padding: 8px;
    text-align: center;
    border-radius: 5px;
    color: white;
    font-weight: bold;
    margin-left: 1% !important;
    text-decoration:none;
    }
    .linkShapeButton{
    background-color: #99cc33;
    color: #fff;
    font-size: 16px;
    font-weight: bold;
    text-decoration:none;
    }
    .buttonShape{
    width: 115px;
    height: 25px;
    background: #777777;
    padding: 8px;
    text-align: center;
    border-radius: 5px;
    color: white;
    font-weight: bold;
    margin-left: 10% !important;
    text-decoration:none;
    }
    .textColor{
    font-size:20px;
    padding-bottom:10px;
    color: #4c4c4c;
    padding-top: 8px;
    }
    </style>
    
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
  </head>

  <body>
  <p></p>
  <p></p>
	<center class="textColor"> Welcome <b><%= request.getSession().getAttribute("loggedInUser") %></b> to FundIT</center>
<p></p>

  <img alt="" src="../resources/core/images/header_bg.jpg" class="">

  <a class="linkShape1" href="/home">Home</a>
  <a class="linkShape"href="/project">Create</a>
    
  <a class="linkShape" href="/project/all">Explore</a>
    
  <a class="linkShape" href="/dashboard">Dashboard</a>
  
  <a class="linkShape" class="linkShape" href="/howItWorks">How it works</a>  
  
  <a class="linkShape" href="/aboutus">About us</a>
   
   <a class="buttonShape" href="/auth/logoff">LogOut</a>



  </body>
</html>
