package uco;

/**
 * Representa una materia dictada en la UCO.
 * PILAR: ENCAPSULACION -> atributos privados con acceso controlado.
 */
public class Materia {
    private String codigo;
    private String nombre;
    private Profesor profesorAsignado;

    public Materia(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public Profesor getProfesorAsignado() {
        return profesorAsignado;
    }

    public void setProfesorAsignado(Profesor profesorAsignado) {
        this.profesorAsignado = profesorAsignado;
    }

    @Override
    public String toString() {
        return codigo + " - " + nombre;
    }
}
