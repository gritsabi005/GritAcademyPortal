<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<%@ include file="fragments/head.jsp" %>
<body>


<c:choose>
    <c:when test="${userBean.userType == 'student'}">
        <%@ include file="fragments/navbarStudent.jsp" %>
    </c:when>
    <c:when test="${userBean.userType == 'teacher'}">
    <c:choose>
    <c:when test="${userBean.privilageType == 'user'}">
        <%@ include file="fragments/navbarteacheruser.jsp" %>
    </c:when>
    <c:when test="${userBean.privilageType == 'admin' || userBean.privilageType == 'superadmin'}">
        <%@ include file="fragments/navbarAdmin.jsp" %>
    </c:when>
    </c:choose>
    </c:when>
    <c:otherwise>
        <%@ include file="fragments/navbar.jsp" %>
    </c:otherwise>
</c:choose>

<div class="centerIt">
<h1 style="text-align: center;">Courses</h1><br>
<p style="text-align: center;">Our courses are accreditated by The Swedish Ministry of Education and in line with European Standardized Curriculum</p>
</div>

<div class="centerIt">
<%@ include file="fragments/showingtable/showingTable.jsp" %>
</div>
<%@ include file="fragments/footer.jsp" %>

</body>
</html>