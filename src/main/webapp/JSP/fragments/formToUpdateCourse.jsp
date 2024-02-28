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

    <label for="updatecourse">Update a course</label>

        <label for="explanationss">Write the name of the course you want to update:</label>
        <input type="text" id="coursetoupdate" name="coursetoupdate" required>
        <label for="explanation">To update this course, please fill all the columns</label>
        <label for="explanations">Rewrite previous description on things you do not want to update</label>
        <label for="updatecoursename">Course name:</label>
        <input type="text" id="updatecoursename" name="updatecoursename" required>
        <label for="updatecourseYHP">YHP:</label>
        <input type="text" id="updatecourseYHP" name="updatecourseYHP" required>
        <label for="updatecoursedescription">Course description:</label>
        <input type="text" id="updatecoursedescription" name="updatecoursedescription" required>
    <input type="submit" id="checkSubmit" name="checkSubmit" value="Update">

</form>
