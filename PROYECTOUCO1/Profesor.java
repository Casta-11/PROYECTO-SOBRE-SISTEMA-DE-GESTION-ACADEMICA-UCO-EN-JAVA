package uco;

import java.util.ArrayList;
import java.util.List;

/**
 * PILAR: HERENCIA -> Profesor tambien extiende Persona.
 * PILAR: POLIMORFISMO -> su version de mostrarInformacion() es distinta
 * a la de Estudiante, aunque el metodo se llame igual.
 *
 * A proposito NO implementa Evaluable: un profesor no recibe notas,
 * por eso no tiene sentido forzarlo a cumplir ese contrato.
 */
public class Profesor extends Persona {
    private String especialidad;
    private List<Materia> materiasAsignadas;

    public Profesor(String id, String nombre, String correo, String especialidad) {
        super(id, nombre, correo);
        this.especialidad = especialidad;
        this.materiasAsignadas = new ArrayList<>();
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public List<Materia> getMateriasAsignadas() {
        return materiasAsignadas;
    }

    public void asignarMateria(Materia materia) {
        materiasAsignadas.add(materia);
        materia.setProfesorAsignado(this);
    }

    @Override
    public String mostrarInformacion() {
        return "Profesor [" + getId() + "] " + getNombre()
                + " - Especialidad: " + especialidad
                + " - Materias a cargo: " + materiasAsignadas.size();
    }
}
