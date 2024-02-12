package com.proyecto_universidad_java.views;
// carpeta views
// import com.campusland.exceptiones.clienteexceptions.ProfesoresNullException;
// import com.campusland.respository.models.Profesores;

import com.proyecto_universidad_java.repository.models.c_Profesores;

public class View_c_Profesores extends View_a_MainUniversidad {

    public static void startMenu() {

        int op = 0;

        do {

            op = mostrarMenu();
            System.out.print("\033[H\033[2J");
            System.out.flush();
            switch (op) {
                case 1:
                    crearProfesores();
                    break;
                case 2:
                    listarProfesores();
                    break;
                case 3:
                    buscarProfesores();
                    break;
                case 4:
                    modificarProfesores();
                    break;
                case 5:
                    eliminarProfesores();
                    break;
                default:
                    System.out.println();
                    break;
            }

        } while (op >= 1 && op < 6);

    }

    public static int mostrarMenu() {
        System.out.println("----Menu--Profesores----");
        System.out.println("1. Crear Profesores.");
        System.out.println("2. Listar Profesores.");
        System.out.println("3. Buscar Profesores.");
        System.out.println("4. Modificar Profesores.");
        System.out.println("5. Eliminar Profesores.");
        System.out.println("6. Salir ");
        return leer.nextInt();
    }

    public static void crearProfesores() {
        leer.nextLine();
        System.out.print("id_persona: ");
        int id_persona = leer.nextInt();
        System.out.print("id_facultad:");
        int id_facultad = leer.nextInt();
        serviceProfesores.crear(new c_Profesores(id_persona, id_facultad));

    }

    public static void listarProfesores() {
        System.out.println("Lista de Profesores");
        for (c_Profesores profesores : serviceProfesores.listar()) {
            System.out.println(profesores.toString());
            System.out.println();
        }
    }

    public static void buscarProfesores() {
        System.out.println("Busqueda de Profesores ");
        leer.nextLine();
        System.out.print("Codigo: ");
        int codigo = leer.nextInt();
        c_Profesores profesores = serviceProfesores.porCodigo(codigo);
            System.out.println();
            System.out.println(profesores.toString());
        // try {
        //     Profesores profesores = serviceProfesores.porCodigo(codigo);
        //     System.out.println();
        //     System.out.println(profesores.toString());
        // } catch (ProfesoresNullException e) {
        //     System.out.println(e.getMessage());
        // }
    }

    public static c_Profesores buscarGetProfesores() {
        System.out.println("Busqueda de Profesores ");
        leer.nextLine();
        System.out.print("Codigo: ");
        int codigo = leer.nextInt();
        return serviceProfesores.porCodigo(codigo);

        // try {
        //     return serviceProfesores.porCodigo(codigo);

        // } catch (ProfesoresNullException e) {
        //     System.out.println(e.getMessage());
        //     return null;
        // }
    }

    
    public static void modificarProfesores() {
        c_Profesores profesoresActual = buscarGetProfesores();
        leer.nextLine();
        if (profesoresActual != null) {
            System.out.println();
            profesoresActual.toString();

            System.out.println("Modificar id_persona: si o no? ");
            String opcion = leer.nextLine();

            if (opcion.equalsIgnoreCase("si")) {
                System.out.println("id_persona: ");
                int id_persona = leer.nextInt();
                profesoresActual.setId_persona(id_persona);
            }
            System.out.println("Modificar id_facultad: si o no? ");
            opcion = leer.nextLine();

            if (opcion.equalsIgnoreCase("si")) {
                System.out.println("id_facultad: ");
                int id_facultad = leer.nextInt();
                profesoresActual.setId_facultad(id_facultad);
            }
            
            serviceProfesores.editar(profesoresActual);
        }
    }

    public static void eliminarProfesores() {       
        c_Profesores profesores = buscarGetProfesores();
        if (profesores != null) {
            serviceProfesores.eliminar(profesores.getId_profesor());
            System.out.println("El Profesor se elimino correctamente ");
        } else {
            System.out.println("Se presento un proplema y no se puedo eliminar el Profesores ");
        }

    }





}