package controller;

import dao.NotaDAO;
import model.Nota;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/notas")
public class NotaServlet extends HttpServlet {

    private NotaDAO dao = new NotaDAO();

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws IOException {

        response.setContentType("text/html");

        PrintWriter out =
                response.getWriter();

        List<Nota> notas =
                dao.listarNotas();

        out.println("<h1>Calificaciones</h1>");

        for (Nota nota : notas) {

            out.println(
                    "<p>"
                    + nota.getAsignatura()
                    + ": "
                    + nota.getCalificacion()
                    + "</p>"
            );
        }
    }
}