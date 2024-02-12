package com.proyecto_universidad_java.views;

import com.proyecto_universidad_java.repository.models.f_Asignaturas;

public class View_f_Asignaturas extends View_a_MainUniversidad {

    public static void startMenu() {

        int op = 0;

        do {

            op = mostrarMenu();
            System.out.print("\033[H\033[2J");
            System.out.flush();
            switch (op) {
                case 1:
                    crearAsignaturas();
                    break;
                case 2:
                    listarAsignaturas();
                    break;
                case 3:
                    buscarAsignaturas();
                    break;
                case 4:
                    modificarAsignaturas();
                    break;
                case 5:
                    eliminarAsignaturas();
                    break;
                default:
                    System.out.println();
                    break;
            }

        } while (op >= 1 && op < 6);

    }

    public static int mostrarMenu() {
        System.out.println("----Menu--Asignaturas----");
        System.out.println("1. Crear Asignaturas.");
        System.out.println("2. Listar Asignaturas.");
        System.out.println("3. Buscar Asignaturas.");
        System.out.println("4. Modificar Asignaturas.");
        System.out.println("5. Eliminar Asignaturas.");
        System.out.println("6. Salir ");
        return leer.nextInt();
    }

    public static void crearAsignaturas() {
        leer.nextLine();
        System.out.print("Nombre de la materia: ");
        String nombre = leer.nextLine();
        System.out.print("Creditos:");
        int creditos = leer.nextInt();
        System.out.print("Cantidad de estudiantes: ");
        int cantidad = leer.nextInt();
        serviceAsignaturas.crear(new f_Asignaturas(nombre, creditos, cantidad));

    }

    public static void listarAsignaturas() {
        System.out.println("Lista de Asignaturas");
        for (f_Asignaturas Asignatura : serviceAsignaturas.listar()) {
            System.out.println(Asignatura.toString());
            System.out.println();
        }
    }

    public static void buscarAsignaturas() {
        System.out.println("Busqueda de Asignaturas ");
        leer.nextLine();
        System.out.print("Codigo: ");
        int codigo = leer.nextInt();
        f_Asignaturas Asignatura = serviceAsignaturas.porCodigo(codigo);
            System.out.println();
            System.out.println(Asignatura.toString());
        // try {
        //     f_Asignaturas Asignatura = serviceAsignaturas.porCodigo(codigo);
        //     System.out.println();
        //     System.out.println(Asignatura.toString());
        // } catch (AsignaturasNullException e) {
        //     System.out.println(e.getMessage());
        // }
    }

    public static f_Asignaturas buscarGetAsignaturas() {
        System.out.println("Busqueda de Asignaturas ");
        leer.nextLine();
        System.out.print("Codigo: ");
        int codigo = leer.nextInt();
        return serviceAsignaturas.porCodigo(codigo);

        // try {
        //     return serviceAsignaturas.porCodigo(codigo);

        // } catch (AsignaturasNullException e) {
        //     System.out.println(e.getMessage());
        //     return null;
        // }
    }

    
    public static void modificarAsignaturas() {
        f_Asignaturas AsignaturaActual = buscarGetAsignaturas();
        leer.nextLine();
        if (AsignaturaActual != null) {
            System.out.println();
            AsignaturaActual.toString();

            System.out.println("Modificar nombre de la materia: si o no? ");
            String opcion = leer.nextLine();

            if (opcion.equalsIgnoreCase("si")) {
                System.out.println("Nombre de la materia: ");
                String nuevoNombre = leer.nextLine();
                AsignaturaActual.setNombre_materia(nuevoNombre);
                leer.nextLine();

            }
            System.out.println("Modificar creditos: si o no? ");
            opcion = leer.nextLine();

            if (opcion.equalsIgnoreCase("si")) {
                System.out.println("creditos: ");
                int creditos = leer.nextInt();
                AsignaturaActual.setCreditos(creditos);
                leer.nextLine();
            }
            System.out.println("Modificar cantidad estudiantes: si o no? ");
            opcion = leer.nextLine();

            if (opcion.equalsIgnoreCase("si")) {
                System.out.println("Precio compra: ");
                int cantidad_estudiantes = leer.nextInt();
                AsignaturaActual.setCantidad_estudiantes(cantidad_estudiantes);

            }


            serviceAsignaturas.editar(AsignaturaActual);
        }
    }

    public static void eliminarAsignaturas() {       
        f_Asignaturas Asignatura = buscarGetAsignaturas();
        if (Asignatura != null) {
            serviceAsignaturas.eliminar(Asignatura.getId_materia());
            System.out.println("El Asignaturas se elimino correctamente ");
        } else {
            System.out.println("Se presento un problema y no se puedo eliminar el Asignaturas ");
        }

    }





}