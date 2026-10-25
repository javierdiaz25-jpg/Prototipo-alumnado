package controller;

import dao.AlumnoDAO;
import model.Alumno;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/api/alumnos")
public class AlumnoApiServlet extends HttpServlet {

    private final AlumnoDAO alumnoDAO = new AlumnoDAO();

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws IOException {

        String idParam = request.getParameter("id");

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        if (idParam == null) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);

            response.getWriter().write(
                "{\"error\":\"Debe proporcionar un ID\"}"
            );
            return;
        }

        int id = Integer.parseInt(idParam);

        Alumno alumno = alumnoDAO.buscarPorId(id);

        if (alumno == null) {

            response.setStatus(
                    HttpServletResponse.SC_NOT_FOUND);

            response.getWriter().write(
                "{\"error\":\"Alumno no encontrado\"}"
            );

            return;
        }

        String json =
                "{"
                + "\"id\":" + alumno.getId() + ","
                + "\"nombre\":\"" + alumno.getNombre() + "\","
                + "\"apellidos\":\"" + alumno.getApellidos() + "\","
                + "\"curso\":\"" + alumno.getCurso() + "\","
                + "\"email\":\"" + alumno.getEmail() + "\","
                + "\"media\":" + alumno.getMedia()
                + "}";

        response.getWriter().write(json);
    }
}