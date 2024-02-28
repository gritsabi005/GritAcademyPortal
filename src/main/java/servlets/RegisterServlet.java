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

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //System.out.println();

        req.getRequestDispatcher("JSP/register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String newcoursename = req.getParameter("newcoursename");
        String newcourseYHP = req.getParameter("newcourseYHP");
        String newcoursedescription = req.getParameter("newcoursedescription");

        resp.setContentType("text/html"); // Set content type to HTML
        PrintWriter out = resp.getWriter(); // Get PrintWriter to write response

        if (newcoursename != null && newcourseYHP != null && newcoursedescription != null) {
            try {
                MySQLConnector.getConnector().executeUpdate("insertNewCourse", newcoursename, newcourseYHP, newcoursedescription);
            }catch (NumberFormatException e){
            }
            List<String[]> dataCourseProfile = MySQLConnector.getConnector().selectQuery("done");
            req.getSession().setAttribute("datas", dataCourseProfile);
            req.getRequestDispatcher("JSP/register.jsp").forward(req, resp);
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
            req.getSession().setAttribute("datas", dataCourseProfile);
            req.getRequestDispatcher("JSP/register.jsp").forward(req, resp);
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
            req.getSession().setAttribute("datas", dataCourseProfile);
            req.getRequestDispatcher("JSP/register.jsp").forward(req, resp);
        }


        String studentid = req.getParameter("studentid");
        String courseid = req.getParameter("courseid");

        if (courseid != null && studentid != null) {
            try {
                MySQLConnector.getConnector().executeUpdate("registerStudentToCourse", studentid, courseid);

            } catch (NumberFormatException e) {
            }
            List<String[]> dataCourseProfile = MySQLConnector.getConnector().selectQuery("done");
            req.getSession().setAttribute("datas", dataCourseProfile);
            req.getRequestDispatcher("JSP/register.jsp").forward(req, resp);
        }

        String teacheridforteacher = req.getParameter("teacheridforteacher");
        String courseidforteacher = req.getParameter("courseidforteacher");

        if (courseidforteacher != null && teacheridforteacher != null) {
            try {
                MySQLConnector.getConnector().executeUpdate("registerTeacherToCourse", teacheridforteacher, courseidforteacher);

            } catch (NumberFormatException e) {
            }
            List<String[]> dataCourseProfile = MySQLConnector.getConnector().selectQuery("done");
            req.getSession().setAttribute("datas", dataCourseProfile);
            req.getRequestDispatcher("JSP/register.jsp").forward(req, resp);
        }
    }
}