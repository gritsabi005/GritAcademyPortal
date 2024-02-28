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

    <label for="registerstudenttocourse">Register new student to a course</label>

        <label for="studentid">Student ID:</label>
        <input type="number" id="studentid" name="studentid" required>
        <label for="courseid">Course ID:</label>
        <input type="number" id="courseid" name="courseid" required>

        <input type="submit" id="checkSubmit" name="checkSubmit" value="Register To Course">

</form>
