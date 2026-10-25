package model;

public class Nota {

    private int id;
    private int alumnoId;
    private String asignatura;
    private double calificacion;
    private String trimestre;

    public Nota() {}

    public Nota(int id, int alumnoId, String asignatura,
                double calificacion, String trimestre) {
        this.id = id;
        this.alumnoId = alumnoId;
        this.asignatura = asignatura;
        this.calificacion = calificacion;
        this.trimestre = trimestre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAlumnoId() {
        return alumnoId;
    }

    public void setAlumnoId(int alumnoId) {
        this.alumnoId = alumnoId;
    }

    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }

    public String getTrimestre() {
        return trimestre;
    }

    public void setTrimestre(String trimestre) {
        this.trimestre = trimestre;
    }
}