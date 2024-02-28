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
    <h1>Welcome to Grit Academy!</h1><br>
</div>
<div class="centerIt">
    <p>We are glad you are here! Take a look around to learn more about our schools programs, faculty, and student life.</p><br>
    </div>
    <div class="centerIt">
    <p>Feel free to explore and discover what makes our school special. If you have any questions, do not hesitate to reach out. We are here to help!</p><br>
</div>

<%@ include file="fragments/footer.jsp" %>
</body>
</html>
