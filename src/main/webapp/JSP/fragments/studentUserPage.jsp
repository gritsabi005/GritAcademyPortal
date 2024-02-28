<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Student Main Page</title>
</head>
<body>

<main>
<div class="centerIt">
    <h1>Welcome to the Student Main Page</h1></div>
 <div class="centerIt">   <p>This is the main page for students.</p></div>
  <div class="centerIt">  <p>Here, you can perform various tasks specific to students.</p></div>
  <div class="centerIt">  <p>For example, you can view your grades, manage assignments, and communicate with other students.</p></div>
</main>

<div class="centerIt">
<%@ include file="buttonsto.jsp" %>
</div>

<div class="centerIt">
<%@ include file="studenttable/coursesforstudent.jsp" %>
</div>

</body>
</html>
