package uco;

/**
 * PILAR: ABSTRACCION -> este contrato dice QUE debe poder hacer algo
 * "evaluable" (registrar y calcular notas), pero no dice COMO.
 * Solo Estudiante la implementa, porque solo un estudiante recibe notas
 * (un Profesor, por ejemplo, no implementa esta interfaz).
 */
public interface Evaluable {
    void registrarNota(Nota nota);
    double calcularPromedio();
}
