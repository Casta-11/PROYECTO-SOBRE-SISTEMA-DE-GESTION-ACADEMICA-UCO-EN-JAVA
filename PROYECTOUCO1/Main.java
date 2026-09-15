package uco;

import java.util.Scanner;

/**
 * Punto de entrada del programa. Menu de consola para interactuar
 * con el SistemaUCO (registrar estudiantes, profesores, materias y notas).
 */
public class 1Main {
    public static void main(String[] args) {
        SistemaUCO sistema = new SistemaUCO();
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n===== SISTEMA UCO =====");
            System.out.println("1. Registrar estudiante");
            System.out.println("2. Registrar profesor");
            System.out.println("3. Registrar materia");
            System.out.println("4. Registrar nota a un estudiante");
            System.out.println("5. Listar todas las personas");
            System.out.println("6. Ver promedio de un estudiante");
            System.out.println("0. Salir");
            System.out.print("Elige una opcion: ");
            opcion = leerEntero(sc);

            switch (opcion) {
                case 1 -> registrarEstudiante(sc, sistema);
                case 2 -> registrarProfesor(sc, sistema);
                case 3 -> registrarMateria(sc, sistema);
                case 4 -> registrarNota(sc, sistema);
                case 5 -> sistema.listarTodos();
                case 6 -> verPromedio(sc, sistema);
                case 0 -> System.out.println("Saliendo del sistema...");
                default -> System.out.println("Opción inválida.");
            }
        } while (opcion != 0);

        sc.close();
    }

    private static int leerEntero(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.out.print("Ingresa un numero válido: ");
            sc.next();
        }
        int valor = sc.nextInt();
        sc.nextLine();
        return valor;
    }

    private static void registrarEstudiante(Scanner sc, SistemaUCO sistema) {
        System.out.print("ID: ");
        String id = sc.nextLine();
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Correo: ");
        String correo = sc.nextLine();
        System.out.print("Programa: ");
        String programa = sc.nextLine();
        sistema.registrarPersona(new Estudiante(id, nombre, correo, programa));
        System.out.println("Estudiante registrado con exito.");
    }

    private static void registrarProfesor(Scanner sc, SistemaUCO sistema) {
        System.out.print("ID: ");
        String id = sc.nextLine();
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Correo: ");
        String correo = sc.nextLine();
        System.out.print("Especialidad: ");
        String especialidad = sc.nextLine();
        sistema.registrarPersona(new Profesor(id, nombre, correo, especialidad));
        System.out.println("Profesor registrado con exito.");
    }

    private static void registrarMateria(Scanner sc, SistemaUCO sistema) {
        System.out.print("Codigo: ");
        String codigo = sc.nextLine();
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        sistema.registrarMateria(new Materia(codigo, nombre));
        System.out.println("Materia registrada con exito.");
    }

    private static void registrarNota(Scanner sc, SistemaUCO sistema) {
        System.out.print("ID del estudiante: ");
        String id = sc.nextLine();
        Estudiante est = sistema.buscarEstudiantePorId(id);
        if (est == null) {
            System.out.println("No se encontro el estudiante.");
            return;
        }
        if (sistema.getMaterias().isEmpty()) {
            System.out.println("Primero debes registrar al menos una materia.");
            return;
        }
        System.out.println("Materias disponibles:");
        for (Materia m : sistema.getMaterias()) {
            System.out.println(" - " + m);
        }
        System.out.print("Codigo de la materia: ");
        String codigoMateria = sc.nextLine();
        Materia materia = null;
        for (Materia m : sistema.getMaterias()) {
            if (m.getCodigo().equals(codigoMateria)) {
                materia = m;
                break;
            }
        }
        if (materia == null) {
            System.out.println("Materia no encontrada.");
            return;
        }
        System.out.print("Nota (0.0 - 5.0): ");
        try {
            double valor = Double.parseDouble(sc.nextLine());
            sistema.registrarNota(est, materia, valor);
            System.out.println("Nota registrada.");
        } catch (NumberFormatException e) {
            System.out.println("Debes ingresar un numero valido.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void verPromedio(Scanner sc, SistemaUCO sistema) {
        System.out.print("ID del estudiante: ");
        String id = sc.nextLine();
        Estudiante est = sistema.buscarEstudiantePorId(id);
        if (est == null) {
            System.out.println("No se encontro el estudiante.");
            return;
        }
        System.out.println("Promedio de " + est.getNombre() + ": "
                + String.format("%.2f", est.calcularPromedio()));
    }
}
