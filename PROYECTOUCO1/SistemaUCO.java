package uco;

import java.util.ArrayList;
import java.util.List;

/**
 * Administra los datos del sistema (estudiantes, profesores, materias).
 *
 * PILAR: POLIMORFISMO -> la lista 'personas' es de tipo Persona, pero en
 * realidad guarda objetos Estudiante y Profesor mezclados. Al recorrerla
 * y llamar mostrarInformacion(), cada objeto ejecuta SU PROPIA version
 * del metodo, sin que el codigo tenga que preguntar "eres estudiante o
 * profesor" con un monton de if/else.
 */
public class SistemaUCO {
    private List<Persona> personas;
    private List<Materia> materias;

    public SistemaUCO() {
        this.personas = new ArrayList<>();
        this.materias = new ArrayList<>();
    }

    public void registrarPersona(Persona persona) {
        personas.add(persona);
    }

    public void registrarMateria(Materia materia) {
        materias.add(materia);
    }

    public List<Materia> getMaterias() {
        return materias;
    }

    public List<Persona> getPersonas() {
        return personas;
    }

    // PILAR: POLIMORFISMO POR SOBRECARGA (overloading) -> dos formas distintas
    // de registrar una nota, mismo nombre de metodo, distintos parametros.
    public void registrarNota(Estudiante estudiante, Materia materia, double valor) {
        estudiante.registrarNota(new Nota(materia, valor));
    }

    public void registrarNota(Estudiante estudiante, Nota nota) {
        estudiante.registrarNota(nota);
    }

    public Estudiante buscarEstudiantePorId(String id) {
        for (Persona p : personas) {
            if (p instanceof Estudiante && p.getId().equals(id)) {
                return (Estudiante) p;
            }
        }
        return null;
    }

    // PILAR: POLIMORFISMO POR SOBRESCRITURA (overriding) en accion:
    // no importa si "p" es Estudiante o Profesor, cada uno responde a
    // su manera al mismo mensaje mostrarInformacion().
    public void listarTodos() {
        for (Persona p : personas) {
            System.out.println(p.mostrarInformacion());
        }
    }
}
