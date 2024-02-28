<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Arrays" %>
<!DOCTYPE html>

<style>
        #checkForm {
            padding: 2px;
            border: 1px solid #ccc;
            border-radius: 5px;
            background-color: #f9f9f9;
            width: 300px;
        }

        #checkForm label {
            display: block;
            margin-bottom: 10px;
        }

        #checkForm input[type="text"],
        #checkForm select {
            width: 100%;
            padding: 8px;
            margin-bottom: 10px;
            box-sizing: border-box;
        }

        #checkSubmit {
            width: 100%;
            padding: 10px;
            background-color: #007bff;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        #checkSubmit:hover {
            background-color: #0056b3;
        }
        </style>

<form id="checkForm" action="/userPage" method="post">

    <label for="profile_type">Choose profile type:</label>
        <select id="profile_type" name="profile_type">
          <option value="student">Student</option>
          <option value="teacher">Teacher</option>
        </select>


        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required>
        <label for="lastname">Last Name:</Label>
        <input type="text" id="lastname" name="lastname" required>

    <button type="submit" id="showStudentTeacherProfile" name="showStudentTeacherProfile">Show Profile</button>

</form>
</html>
