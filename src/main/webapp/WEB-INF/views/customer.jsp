<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Banking Application</title>
<link rel="stylesheet" href="/bankingapplication/resource/css/style.css">
</head>
<body>
<table border="1" width="80%" align="center">
  <tr>
    <td height="10px">
     <jsp:include page="include/header.jsp"></jsp:include>
    <%--header --%>
  </tr>
  <tr>
    <td height="25px">
    <%--Menu --%>
    <jsp:include page="include/menuLogout.jsp"></jsp:include>
    
  </tr>
  <tr>
    <td height="350px" valign="top">
    <%-- Main --%>
    <h2>Welcome! </h2>
<div class="customer_main">
<c:url var="balance" value="/showcustomerbalance"></c:url>
<form>
<button class="c_button" formaction="${balance}">Balance Enquiry</button>
</form>
<c:url var="balance" value="/showministatement"></c:url>
<form>
<button class="c_button" formaction="${balance}">Mini Statement</button>
</form>
<!-- <button class="c_button">Fund Transfer</button> -->
<!-- <button class="c_button">Mini Statement</button> -->
<!-- <button class="c_button">Customized Statement</button> -->
<button class="c_button">Change Password</button>
</div>

 <tr>
    <td height="10px">
    <%--Footer --%>
    <jsp:include page="include/footer.jsp"></jsp:include>
  </tr>
</body>
</html>

