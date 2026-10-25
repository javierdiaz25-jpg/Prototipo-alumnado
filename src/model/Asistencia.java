package model;

public class Asistencia {

    private int id;
    private int alumnoId;
    private String fecha;
    private String estado;

    public Asistencia() {}

    public Asistencia(int id, int alumnoId,
                      String fecha,
                      String estado) {
        this.id = id;
        this.alumnoId = alumnoId;
        this.fecha = fecha;
        this.estado = estado;
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

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}