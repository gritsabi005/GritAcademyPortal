<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Arrays" %>
<!DOCTYPE html>
<html>
<table id="data table">
    <c:forEach items="${dataStudentProfile}" var="dataPunkt">
         <tr>
        <c:forEach items="${dataPunkt}" var="dataPunktKolumn">
                <td>${dataPunktKolumn}</td>
        </c:forEach>
         </tr>
    </c:forEach>
</table>
</html>
