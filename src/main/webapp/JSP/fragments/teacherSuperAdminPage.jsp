<html>
<head>
    <title>Teacher Main Page</title>
    <style>

        .centerIt {
            display: flex;
            justify-content: center;
            align-items: center;
        }
.form-container {
        display: inline-block; width: 30%;
        margin-right: 8px;
        vertical-align: top;
    }
    .form-containerabove {
            display: inline-block; width: 45%;
            margin-right: 8px;
            vertical-align: top;
        }

    .outer-container {
        margin-bottom: 20px;
    }

    </style>
</head>
<body>

<main>
    <div class="centerIt"><h1>Welcome to the Teacher Super Admin and Admin Page</h1></div>

    <div class="centerIt">
    <%@ include file="buttonsToShowDatabaseTables.jsp" %>
    </div>


        <div class="centerIt">
        <%@ include file="showAllStudents.jsp" %>
        </div>

    <div class="centerIt">
    <div class="outer-container">
        <div class="form-containerabove">
            <%@ include file="formToSeeStudentsAndTeachersProfiles.jsp" %>
        </div>
        <div class="form-containerabove">
            <%@ include file="formToSeeCourseProfile.jsp" %>
        </div>
    </div>
    </div>

<div class="centerIt">
<div class="outer-container">
    <div class="form-container">
        <%@ include file="formToUpdateCourse.jsp" %>
    </div>
    <div class="form-container">
        <%@ include file="formToUpdateStudent.jsp" %>
    </div>
    <div class="form-container">
        <%@ include file="formToUpdateTeacher.jsp" %>
    </div>
    </div>
    </div>



</main>

</body>
</html>
