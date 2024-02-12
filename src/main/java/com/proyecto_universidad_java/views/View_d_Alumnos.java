package com.proyecto_universidad_java.views;

import com.proyecto_universidad_java.repository.models.d_Alumnos;
import com.proyecto_universidad_java.repository.models.m_Personas;

public class View_d_Alumnos extends View_a_MainUniversidad {

    public static void startMenu() {

        int op = 0;

        do {

            op = mostrarMenu();
            System.out.print("\033[H\033[2J");
            System.out.flush();
            switch (op) {
                case 1:
                    crearAlumnos();
                    break;
                case 2:
                    listarAlumnos();
                    break;
                case 3:
                    buscarAlumnos();
                    break;
                case 4:
                    modificarAlumnos();
                    break;
                case 5:
                    eliminarAlumnos();
                    break;
                default:
                    System.out.println();
                    break;
            }

        } while (op >= 1 && op < 6);

    }

    public static int mostrarMenu() {
        System.out.println("\n----Menu--Alumnos----");
        System.out.println("1. Crear Alumnos.");
        System.out.println("2. Listar Alumnos.");
        System.out.println("3. Buscar Alumnos.");
        System.out.println("4. Modificar Alumnos.");
        System.out.println("5. Eliminar Alumnos.");
        System.out.println("6. Salir ");
        return leer.nextInt();
    }

    public static void crearAlumnos() {
        leer.nextLine();
        System.out.print("ID Persona: ");
        int id_persona = leer.nextInt();
        System.out.print("ID Programa:");
        int id_programa = leer.nextInt();
        serviceAlumnos.crear(new d_Alumnos(id_persona,id_programa));

    }

    public static void listarAlumnos() {
        System.out.println("\nLista de Alumnos");
        for (m_Personas Alumno : serviceAlumnos.toList()) {
            // System.out.println(Alumno.toString());
            // System.out.println();
            Alumno.print();
        }
    }

    public static void buscarAlumnos() {
        System.out.println("Busqueda de Alumnos ");
        leer.nextLine();
        System.out.print("Codigo: ");
        int codigo = leer.nextInt();
        d_Alumnos Alumnos = serviceAlumnos.porCodigo(codigo);
            System.out.println();
            System.out.println(Alumnos.toString());
        // try {
        //     d_Alumnos Alumnos = serviceAlumnos.porCodigo(codigo);
        //     System.out.println();
        //     System.out.println(Alumnos.toString());
        // } catch (AlumnosNullException e) {
        //     System.out.println(e.getMessage());
        // }
    }

    public static d_Alumnos buscarGetAlumnos() {
        System.out.println("Busqueda de Alumnos ");
        leer.nextLine();
        System.out.print("Codigo: ");
        int codigo = leer.nextInt();
        return serviceAlumnos.porCodigo(codigo);

        // try {
        //     return serviceAlumnos.porCodigo(codigo);

        // } catch (AlumnosNullException e) {
        //     System.out.println(e.getMessage());
        //     return null;
        // }
    }

    
    public static void modificarAlumnos() {
        d_Alumnos AlumnosActual = buscarGetAlumnos();
        leer.nextLine();
        if (AlumnosActual != null) {
            System.out.println();
            AlumnosActual.toString();

            System.out.println("Modificar id persona: si o no? ");
            String opcion = leer.nextLine();

            if (opcion.equalsIgnoreCase("si")) {
                System.out.println("id persona: ");
                int id_persona = leer.nextInt();
                AlumnosActual.setId_persona(id_persona);
                leer.nextLine();
            }
            System.out.println("Modificar id_programa: si o no? ");
            opcion = leer.nextLine();

            if (opcion.equalsIgnoreCase("si")) {
                System.out.println("id_programa: ");
                int id_programa = leer.nextInt();
                AlumnosActual.setId_programa(id_programa);
                leer.nextLine();

            }

            serviceAlumnos.editar(AlumnosActual);
        }
    }

    public static void eliminarAlumnos() {       
        d_Alumnos Alumnos = buscarGetAlumnos();
        if (Alumnos != null) {
            serviceAlumnos.eliminar(Alumnos.getId_estudiante());
            System.out.println("El Alumno se elimino correctamente ");
        } else {
            System.out.println("Se presento un problema y no se puedo eliminar el Alumno ");
        }

    }





}