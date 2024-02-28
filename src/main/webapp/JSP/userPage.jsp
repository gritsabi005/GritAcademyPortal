<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<%@ include file="fragments/head.jsp" %>
<body>

<c:if test="${userBean.userType == 'student'}">
    <%@ include file="fragments/navbarStudent.jsp" %>
    <%@ include file="fragments/studentUserPage.jsp" %>
</c:if>
<c:if test="${userBean.userType == 'teacher'}">

    <%-- make a choose statement to switch which privilege and their access page --%>
    <c:choose>
    <c:when test="${userBean.privilageType == 'user'}">
    <%@ include file="fragments/navbarteacheruser.jsp" %>
    <%@ include file="fragments/teacherUserPage.jsp" %>
    </c:when>
    <c:when test="${userBean.privilageType == 'admin' || userBean.privilageType == 'superadmin'}">
    <%@ include file="fragments/navbarAdmin.jsp" %>
    <%@ include file="fragments/teacherSuperAdminPage.jsp" %>
    </c:when>
    <c:otherwise>
    <p>Unknown Privilege Type</p>
    </c:otherwise>
    </c:choose>
</c:if>


<%@ include file="fragments/footer.jsp" %>

</body>
</html>
