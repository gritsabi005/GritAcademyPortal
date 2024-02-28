package servlets;

import models.MySQLConnector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

@WebServlet("/courses")
public class CoursesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LinkedList<String[]> data = MySQLConnector.getConnector().selectQuery("showAllCourses");
        req.setAttribute("data", data);
        req.getRequestDispatcher("JSP/courses.jsp").forward(req,resp);
    }

    /*@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html"); // Set content type to HTML
        PrintWriter out = resp.getWriter(); // Get PrintWriter to write response

        String allCourses = req.getParameter("allCourses");
        String availableCourses = req.getParameter("availableCourses");
        String showAllTeachers = req.getParameter("showAllTeachers");

        // it does feel like you have to initiate to show one table for it to alternate among all, in the div
        if (allCourses != null){
            List<String[]> dataCoursess = MySQLConnector.getConnector().selectQuery("showAllCoursesForEveryone");
            req.getSession().setAttribute("datas", dataCoursess);
            req.getRequestDispatcher("JSP/courses.jsp").forward(req, resp);


        } else if (availableCourses != null){
            List<String[]> dataCoursess = MySQLConnector.getConnector().selectQuery("showAllCoursesForEveryone");
            req.getSession().setAttribute("datas", dataCoursess);
            req.getRequestDispatcher("JSP/courses.jsp").forward(req, resp);

        }

    }*/

    /*
        /
    */




}