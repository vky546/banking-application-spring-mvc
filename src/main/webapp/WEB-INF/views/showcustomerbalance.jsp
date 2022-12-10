<%@page import="com.xoriant.bankingapplication.model.Account"%>
<%@page import="com.xoriant.bankingapplication.model.Transaction"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
    <h2>Balance Enquiry</h2>

<!-- <div> -->
<%-- <jsp:include page="include/header.jsp"></jsp:include> --%>
<!-- </div> -->
<!-- <div> -->
<%-- <jsp:include page="include/menuLogout.jsp"></jsp:include> --%>
<!-- </div> -->

</div>
<% Account account  = (Account)request.getAttribute("account"); 

out.println( " Current Balance :  " + account.getCurrentBalance() );

%>

</div>

  </tr>
  <tr>
    <td height="10px">
    <%--Footer --%>
    <jsp:include page="include/footer.jsp"></jsp:include>
  </tr>

</body>
</html>