package Chapter_07_Applets_and_Servlets.LoginServlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class LoginServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String user = request.getParameter("username");
        String pass = request.getParameter("password");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        if ("admin".equals(user) && "password".equals(pass)) {
            out.println("<h1>Welcome, admin</h1>");
        } else {
            out.println("<h1>Invalid username or password</h1>");
        }
    }
}
