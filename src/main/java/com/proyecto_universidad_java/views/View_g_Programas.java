package com.proyecto_universidad_java.views;

import com.proyecto_universidad_java.repository.models.g_Programas;

public class View_g_Programas extends View_a_MainUniversidad {

    public static void startMenu() {

        int op = 0;

        do {

            op = mostrarMenu();
            System.out.print("\033[H\033[2J");
            System.out.flush();
            switch (op) {
                case 1:
                    crearProgramas();
                    break;
                case 2:
                    listarProgramas();
                    break;
                case 3:
                    buscarProgramas();
                    break;
                case 4:
                    modificarProgramas();
                    break;
                case 5:
                    eliminarProgramas();
                    break;
                default:
                    System.out.println();
                    break;
            }

        } while (op >= 1 && op < 6);

    }

    public static int mostrarMenu() {
        System.out.println("----Menu--Programas----");
        System.out.println("1. Crear Programas.");
        System.out.println("2. Listar Programas.");
        System.out.println("3. Buscar Programas.");
        System.out.println("4. Modificar Programas.");
        System.out.println("5. Eliminar Programas.");
        System.out.println("6. Salir ");
        return leer.nextInt();
    }

    public static void crearProgramas() {
        leer.nextLine();
        System.out.print("Nombre del programa: ");
        String nombre = leer.nextLine();
        System.out.print("Categoria:");
        String categoria = leer.nextLine();
        serviceProgramas.crear(new g_Programas(nombre, categoria));

    }

    public static void listarProgramas() {
        System.out.println("Lista de Programas");
        for (g_Programas Programa : serviceProgramas.listar()) {
            System.out.println(Programa.toString());
            System.out.println();
        }
    }

    public static void buscarProgramas() {
        System.out.println("Busqueda de Programas ");
        leer.nextLine();
        System.out.print("Codigo: ");
        int codigo = leer.nextInt();
        g_Programas Programa = serviceProgramas.porCodigo(codigo);
            System.out.println();
            System.out.println(Programa.toString());
        // try {
        //     Programas Programa = serviceProgramas.porCodigo(codigo);
        //     System.out.println();
        //     System.out.println(Programa.toString());
        // } catch (ProgramasNullException e) {
        //     System.out.println(e.getMessage());
        // }
    }

    public static g_Programas buscarGetProgramas() {
        System.out.println("Busqueda de Programas ");
        leer.nextLine();
        System.out.print("Codigo: ");
        int codigo = leer.nextInt();
        return serviceProgramas.porCodigo(codigo);

        // try {
        //     return serviceProgramas.porCodigo(codigo);

        // } catch (ProgramasNullException e) {
        //     System.out.println(e.getMessage());
        //     return null;
        // }
    }

    
    public static void modificarProgramas() {
        g_Programas ProgramaActual = buscarGetProgramas();
        leer.nextLine();
        if (ProgramaActual != null) {
            System.out.println();
            ProgramaActual.toString();

            System.out.println("Modificar nombre programa: si o no? ");
            String opcion = leer.nextLine();

            if (opcion.equalsIgnoreCase("si")) {
                System.out.println("Nombre programa: ");
                String nuevoNombre = leer.nextLine();
                ProgramaActual.setNombre_programa(nuevoNombre);
                leer.nextLine();

            }
            System.out.println("Modificar Categoria: si o no? ");
            opcion = leer.nextLine();

            if (opcion.equalsIgnoreCase("si")) {
                System.out.println("Categoria: ");
                String categoria = leer.nextLine();
                ProgramaActual.setCategoria(categoria);
            }

            serviceProgramas.editar(ProgramaActual);
        }
    }

    public static void eliminarProgramas() {       
        g_Programas Programa = buscarGetProgramas();
        if (Programa != null) {
            serviceProgramas.eliminar(Programa.getId_programa());
            System.out.println("El Programas se elimino correctamente ");
        } else {
            System.out.println("Se presento un problema y no se puedo eliminar el Programas ");
        }

    }





}