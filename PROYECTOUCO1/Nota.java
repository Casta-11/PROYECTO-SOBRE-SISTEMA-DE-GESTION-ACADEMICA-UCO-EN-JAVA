package uco;

/**
 * Representa la nota de un estudiante en una materia especifica.
 *
 * PILAR: ENCAPSULACION -> el valor de la nota nunca se asigna "a lo bruto";
 * siempre pasa por setValor(), que valida el rango permitido (0.0 a 5.0).
 */
public class Nota {
    private Materia materia;
    private double valor;

    public Nota(Materia materia, double valor) {
        this.materia = materia;
        setValor(valor);
    }

    public Materia getMateria() {
        return materia;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        if (valor >= 0.0 && valor <= 5.0) {
            this.valor = valor;
        } else {
            throw new IllegalArgumentException("La nota debe estar entre 0.0 y 5.0");
        }
    }

    @Override
    public String toString() {
        return materia.getNombre() + ": " + valor;
    }
}
