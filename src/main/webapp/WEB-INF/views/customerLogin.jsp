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
<%--      <jsp:include page="include/header.jsp"></jsp:include> --%>
<!--     header -->
  </tr>
  <tr>
    <td height="25px">
    <%--Menu --%>
    <jsp:include page="include/menu.jsp"></jsp:include>
    
  </tr>
  <tr>
    <td height="350px" valign="top">
    <%-- Main --%>
    <h2>Customer Login</h2>
<%-- <jsp:include page="include/header.jsp"></jsp:include> --%>
<c:if test="${err!=null}">
 <p class="error">${err}</p>
</c:if>
<c:url var="user_url" value="/login"></c:url>
    <f:form action="${user_url}" modelAttribute="command">
     <table border="1" width="30%" align="center">
       <tr>
       
        <td>Username</td>
        <td><f:input path="loginName"/></td>
       </tr>
       <tr>
        <td>Password</td>
        <td><f:input path="password"/></td>
       </tr>
        <tr>
        <td colspan="2"><button>Login</button>
         <br/>
         <a href="#">New User Registration</a>
        </td>
       </tr>
     </table>
    
    </f:form>
	
	 </tr>
  <tr>
    <td height="10px">
    <%--Footer --%>
    <jsp:include page="include/footer.jsp"></jsp:include>
  </tr>
 

</table>


</body>
</html>


