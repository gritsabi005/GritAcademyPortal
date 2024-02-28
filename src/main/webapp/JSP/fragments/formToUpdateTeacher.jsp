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

    <label for="updateteacher">Update a teacher</label>

        <label for="teacherToUpdate">Write the name of the teacher you want to update:</label>
        <label for="teacherToUpdate">First Name:</label>
        <input type="text" id="teacherToUpdate" name="teacherToUpdate" required>
        <label for="teacherToUpdateagain">Last Name:</label>
        <input type="text" id="teacherToUpdateagain" name="teacherToUpdateagain" required>

        <label for="explanation">To update the teacher profile, please fill all the columns</label>
        <label for="explanations">Rewrite previous profile on columns you do not want to update</label>

        <label for="updateTeacherFName">First Name:</label>
            <input type="text" id="updateTeacherFName" name="updateTeacherFName" required>

            <label for="updateTeacherLName">Last Name:</label>
            <input type="text" id="updateTeacherLName" name="updateTeacherLName" required>

            <label for="updateTeacherTown">Town:</label>
            <input type="text" id="updateTeacherTown" name="updateTeacherTown" required>

            <label for="updateTeacherEmail">Email:</label>
            <input type="email" id="updateTeacherEmail" name="updateTeacherEmail" required>

            <label for="updateTeacherPhone">Phone:</label>
            <input type="text" id="updateTeacherPhone" name="updateTeacherPhone" required>

            <label for="updateTeacherUsername">Username:</label>
            <input type="text" id="updateTeacherUsername" name="updateTeacherUsername" required>

            <label for="updateTeacherPassword">Password:</label>
            <input type="password" id="updateTeacherPassword" name="updateTeacherPassword" required>

            <label for="updateTeacherPrivilege">Privilege Type:</label>
            <input type="text" id="updateTeacherPrivilege" name="updateTeacherPrivilege" required>

    <input type="submit" id="checkSubmit" name="checkSubmit" value="Update">

</form>
