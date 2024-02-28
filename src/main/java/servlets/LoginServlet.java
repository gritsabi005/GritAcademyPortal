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

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //System.out.println();

        req.getRequestDispatcher("JSP/login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        //retrieving data from loginForm
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String userType = req.getParameter("user_type");

        //comparing data with DB student or teacher
        if(userType.equals("student")){
            List data = MySQLConnector.getConnector().selectQuery("studentLogIn",username,password);

            if(!data.isEmpty()){
                req.getSession().setMaxInactiveInterval(360);
                resp.getWriter().print("LOGGED IN - ");
                UserBean userBean = new UserBean();
                userBean.setUsername(username);
                userBean.setStateType(STATE_TYPE.confirmed);
                userBean.setUserType(USER_TYPE.student);
                userBean.setPrivilageType(PRIVILAGE_TYPE.user);
                req.getSession().setAttribute("userBean", userBean);
                resp.getWriter().print(req.getSession().getAttribute("userBean"));
                req.getRequestDispatcher("JSP/userPage.jsp").forward(req,resp);

            }
        } else if (userType.equals("teacher")) {
            List data = MySQLConnector.getConnector().selectQuery("teacherLogIn",username,password);
            if(!data.isEmpty()){
                req.getSession().setMaxInactiveInterval(360);
                resp.getWriter().print("LOGGED IN - ");
                UserBean userBean = new UserBean();
                userBean.setUsername(username);
                userBean.setStateType(STATE_TYPE.confirmed);
                userBean.setUserType(USER_TYPE.teacher);
                List dataPrivilage = MySQLConnector.getConnector().selectQuery("checkTeacherPrivilageDuringLogIn", username, password);
                if (!dataPrivilage.isEmpty()) {
                    // take the privilage number type in the second row from the resultset
                    for (int i = 0; i < dataPrivilage.size(); i++) {
                        String[] rowData = (String[]) dataPrivilage.get(i);

                        // Extract the privilege type value from the row
                        String privilegeValue = rowData[0]; // Assuming the privilege type is at index 0 of the row
                        System.out.println(privilegeValue);
                        // Check the privilege type and set it in the userBean
                        if (privilegeValue.equals("0")) {
                            System.out.println("hi user");
                            userBean.setPrivilageType(models.PRIVILAGE_TYPE.user);
                            System.out.println("hi user");
                        } else if (privilegeValue.equals("1") ) {
                            System.out.println("hi admin");
                            userBean.setPrivilageType(models.PRIVILAGE_TYPE.admin);
                        } else if (privilegeValue.equals("2")) {
                            System.out.println("hi superadmin");
                            userBean.setPrivilageType(models.PRIVILAGE_TYPE.superadmin);
                        }
                    }
                }
                req.getSession().setAttribute("userBean", userBean);
                resp.getWriter().print(req.getSession().getAttribute("userBean"));
                req.getRequestDispatcher("JSP/userPage.jsp").forward(req,resp);



            }
        }
    }
}