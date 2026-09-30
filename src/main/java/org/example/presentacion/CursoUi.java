package org.example.presentacion;

import org.example.business.Curso;
import org.example.business.CursoService;
import java.util.Scanner;

public class CursoUI {
    private static final CursoService service = new CursoService();

    public static void mostrarMenu(Scanner sc) {
        int opcion;
        do {
            System.out.println("\n=== GESTIÓN CURSOS ===");
            System.out.println("1. Registrar");
            System.out.println("2. Listar");
            System.out.println("3. Actualizar");
            System.out.println("4. Eliminar");
            System.out.println("0. Regresar");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Id: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Nombre del Curso: ");
                    String nombre = sc.nextLine();
                    System.out.print("Créditos: ");
                    int creditos = sc.nextInt();
                    sc.nextLine();
                    service.registrar(new Curso(id, nombre, creditos));
                    System.out.println("Curso Registrado correctamente.");
                    break;

                case 2:
                    System.out.println("\n--- Lista de Cursos ---");
                    service.listar().forEach(c -> 
                        System.out.println("ID: " + c.getId() + " | Nombre: " + c.getNombre() + " | Créditos: " + c.getCreditos())
                    );
                    break;

                case 3:
                    System.out.print("Id a actualizar: ");
                    int idAct = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Nuevo Nombre: ");
                    String nomAct = sc.nextLine();
                    System.out.print("Nuevos Créditos: ");
                    int credAct = sc.nextInt();
                    sc.nextLine();
                    if (service.actualizar(new Curso(idAct, nomAct, credAct))) {
                        System.out.println("Curso actualizado correctamente.");
                    } else {
                        System.out.println("Curso no encontrado.");
                    }
                    break;

                case 4:
                    System.out.print("Id a eliminar: ");
                    int idElim = sc.nextInt();
                    sc.nextLine();
                    if (service.eliminar(idElim)) {
                        System.out.println("Curso eliminado correctamente.");
                    } else {
                        System.out.println("Curso no encontrado.");
                    }
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Opción no válida");
            }
        } while (opcion != 0);
    }
}