package dao;

import model.Asistencia;
import java.util.ArrayList;
import java.util.List;

public class AsistenciaDAO {

    private List<Asistencia> asistencias =
            new ArrayList<>();

    public AsistenciaDAO() {

        asistencias.add(
            new Asistencia(
                1,
                1,
                "2025-01-10",
                "Presente"
            )
        );

        asistencias.add(
            new Asistencia(
                2,
                1,
                "2025-01-11",
                "Ausente"
            )
        );
    }

    public List<Asistencia> listarAsistencias() {
        return asistencias;
    }
}