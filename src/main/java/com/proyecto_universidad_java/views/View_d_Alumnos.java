package com.proyecto_universidad_java.views;

import com.proyecto_universidad_java.repository.models.d_Alumnos;

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
                    //modificarAlumnos();
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
        System.out.println("----Menu--Alumnos----");
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
        System.out.print("Nombre: ");
        int id_persona = leer.nextInt();
        System.out.print("Precio venta:");
        int id_programa = leer.nextInt();
        serviceAlumnos.crear(new d_Alumnos(id_persona,id_programa));

    }

    public static void listarAlumnos() {
        System.out.println("Lista de Alumnos");
        for (d_Alumnos Alumno : serviceAlumnos.listar()) {
            System.out.println(Alumno.toString());
            System.out.println();
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

    
    // public static void modificarAlumnos() {
    //     d_Alumnos AlumnosActual = buscarGetAlumnos();
    //     leer.nextLine();
    //     if (AlumnosActual != null) {
    //         System.out.println();
    //         AlumnosActual.toString();

    //         System.out.println("Modificar nombre: si o no? ");
    //         String opcion = leer.nextLine();

    //         if (opcion.equalsIgnoreCase("si")) {
    //             System.out.println("Nombre: ");
    //             String nuevoNombre = leer.nextLine();
    //             AlumnosActual.setNombre(nuevoNombre);
    //         }
    //         System.out.println("Modificar precio venta: si o no? ");
    //         opcion = leer.nextLine();

    //         if (opcion.equalsIgnoreCase("si")) {
    //             System.out.println("Precio venta: ");
    //             double precioVenta = leer.nextDouble();
    //             AlumnosActual.setPrecioVenta(precioVenta);
    //         }
    //         System.out.println("Modificar precio compra: si o no? ");
    //         opcion = leer.nextLine();

    //         if (opcion.equalsIgnoreCase("si")) {
    //             System.out.println("Precio compra: ");
    //             double precioCompra = leer.nextDouble();
    //             AlumnosActual.setPrecioCompra(precioCompra);
    //         }

    //         System.out.println("Descripción: si o no? ");
    //         opcion = leer.nextLine();

    //         if (opcion.equalsIgnoreCase("si")) {
    //             System.out.println("Descripción: ");
    //             String descripcion = leer.nextLine();
    //             AlumnosActual.setDescripcion(descripcion);
    //         }

    //         serviceAlumnos.editar(AlumnosActual);
    //     }
    // }

    public static void eliminarAlumnos() {       
        d_Alumnos Alumnos = buscarGetAlumnos();
        if (Alumnos != null) {
            serviceAlumnos.eliminar(Alumnos.getId_estudiante());
            System.out.println("El Alumnos se elmino correctamente ");
        } else {
            System.out.println("Se presento un proplema y no se puedo eliminar el Alumnos ");
        }

    }





}