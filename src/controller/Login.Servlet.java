package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException

@WebServlet("/login")
public class LoginServlet extends HttpServlet{

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException{

        String usuario =
               request.getParameter("usuario");

        String password =
                request.getParameter("password");

        if(usuario.equals("alumno")
                password.equals("1234")) {

            response.sendRedirect("dashboard.html");

        } else {

            response.sendRedirect("index.html");
        }
    }
}