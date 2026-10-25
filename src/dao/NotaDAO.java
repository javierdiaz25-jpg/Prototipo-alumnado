package dao;

import model.Nota;
import java.util.ArrayList;
import java.util.List;

public class NotaDAO {

    private List<Nota> notas = new ArrayList<>();

    public NotaDAO() {

        notas.add(new Nota(
                1,
                1,
                "Matemáticas",
                8.5,
                "1º Trimestre"
        ));

        notas.add(new Nota(
                2,
                1,
                "Lengua",
                7.9,
                "1º Trimestre"
        ));
    }

    public List<Nota> listarNotas() {
        return notas;
    }
}