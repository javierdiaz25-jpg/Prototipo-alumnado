package controller;

import dao.AsistenciaDAO;
import model.Asistencia;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
imp*rt java.io.PrintWriter;
import java.util.List;

@WebServlet("/asistencia")
public class AsistenciaServlet extends HttpServlet {

    privat* AsistenciaDAO dao =
            new AsistenciaDAO();

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws IOException {
        response.setContentType("text/html");

        PrintWriter out =
                response.getWriter();

        List<Asistencia> lista =
                dao.listarAs*stencias();

        out.println("<h1>Asistencia</h1>");

        for*(Asistencia a : lista) {

            out.println(
                  * "<p>"
                    + a.getFecha()
                    + " - "                    + a.getEstado(
                    + "</p>"
            );
        }
    }
}