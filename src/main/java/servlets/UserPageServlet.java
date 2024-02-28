package servlets;

import models.MySQLConnector;
import models.STATE_TYPE;
import models.UserBean;
import models.USER_TYPE;
import models.PRIVILAGE_TYPE;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Arrays;
import java.io.PrintWriter;
import java.sql.Connection;

@WebServlet("/userPage")
public class UserPageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html"); // Set content type to HTML
        PrintWriter out = resp.getWriter(); // Get PrintWriter to write response

        UserBean user = (UserBean) req.getSession().getAttribute("userBean");
        if (user != null && user.getUserType() == USER_TYPE.student) {
            String username = user.getUsername();
            List dataCourseForSpecificStudent = MySQLConnector.getConnector().selectQuery("fetchThisStudentCourse", username);
            req.getSession().setAttribute("data", dataCourseForSpecificStudent);
        }

        // Forward to the user page
        req.getRequestDispatcher("JSP/userPage.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html"); // Set content type to HTML
        PrintWriter out = resp.getWriter(); // Get PrintWriter to write response
        UserBean user = (UserBean) req.getSession().getAttribute("userBean");
        String showyourcourse = req.getParameter("showyourcourse");
        String showyourclassprofile = req.getParameter("showyourclassprofile");
        if (showyourcourse != null && user != null && user.getUserType() == USER_TYPE.student){
            String username = user.getUsername();
            List<String[]> dataCourseForSpecificStudent = MySQLConnector.getConnector().selectQuery("fetchThisStudentCourse", username);
            req.getSession().setAttribute("data", dataCourseForSpecificStudent);
            req.getRequestDispatcher("JSP/userPage.jsp").forward(req, resp);

        } else if (showyourclassprofile != null && user != null && user.getUserType() == USER_TYPE.student){
            String username = user.getUsername();
            List<String[]> dataClassForSpecificStudent = MySQLConnector.getConnector().selectQuery("showThisStudentClassProfile", username);
            req.getSession().setAttribute("data", dataClassForSpecificStudent);
            req.getRequestDispatcher("JSP/userPage.jsp").forward(req, resp);

        }


        /*UserBean user = (UserBean) req.getSession().getAttribute("userBean");
        if (user != null && user.getUserType() == USER_TYPE.student) {
            String username = user.getUsername();
            System.out.println(username);
            List dataCourseForSpecificStudent = MySQLConnector.getConnector().selectQuery("fetchThisStudentCourse", username);
            System.out.println(dataCourseForSpecificStudent);
            req.getSession().setAttribute("data", dataCourseForSpecificStudent);
            req.getRequestDispatcher("JSP/userPage.jsp").forward(req, resp);
        }*/


        // initiating first three buttons to see all tables
        String showAllStudents = req.getParameter("showAllStudents");
        String showAllCourses = req.getParameter("showAllCourses");
        String showAllTeachers = req.getParameter("showAllTeachers");

        // it does feel like you have to initiate to show one table for it to alternate among all, in the div
        if (showAllStudents != null){
            List<String[]> data = MySQLConnector.getConnector().selectQuery("showAllStudents");
            req.getSession().setAttribute("data", data);
            req.getRequestDispatcher("JSP/userPage.jsp").forward(req, resp);


        } else if (showAllCourses != null){
            List<String[]> dataCourses = MySQLConnector.getConnector().selectQuery("showAllCourses");
            req.getSession().setAttribute("data", dataCourses);
            req.getRequestDispatcher("JSP/userPage.jsp").forward(req, resp);

        } else if (showAllTeachers != null){
            List<String[]> dataTeachers = MySQLConnector.getConnector().selectQuery("showAllTeachers");
            req.getSession().setAttribute("data", dataTeachers);
            req.getRequestDispatcher("JSP/userPage.jsp").forward(req, resp);
        }

        String showAllStudentsForTeacherUser = req.getParameter("showAllStudentsForTeacherUser");
        String showAllCoursesForTeacherUser = req.getParameter("showAllCoursesForTeacherUser");
        String showAllTeachersForTeacherUser = req.getParameter("showAllTeachersForTeacherUser");

        // it does feel like you have to initiate to show one table for it to alternate among all, in the div
        if (showAllStudentsForTeacherUser != null){
            List<String[]> data = MySQLConnector.getConnector().selectQuery("showAllStudentsWithoutConfidentialData");
            req.getSession().setAttribute("data", data);
            req.getRequestDispatcher("JSP/userPage.jsp").forward(req, resp);


        } else if (showAllCoursesForTeacherUser != null){
            List<String[]> dataCourses = MySQLConnector.getConnector().selectQuery("showAllCoursesWithoutConfidentialData");
            req.getSession().setAttribute("data", dataCourses);
            req.getRequestDispatcher("JSP/userPage.jsp").forward(req, resp);

        } else if (showAllTeachersForTeacherUser != null){
            List<String[]> dataTeachers = MySQLConnector.getConnector().selectQuery("showAllTeachersWithoutConfidentialData");
            req.getSession().setAttribute("data", dataTeachers);
            req.getRequestDispatcher("JSP/userPage.jsp").forward(req, resp);
        }

        String showAllStudentsRegistration = req.getParameter("showAllStudentsRegistration");
        String showAllCoursesRegistration = req.getParameter("showAllCoursesRegistration");
        String showAllTeachersRegistration = req.getParameter("showAllTeachersRegistration");

        if (showAllStudentsRegistration != null){
            List<String[]> data = MySQLConnector.getConnector().selectQuery("showAllStudents");
            req.getSession().setAttribute("data", data);
            req.getRequestDispatcher("JSP/register.jsp").forward(req, resp);


        } else if (showAllCoursesRegistration != null){
            List<String[]> dataCourses = MySQLConnector.getConnector().selectQuery("showAllCourses");
            req.getSession().setAttribute("data", dataCourses);
            req.getRequestDispatcher("JSP/register.jsp").forward(req, resp);

        } else if (showAllTeachersRegistration != null){
            List<String[]> dataTeachers = MySQLConnector.getConnector().selectQuery("showAllTeachers");
            req.getSession().setAttribute("data", dataTeachers);
            req.getRequestDispatcher("JSP/register.jsp").forward(req, resp);
        }

        /*String buttonsToSearchStudentAndTeacher = req.getParameter("buttonsToSearchStudentAndTeacher");
        String buttonsToSearchCourse = req.getParameter("buttonsToSearchCourse");


        if (buttonsToSearchStudentAndTeacher != null) {
            req.getSession().setAttribute("data", "JSP/fragments/formToSeeStudentsAndTeachersProfiles.jsp");
            req.getRequestDispatcher("JSP/userPage.jsp").forward(req, resp);
        }*/


        //initiating buttons to see students, teachers and course profile

        String showIndividualProfile = req.getParameter("showStudentTeacherProfile");
        String showCourseProfile = req.getParameter("showCourseProfile");
        String name = req.getParameter("name");
        String lastname = req.getParameter("lastname");
        String profileType = req.getParameter("profile_type");
        if (showIndividualProfile != null && name != null && lastname != null && profileType.equals("student")) {
            List<String[]> dataStudentProfile = MySQLConnector.getConnector().selectQuery("selectWhichCoursesTheStudentsAreHaving", name, lastname);
            req.getSession().setAttribute("data", dataStudentProfile);
            req.getRequestDispatcher("JSP/userPage.jsp").forward(req, resp);

        } else if (showIndividualProfile != null && name != null && lastname != null && profileType.equals("teacher")){
            List<String[]> dataTeacherProfile = MySQLConnector.getConnector().selectQuery("selectWhichCoursesTheTeachersAreHaving", name, lastname);
            out.println("If there are no registered students yet into the course, the students column will say null");
            req.getSession().setAttribute("data", dataTeacherProfile);
            req.getRequestDispatcher("JSP/userPage.jsp").forward(req, resp);
        }

        String coursename = req.getParameter("coursename");
        if (showCourseProfile != null && coursename != null) {
            List<String[]> dataCourseProfile = MySQLConnector.getConnector().selectQuery("selectWhichTeachersAndStudentsTheCoursesAreHaving", coursename);
            req.getSession().setAttribute("data", dataCourseProfile);
            req.getRequestDispatcher("JSP/userPage.jsp").forward(req, resp);

        }

        /*String newcoursename = req.getParameter("newcoursename");
        String newcourseYHP = req.getParameter("newcourseYHP");
        String newcoursedescription = req.getParameter("newcoursedescription");

        if (newcoursename != null && newcourseYHP != null && newcoursedescription != null) {
            try {
                MySQLConnector.getConnector().executeUpdate("insertNewCourse", newcoursename, newcourseYHP, newcoursedescription);
            }catch (NumberFormatException e){
            }
            List<String[]> dataCourseProfile = MySQLConnector.getConnector().selectQuery("done");
            req.getSession().setAttribute("data", dataCourseProfile);
            req.getRequestDispatcher("JSP/userPage.jsp").forward(req, resp);
        }
        

        String studentFirstName = req.getParameter("studentFirstName");
        String studentLastName = req.getParameter("studentLastName");
        String studentTown = req.getParameter("studentTown");
        String studentEmail = req.getParameter("studentEmail");
        String studentPhone = req.getParameter("studentPhone");
        String studentUsername = req.getParameter("studentUsername");
        String studentPassword = req.getParameter("studentPassword");

        if (studentFirstName != null && studentLastName != null && studentTown != null && studentEmail != null && studentPhone != null && studentUsername != null && studentPassword != null) {
            try {
                MySQLConnector.getConnector().executeUpdate("insertNewStudent", studentFirstName, studentLastName, studentTown, studentEmail, studentPhone, studentUsername, studentPassword);

            } catch (NumberFormatException e) {
            }
            List<String[]> dataCourseProfile = MySQLConnector.getConnector().selectQuery("done");
            req.getSession().setAttribute("data", dataCourseProfile);
            req.getRequestDispatcher("JSP/userPage.jsp").forward(req, resp);
        }
        
        String teacherFirstName = req.getParameter("teacherFirstName");
        String teacherLastName = req.getParameter("teacherLastName");
        String teacherTown = req.getParameter("teacherTown");
        String teacherEmail = req.getParameter("teacherEmail");
        String teacherPhone = req.getParameter("teacherPhone");
        String teacherUsername = req.getParameter("teacherUsername");
        String teacherPassword = req.getParameter("teacherPassword");
        String teacherPrivilegeType = req.getParameter("teacherPrivilegeType");

        if (teacherFirstName != null && teacherLastName != null && teacherTown != null && teacherEmail != null && teacherPhone != null && teacherUsername != null && teacherPassword != null && teacherPrivilegeType != null) {
            try {
                MySQLConnector.getConnector().executeUpdate("insertNewTeacher", teacherFirstName, teacherLastName, teacherTown, teacherEmail, teacherPhone, teacherUsername, teacherPassword, teacherPrivilegeType);
                
            } catch (NumberFormatException e) {
            }
            List<String[]> dataCourseProfile = MySQLConnector.getConnector().selectQuery("done");
            req.getSession().setAttribute("data", dataCourseProfile);
            req.getRequestDispatcher("JSP/userPage.jsp").forward(req, resp);
        }


        String studentid = req.getParameter("studentid");
        String courseid = req.getParameter("courseid");

        if (courseid != null && studentid != null) {
            try {
                MySQLConnector.getConnector().executeUpdate("registerStudentToCourse", studentid, courseid);

            } catch (NumberFormatException e) {
            }
            List<String[]> dataCourseProfile = MySQLConnector.getConnector().selectQuery("done");
            req.getSession().setAttribute("data", dataCourseProfile);
            req.getRequestDispatcher("JSP/userPage.jsp").forward(req, resp);
        }

        String teacheridforteacher = req.getParameter("teacheridforteacher");
        String courseidforteacher = req.getParameter("courseidforteacher");

        if (courseidforteacher != null && teacheridforteacher != null) {
            try {
                MySQLConnector.getConnector().executeUpdate("registerTeacherToCourse", teacheridforteacher, courseidforteacher);

            } catch (NumberFormatException e) {
            }
            List<String[]> dataCourseProfile = MySQLConnector.getConnector().selectQuery("done");
            req.getSession().setAttribute("data", dataCourseProfile);
            req.getRequestDispatcher("JSP/userPage.jsp").forward(req, resp);
        }*/

        String coursetoupdate = req.getParameter("coursetoupdate");
        String updatecoursename = req.getParameter("updatecoursename");
        String updatecourseYHP = req.getParameter("updatecourseYHP");
        String updatecoursedescription = req.getParameter("updatecoursedescription");

        if (updatecoursename != null && updatecourseYHP != null && updatecoursedescription != null) {
            try {
                MySQLConnector.getConnector().executeUpdate("updateCourse", updatecoursename, updatecourseYHP, updatecoursedescription, coursetoupdate);
            } catch (NumberFormatException e) {
            }
            List<String[]> dataCourseProfile = MySQLConnector.getConnector().selectQuery("done");
            req.getSession().setAttribute("data", dataCourseProfile);
            req.getRequestDispatcher("JSP/userPage.jsp").forward(req, resp);
        }

        String studentToUpdate = req.getParameter("studentToUpdate");
        String studentToUpdateagain = req.getParameter("studentToUpdateagain");
        String updateStudentFName = req.getParameter("updateStudentFName");
        String updateStudentLName = req.getParameter("updateStudentLName");
        String updateStudentTown = req.getParameter("updateStudentTown");
        String updateStudentEmail = req.getParameter("updateStudentEmail");
        String updateStudentPhone = req.getParameter("updateStudentPhone");
        String updateStudentUsername = req.getParameter("updateStudentUsername");
        String updateStudentPassword = req.getParameter("updateStudentPassword");

        if (studentToUpdate != null && updateStudentFName != null && updateStudentLName != null && updateStudentTown != null &&
                updateStudentEmail != null && updateStudentPhone != null && updateStudentUsername != null && updateStudentPassword != null) {
            try {
                MySQLConnector.getConnector().executeUpdate("updateStudent", updateStudentFName, updateStudentLName, updateStudentTown,
                        updateStudentEmail, updateStudentPhone, updateStudentUsername, updateStudentPassword, studentToUpdate, studentToUpdateagain);
            } catch (NumberFormatException e) {
            }
            List<String[]> dataCourseProfile = MySQLConnector.getConnector().selectQuery("done");
            req.getSession().setAttribute("data", dataCourseProfile);
            req.getRequestDispatcher("JSP/userPage.jsp").forward(req, resp);
        }

        String teacherToUpdate = req.getParameter("teacherToUpdate");
        String teacherToUpdateagain = req.getParameter("teacherToUpdateagain");
        String updateTeacherFName = req.getParameter("updateTeacherFName");
        String updateTeacherLName = req.getParameter("updateTeacherLName");
        String updateTeacherTown = req.getParameter("updateTeacherTown");
        String updateTeacherEmail = req.getParameter("updateTeacherEmail");
        String updateTeacherPhone = req.getParameter("updateTeacherPhone");
        String updateTeacherUsername = req.getParameter("updateTeacherUsername");
        String updateTeacherPassword = req.getParameter("updateTeacherPassword");
        String updateTeacherPrivilege = req.getParameter("updateTeacherPrivilege");

        if (teacherToUpdate != null && teacherToUpdateagain != null && updateTeacherFName != null && updateTeacherLName != null &&
                updateTeacherTown != null && updateTeacherEmail != null && updateTeacherPhone != null &&
                updateTeacherUsername != null && updateTeacherPassword != null && updateTeacherPrivilege != null) {
            try {
                MySQLConnector.getConnector().executeUpdate("updateTeacher",
                        updateTeacherFName, updateTeacherLName, updateTeacherTown, updateTeacherEmail,
                        updateTeacherPhone, updateTeacherUsername, updateTeacherPassword,
                        updateTeacherPrivilege, teacherToUpdate, teacherToUpdateagain);
            } catch (NumberFormatException e) {
            }
            List<String[]> dataCourseProfile = MySQLConnector.getConnector().selectQuery("done");
            req.getSession().setAttribute("data", dataCourseProfile);
            req.getRequestDispatcher("JSP/userPage.jsp").forward(req, resp);
        }
    }



    /*@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String showAllStudents = req.getParameter("showAllStudents");
        String showAllCourses = req.getParameter("showAllCourses");
        String showAllTeachers = req.getParameter("showAllTeachers");
        if (showAllStudents != null){
            List data = MySQLConnector.getConnector().selectQuery("studentLogIn");
            data.forEach(row -> {
                System.out.println("<tr>");
                Arrays.stream(row).forEach(dataPoint -> {
                    System.out.println("<td style='border: 1px dotted gray; background-color: #96D4D4;'>" + dataPoint + "</td>");
                });
                System.out.println("</tr>");
            });
        }
    }*/
    /*@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html"); // Set content type to HTML
        PrintWriter out = resp.getWriter(); // Get PrintWriter to write response

        String showAllStudents = req.getParameter("showAllStudents");
        String showAllCourses = req.getParameter("showAllCourses");
        String showAllTeachers = req.getParameter("showAllTeachers");*/

        /*ut.println("set is done");
            req.getRequestDispatcher("fragments/showAllStudents.jsp").forward(req,resp);
            System.out.println("req is done");*/
            /*data.forEach(row -> {
                System.out.println("<tr>");
                Arrays.stream(row).forEach(dataPoint -> {
                    System.out.println("<td style='border: 1px dotted gray; background-color: #96D4D4;'>" + dataPoint + "</td>");
                });
                System.out.println("</tr>");
            });
        }*/
        /*if (showAllStudents != null){
            List<String[]> data = MySQLConnector.getConnector().selectQuery("showAllStudents");
            out.println("<table border='1'>");
            data.forEach(row -> {
                out.println("<tr>");
                Arrays.stream(row).forEach(dataPoint -> {
                    out.println("<td style='border: background-color: white;'>" + dataPoint + "</td>");
                });
                out.println("</tr>");
            });
            out.println("</table>");
        }
    }*/

}