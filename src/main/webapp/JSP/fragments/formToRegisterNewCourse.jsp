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

    <label for="registercourse">Register new course</label>

        <label for="registercourse">Course name:</label>
        <input type="text" id="newcoursename" name="newcoursename" required>
        <label for="registercourse">YHP:</label>
        <input type="text" id="newcourseYHP" name="newcourseYHP" required>
        <label for="registercourse">Course daescription:</label>
        <input type="text" id="newcoursedescription" name="newcoursedescription" required>
    <input type="submit" id="checkSubmit" name="checkSubmit" value="Register">

</form>
