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

    <form id="addTeacherForm" action="/addteacher" method="post">

        <label for="teacherRegister">Register new teacher</label>

        <label for="teacherFirstName">First Name:</label>
                <input type="text" id="teacherFirstName" name="teacherFirstName" required>

                <label for="teacherLastName">Last Name:</label>
                <input type="text" id="teacherLastName" name="teacherLastName" required>

                <label for="teacherTown">Town:</label>
                <input type="text" id="teacherTown" name="teacherTown" required>

                <label for="teacherEmail">Email:</label>
                <input type="email" id="teacherEmail" name="teacherEmail" required>

                <label for="teacherPhone">Phone:</label>
                <input type="number" id="teacherPhone" name="teacherPhone" required>

                <label for="teacherUsername">Username:</label>
                <input type="text" id="teacherUsername" name="teacherUsername" required>

                <label for="teacherPassword">Password:</label>
                <input type="password" id="teacherPassword" name="teacherPassword" required>

                <label for="teacherPrivilegeType">Privilege Type:</label>
                <input type="number" id="teacherPrivilegeType" name="teacherPrivilegeType" required>

        <input type="submit" id="checkSubmit" name="checkSubmit" value="Register">

    </form>


</form>

