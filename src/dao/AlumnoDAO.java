package dao;

import model.Alumno;
import java.util.ArrayList;
import java.util.List;

public class AlumnoDAO {

    private List<Alumno> alumnos = new ArrayList<>();

    public AlumnoDAO() {

        alumnos.add(
            new Alumno(
                1,
                "Juan",
                "Pérez",
                "4º ESO",
                "juan@colegio.es",
                8.5
            )
        );
    }

    public List<Alumno> listarAlumnos() {
        return alumnos;
    }

public Alumno buscarPorId(int id) {

    for (Alumno alumno : alumnos) {

        if (alumno.getId() == id) {
            return alumno;
        }
    }

    return null;
}

}