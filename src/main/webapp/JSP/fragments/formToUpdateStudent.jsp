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

    <label for="updatestudent">Update a student</label>

        <label for="studentToUpdate">Write the name of the student you want to update:</label>
        <label for="studentToUpdate">First Name:</label>
        <input type="text" id="studentToUpdate" name="studentToUpdate" required>
        <label for="studentToUpdateagain">Last Name:</label>
        <input type="text" id="studentToUpdateagain" name="studentToUpdateagain" required>

        <label for="explanation">To update the student profile, please fill all the columns</label>
        <label for="explanations">Rewrite previous profile on columns you do not want to update</label>

        <label for="updateStudentFName">First Name:</label>
        <input type="text" id="updateStudentFName" name="updateStudentFName" required>

        <label for="updateStudentLName">Last Name:</label>
        <input type="text" id="updateStudentLName" name="updateStudentLName" required>

        <label for="updateStudentTown">Town:</label>
        <input type="text" id="updateStudentTown" name="updateStudentTown" required>

        <label for="updateStudentEmail">Email:</label>
        <input type="email" id="updateStudentEmail" name="updateStudentEmail" required>

        <label for="updateStudentPhone">Phone:</label>
        <input type="text" id="updateStudentPhone" name="updateStudentPhone" required>

        <label for="updateStudentUsername">Username:</label>
        <input type="text" id="updateStudentUsername" name="updateStudentUsername" required>

        <label for="updateStudentPassword">Password:</label>
        <input type="password" id="updateStudentPassword" name="updateStudentPassword" required>

    <input type="submit" id="checkSubmit" name="checkSubmit" value="Update">

</form>
