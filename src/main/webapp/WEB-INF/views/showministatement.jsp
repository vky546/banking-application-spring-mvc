<%@page import="org.apache.jasper.compiler.NewlineReductionServletWriter"%>
<%@page import="java.util.List"%>
<%@page import="com.xoriant.bankingapplication.model.Transaction"%>
<%@page import="com.xoriant.bankingapplication.model.Account"%>
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
    <h2>Mini Statement</h2>


<div class="customer_balance" >
<% List<Transaction> transaction = (List<Transaction>)request.getAttribute("transaction"); 
for(Transaction trans: transaction){
out.println( "Transaction Id :" + trans.getTransactionId() + "  Date of Transaction : " + trans.getDateOfTransaction() + "  From Account : " + trans.getFromAccount() + "  To Account : " + trans.getToAcount() + "  Amount : " + trans.getAmount() + "  Current Balance :  " + trans.getCurrentBalance() + "  Transaction Status : " + trans.getTransactionStatus() );
}
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