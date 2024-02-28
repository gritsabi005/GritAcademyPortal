<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
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
<html>
<%@ include file="fragments/head.jsp" %>
<body>
    <div class="centerIt">
<%@ include file="fragments/navbarAdmin.jsp" %>
</div>

<div class="centerIt"><h1>Welcome to the Registration Page for Super Admin and Admin Teacher</h1></div>

                <div class="centerIt">
                <%@ include file="fragments/buttonsToShowDatabaseTablesForRegistration.jsp" %>
                </div>


                    <div class="centerIt">
                    <%@ include file="fragments/showAllStudentsRegistration.jsp" %>
                    </div>

            <div class="centerIt">
            <%@ include file="fragments/showDone.jsp" %>
            </div>



        <div class="centerIt">
        <div class="outer-container">
            <div class="form-containerabove">
                <%@ include file="fragments/formToRegisterStudentToCourse.jsp" %>
            </div>
            <div class="form-containerabove">
                <%@ include file="fragments/formToRegisterTeacherToCourse.jsp" %>
            </div>
        </div>
        </div>

<div class="centerIt">
<div class="outer-container">
    <div class="form-container">
        <%@ include file="fragments/formToRegisterNewCourse.jsp" %>
    </div>
    <div class="form-container">
        <%@ include file="fragments/formToRegisterNewStudent.jsp" %>
    </div>
    <div class="form-container">
        <%@ include file="fragments/formToRegisterNewTeacher.jsp" %>
    </div>
    </div>
    </div>






<%@ include file="fragments/footer.jsp" %>

</body>
</html>