package com.proyecto_universidad_java.views;

import com.proyecto_universidad_java.repository.models.e_Cursos;

public class View_e_Cursos extends View_a_MainUniversidad {

    public static void startMenu() {

        int op = 0;

        do {

            op = mostrarMenu();
            System.out.print("\033[H\033[2J");
            System.out.flush();
            switch (op) {
                case 1:
                    crearCurso();
                    break;
                case 2:
                    listarCursos();
                    break;
                case 3:
                    buscarCursos();
                    break;
                case 4:
                    modificarCursos();
                    break;
                case 5:
                    eliminarCurso();
                    break;
                default:
                    System.out.println();
                    break;
            }

        } while (op >= 1 && op < 6);

    }

    public static int mostrarMenu() {
        System.out.println("\n----Menu--Cursos----");
        System.out.println("1. Crear Cursos.");
        System.out.println("2. Listar Cursos.");
        System.out.println("3. Buscar Cursos.");
        System.out.println("4. Modificar Cursos.");
        System.out.println("5. Eliminar Cursos.");
        System.out.println("6. Salir ");
        return leer.nextInt();
    }

    public static void crearCurso() {
        leer.nextLine();
        System.out.print("Nombre curso: ");
        String nombre = leer.nextLine();
        System.out.print("Guía del curso:");
        String descripcion = leer.nextLine();
        serviceCursos.crear(new e_Cursos(nombre, descripcion));

    }

    public static void listarCursos() {
        System.out.println("\nLista de Cursos");
        for (e_Cursos Curso : serviceCursos.listar()) {
            // System.out.println(Curso.toString());
            // System.out.println();
            Curso.print();
        }
    }

    public static void buscarCursos() {
        System.out.println("Busqueda de Curso ");
        leer.nextLine();
        System.out.print("Codigo: ");
        int codigo = leer.nextInt();
        e_Cursos Curso = serviceCursos.porCodigo(codigo);
            System.out.println();
            System.out.println(Curso.toString());
        // try {
        //     e_Cursos Curso = serviceCursos.porCodigo(codigo);
        //     System.out.println();
        //     System.out.println(Curso.toString());
        // } catch (CursoNullException e) {
        //     System.out.println(e.getMessage());
        // }
    }

    public static e_Cursos buscarGetCurso() {
        System.out.println("Busqueda de Curso ");
        leer.nextLine();
        System.out.print("Codigo: ");
        int codigo = leer.nextInt();
        return serviceCursos.porCodigo(codigo);

        // try {
        //     return serviceCursos.porCodigo(codigo);

        // } catch (CursoNullException e) {
        //     System.out.println(e.getMessage());
        //     return null;
        // }
    }

    
    public static void modificarCursos() {
        e_Cursos CursoActual = buscarGetCurso();
        leer.nextLine();
        if (CursoActual != null) {
            System.out.println();
            CursoActual.toString();

            System.out.println("Modificar Nombre curso: si o no? ");
            String opcion = leer.nextLine();

            if (opcion.equalsIgnoreCase("si")) {
                System.out.println("Nombre curso: ");
                String nuevoNombre = leer.nextLine();
                CursoActual.setNombre_curso(nuevoNombre);
                leer.nextLine();

            }
            System.out.println("Modificar guia curso: si o no? ");
            opcion = leer.nextLine();

            if (opcion.equalsIgnoreCase("si")) {
                System.out.println("guia curso: ");
                String guia_curso = leer.nextLine();
                CursoActual.setGuia_curso(guia_curso);
            }
            serviceCursos.editar(CursoActual);
        }
    }

    public static void eliminarCurso() {       
        e_Cursos Curso = buscarGetCurso();
        if (Curso != null) {
            serviceCursos.eliminar(Curso.getId_curso());
            System.out.println("El Curso se elimino correctamente ");
        } else {
            System.out.println("Se presento un problema y no se puedo eliminar el Curso ");
        }

    }





}