package controller;

import dao.AlumnoDAO;
import model.Alumno;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/alumnos")
public class AlumnoServlet extends HttpServlet {

    private AlumnoDAO dao = new AlumnoDAO();

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        List<Alumno> alumnos = dao.listarAlumnos();

        out.println("<html><body>");
        out.println("<h1>Listado de Alumnos</h1>");

        for (Alumno a : alumnos) {
            out.println("<p>");
            out.println(a.getNombre() + " " +
                        a.getApellidos() +
                        " - " +
                        a.getCurso());
            out.println("</p>");
        }

        out.println("</body></html>");
    }
}