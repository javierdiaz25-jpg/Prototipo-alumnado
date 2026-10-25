package controller;

import dao.AlumnoDAO;
import model.Alumno;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;

@WebServlet("/api/alumnos/lista")
public class ListarAlumnosApiServlet extends HttpServlet {

    private final AlumnoDAO dao = new AlumnoDAO();

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws IOException {

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        List<Alumno> alumnos = dao.listarAlumnos();

        StringBuilder json = new StringBuilder();
        json.append("[");

        for (int i = 0; i < alumnos.size(); i++) {

            Alumno a = alumnos.get(i);

            json.append("{")
                .append("\"id\":").append(a.getId()).append(",")
                .append("\"nombre\":\"").append(a.getNombre()).append("\",")
                .append("\"apellidos\":\"").append(a.getApellidos()).append("\",")
                .append("\"curso\":\"").append(a.getCurso()).append("\"")
                .append("}");

            if (i < alumnos.size() - 1) {
                json.append(",");
            }
        }

        json.append("]");

        response.getWriter().write(json.toString());
    }
}