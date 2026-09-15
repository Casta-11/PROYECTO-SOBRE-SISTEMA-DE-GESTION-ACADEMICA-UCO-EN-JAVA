package uco;

import java.util.ArrayList;
import java.util.List;

/**
 * PILAR: HERENCIA -> Estudiante reutiliza id, nombre y correo de Persona,
 * sin tener que volver a escribirlos.
 *
 * PILAR: POLIMORFISMO -> sobrescribe mostrarInformacion() con un contenido
 * distinto al de Profesor, aunque ambos se llamen igual y se puedan invocar
 * desde una referencia de tipo Persona.
 *
 * Implementa Evaluable porque, a diferencia de un Profesor, un Estudiante
 * si puede recibir y acumular notas.
 */
public class Estudiante extends Persona implements Evaluable {
    private String programa;
    private List<Nota> notas;

    public Estudiante(String id, String nombre, String correo, String programa) {
        super(id, nombre, correo); // reutiliza el constructor del padre (Herencia)
        this.programa = programa;
        this.notas = new ArrayList<>();
    }

    public String getPrograma() {
        return programa;
    }

    public List<Nota> getNotas() {
        return notas;
    }

    @Override
    public void registrarNota(Nota nota) {
        notas.add(nota);
    }

    @Override
    public double calcularPromedio() {
        if (notas.isEmpty()) return 0.0;
        double suma = 0;
        for (Nota n : notas) {
            suma += n.getValor();
        }
        return suma / notas.size();
    }

    @Override
    public String mostrarInformacion() {
        return "Estudiante [" + getId() + "] " + getNombre()
                + " - Programa: " + programa
                + " - Promedio: " + String.format("%.2f", calcularPromedio());
    }
}
