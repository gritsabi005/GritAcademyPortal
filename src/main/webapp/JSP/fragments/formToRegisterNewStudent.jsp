
<html>

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

<form id="checkForm" action="/register" method="post">

    <form id="addStudentForm" action="/addStudent" method="post">

        <label for="studentRegister">Register new student</label>

        <label for="studentFirstName">First Name:</label>
        <input type="text" id="studentFirstName" name="studentFirstName" required>
        <label for="studentLastName">Last Name:</label>
        <input type="text" id="studentLastName" name="studentLastName" required>
        <label for="studentTown">Town:</label>
        <input type="text" id="studentTown" name="studentTown" required>
        <label for="studentEmail">Email:</label>
        <input type="email" id="studentEmail" name="studentEmail" required>
        <label for="studentPhone">Phone:</label>
        <input type="tel" id="studentPhone" name="studentPhone" required>
        <label for="studentUsername">Username:</label>
        <input type="text" id="studentUsername" name="studentUsername" required>
        <label for="studentPassword">Password:</label>
        <input type="password" id="studentPassword" name="studentPassword" required>
        <input type="submit" id="checkSubmit" name="checkSubmit" value="Register">

    </form>


</form>
