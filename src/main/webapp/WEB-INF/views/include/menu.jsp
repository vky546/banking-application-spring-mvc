<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>



<s:url var="url_logout" value="/logout"/>
<%-- <s:url var="url_reg_form" value="/reg_form"/> --%>
<%-- <c:if test="${sessionScope.userId==null}"> --%>
<%-- Guest User no one is logged in --%>
<a href="#">Home</a>       |       <a href='<s:url value="/About"></s:url>'>About</a>      |       <a href='<s:url value="/Contact"></s:url>'>Contact Us</a>

