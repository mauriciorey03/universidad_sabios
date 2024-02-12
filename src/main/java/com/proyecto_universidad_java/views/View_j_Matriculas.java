package com.proyecto_universidad_java.views;

import com.proyecto_universidad_java.repository.models.j_Matriculas;

public class View_j_Matriculas extends View_a_MainUniversidad {

    public static void startMenu() {

        int op = 0;

        do {

            op = mostrarMenu();
            System.out.print("\033[H\033[2J");
            System.out.flush();
            switch (op) {
                case 1:
                    crearMatricula();
                    break;
                case 2:
                    listarMatriculas();
                    break;
                case 3:
                    buscarMatriculas();
                    break;
                case 4:
                    modificarMatricula();
                    break;
                case 5:
                    eliminarMatricula();
                    break;
                default:
                    System.out.println();
                    break;
            }

        } while (op >= 1 && op < 6);

    }

    public static int mostrarMenu() {
        System.out.println("----Menu--Matriculas----");
        System.out.println("1. Crear Matriculas.");
        System.out.println("2. Listar Matriculas.");
        System.out.println("3. Buscar Matriculas.");
        System.out.println("4. Modificar Matriculas.");
        System.out.println("5. Eliminar Matriculas.");
        System.out.println("6. Salir ");
        return leer.nextInt();
    }

    public static void crearMatricula() {
        leer.nextLine();
        System.out.print("id_estudiante: ");
        int estudiante = leer.nextInt();
        System.out.print("id_periodo:");
        int id_periodo = leer.nextInt();
        System.out.print("id_materia: ");
        int id_materia = leer.nextInt();
        serviceMatriculas.crear(new j_Matriculas(estudiante, id_periodo, id_materia));

    }

    public static void listarMatriculas() {
        System.out.println("Lista de Matricula");
        for (j_Matriculas Matricula : serviceMatriculas.listar()) {
            System.out.println(Matricula.toString());
            System.out.println();
        }
    }

    public static void buscarMatriculas() {
        System.out.println("Busqueda de Matricula ");
        leer.nextLine();
        System.out.print("Codigo: ");
        int codigo = leer.nextInt();
        j_Matriculas Matricula = serviceMatriculas.porCodigo(codigo);
            System.out.println();
            System.out.println(Matricula.toString());
        // try {
        //     j_Matricula Matricula = serviceMatriculas.porCodigo(codigo);
        //     System.out.println();
        //     System.out.println(Matricula.toString());
        // } catch (MatriculaNullException e) {
        //     System.out.println(e.getMessage());
        // }
    }

    public static j_Matriculas buscarGetMatricula() {
        System.out.println("Busqueda de Matricula ");
        leer.nextLine();
        System.out.print("Codigo: ");
        int codigo = leer.nextInt();
        return serviceMatriculas.porCodigo(codigo);

        // try {
        //     return serviceMatricula.porCodigo(codigo);

        // } catch (MatriculaNullException e) {
        //     System.out.println(e.getMessage());
        //     return null;
        // }
    }

    
    public static void modificarMatricula() {
        j_Matriculas MatriculaActual = buscarGetMatricula();
        leer.nextLine();
        if (MatriculaActual != null) {
            System.out.println();
            MatriculaActual.toString();

            System.out.println("Modificar id_estudiante: si o no? ");
            String opcion = leer.nextLine();

            if (opcion.equalsIgnoreCase("si")) {
                System.out.println("id_estudiante: ");
                int id_estudiante = leer.nextInt();
                MatriculaActual.setId_estudiante(id_estudiante);
                leer.nextLine();
            }
            System.out.println("Modificar id_periodo: si o no? ");
            opcion = leer.nextLine();

            if (opcion.equalsIgnoreCase("si")) {
                System.out.println("id_periodo: ");
                int id_periodo = leer.nextInt();
                MatriculaActual.setId_periodo(id_periodo);
                leer.nextLine();
            }
            System.out.println("Modificar id_materia: si o no? ");
            opcion = leer.nextLine();

            if (opcion.equalsIgnoreCase("si")) {
                System.out.println("id_materia: ");
                int id_materia = leer.nextInt();
                MatriculaActual.setId_materia(id_materia);;
            }

            serviceMatriculas.editar(MatriculaActual);
        }
    }

    public static void eliminarMatricula() {       
        j_Matriculas Matricula = buscarGetMatricula();
        if (Matricula != null) {
            serviceMatriculas.eliminar(Matricula.getId_registro());
            System.out.println("La Matricula se eliminó correctamente ");
        } else {
            System.out.println("Se presento un problema y no se puedo eliminar la Matricula ");
        }

    }





}