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
<link rel="stylesheet" href="/capp/resource/css/style.css">
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

    
   <c:if test="${err!=null}">
                        <p class="error">${err}</p>
                    </c:if>
                      <c:if test="${param.act eq 'lo'}">
                       <p class="success">Logout Successfully ! Thanks for using contact applciation</p>
                      </c:if>
    
    <c:url var="user_url" value="/newUserRegistration"></c:url> 
 
 
<%--     <f:form action='${user_url}' modelAttribute="command"> --%>
     <table border="1">
      <tr>
                        <td> Name</td>
                        <td><input type="text" name="fname" value="" /></td>
                    </tr>
                    <tr>
                        <td>phone</td>
                        <td><input type="text" name="phone" value="" /></td>
                    </tr>
                    <tr>
                        <td>Email</td>
                        <td><input type="text" name="email" value="" /></td>
                    </tr>
                    <tr>
                        <td>User Name</td>
                        <td><input type="text" name="uname" value="" /></td>
                    </tr>
                    <tr>
                        <td>Password</td>
                        <td><input type="password" name="pass" value="" /></td>
                    </tr>
          				<td><input type="submit" value="Submit" /></td>
           				<td><input type="reset" value="Reset" /></td>
                    </tr>
     </table>
    
<%--     </f:form> --%>
    
  </tr>
  <tr>
    <td height="10px">
    <%--Footer --%>
    <jsp:include page="include/footer.jsp"></jsp:include>
  </tr>
 
 </table>
</body>
</html>