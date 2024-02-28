<html>
<head>
    <title>Teacher Main Page</title>
    <style>
        /* Center the form */
        .centerIt {
            display: flex;
            justify-content: center;
            align-items: center;
        }


    </style>
</head>
<body>

<main>
    <div class="centerIt"><h1>Welcome to the Teacher Super Admin and Admin Page</h1></div>

    <div class="centerIt">
    <%@ include file="buttonsToShowDatabaseTablesForTeacherUser.jsp" %>
    </div>

        <div class="centerIt">
        <%@ include file="showAllStudentsForTeacherUser.jsp" %>
        </div>


    <div class="centerIt">
    <%@ include file="formToSeeStudentsAndTeachersProfiles.jsp" %>
    </div>

    <p>see specific courses contains which students and teachers <br>
    <div class="centerIt">
    <%@ include file="formToSeeCourseProfile.jsp" %>
    </div>


    </p>

</main>

</body>
</html>
