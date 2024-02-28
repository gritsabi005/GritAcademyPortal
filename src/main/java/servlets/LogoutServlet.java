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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Invalidate the session to log out
        HttpSession session = request.getSession(false); // false means do not create a new session
        if (session != null) {
            session.invalidate();
        }
        response.sendRedirect("index"); // Redirect to home page
    }
}