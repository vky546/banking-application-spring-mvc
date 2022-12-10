<%@ page  contentType="text/html; charset=ISO-8859-1" 
    pageEncoding="ISO-8859-1"%>
  <%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
  <%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>  
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>  User Dashboard Conatct Application Using Spring MVC and JDBC Template</title>
<link rel="stylesheet" href="/bankingapplication/resource/css/style.css">
<!-- <script type="text/javascript" src="/capp/resource/js/script.js"></script>
 -->
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
    <jsp:include page="include/menu.jsp"></jsp:include>
    
  </tr>
  <tr>
    <td height="350px" valign="top">
    <%-- Main --%>
    <h2>User Login</h2>

    
 				<a href='<s:url value="/customerLogin"></s:url>'>Login as Customer</a>
				<br /> <br /> 
				<a href='<s:url value="/managerLogin"></s:url>'>Login as Manager</a> 
				<br /> <br /> 
				<a href='<s:url value="/newUserRegistration"></s:url>'>New User? click here</a>
 
 

    
  </tr>
  <tr>
    <td height="10px">
    <%--Footer --%>
    <jsp:include page="include/footer.jsp"></jsp:include>
  </tr>
 
 </table>
</body>
</html>