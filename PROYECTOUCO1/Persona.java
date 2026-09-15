package uco;

/**
 * Clase abstracta que representa a una persona dentro de la UCO.
 *
 * PILAR: ABSTRACCION -> define QUE datos y comportamientos tiene en comun
 * toda persona del sistema, sin decidir COMO cada tipo especifico
 * (Estudiante, Profesor) va a mostrar su informacion. Eso lo decide
 * cada subclase en su propia implementacion de mostrarInformacion().
 */
public abstract class Persona {

    // PILAR: ENCAPSULACION -> atributos privados, protegidos de acceso directo.
    // Solo se pueden leer/modificar a traves de los metodos publicos (getters/setters),
    // que ademas validan los datos antes de aceptarlos.
    private String id;
    private String nombre;
    private String correo;

    public Persona(String id, String nombre, String correo) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre != null && !nombre.isBlank()) {
            this.nombre = nombre;
        }
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        if (correo != null && correo.contains("@")) {
            this.correo = correo;
        }
    }

    /**
     * Metodo abstracto: obliga a cada subclase a definir su propia forma
     * de mostrar la informacion. Base del POLIMORFISMO por sobrescritura.
     */
    public abstract String mostrarInformacion();

    @Override
    public String toString() {
        return mostrarInformacion();
    }
}
