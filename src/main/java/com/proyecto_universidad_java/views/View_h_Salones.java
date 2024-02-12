package com.proyecto_universidad_java.views;

import com.proyecto_universidad_java.repository.models.h_Salones;

public class View_h_Salones extends View_a_MainUniversidad {

    public static void startMenu() {

        int op = 0;

        do {

            op = mostrarMenu();
            System.out.print("\033[H\033[2J");
            System.out.flush();
            switch (op) {
                case 1:
                    crearSalones();
                    break;
                case 2:
                    listarSalones();
                    break;
                case 3:
                    buscarSalones();
                    break;
                case 4:
                    modificarSalones();
                    break;
                case 5:
                    eliminarSalones();
                    break;
                default:
                    System.out.println();
                    break;
            }

        } while (op >= 1 && op < 6);

    }

    public static int mostrarMenu() {
        System.out.println("----Menu--Salones----");
        System.out.println("1. Crear Salones.");
        System.out.println("2. Listar Salones.");
        System.out.println("3. Buscar Salones.");
        System.out.println("4. Modificar Salones.");
        System.out.println("5. Eliminar Salones.");
        System.out.println("6. Salir ");
        return leer.nextInt();
    }

    public static void crearSalones() {
        leer.nextLine();
        System.out.print("Nombre del salón: ");
        String nombre = leer.nextLine();
        System.out.print("Capacidad del salón:");
        int capacidad_salon = leer.nextInt();
        System.out.print("Precio compra: ");
        int piso = leer.nextInt();
        serviceSalones.crear(new h_Salones(nombre, capacidad_salon, piso));

    }

    public static void listarSalones() {
        System.out.println("Lista de Salones");
        for (h_Salones Salone : serviceSalones.listar()) {
            System.out.println(Salone.toString());
            System.out.println();
        }
    }

    public static void buscarSalones() {
        System.out.println("Busqueda de Salones ");
        leer.nextLine();
        System.out.print("Codigo: ");
        int codigo = leer.nextInt();
        h_Salones Salone = serviceSalones.porCodigo(codigo);
            System.out.println();
            System.out.println(Salone.toString());
        // try {
        //     Salones Salone = serviceSalones.porCodigo(codigo);
        //     System.out.println();
        //     System.out.println(Salone.toString());
        // } catch (SalonesNullException e) {
        //     System.out.println(e.getMessage());
        // }
    }

    public static h_Salones buscarGetSalones() {
        System.out.println("Busqueda de Salones ");
        leer.nextLine();
        System.out.print("Codigo: ");
        int codigo = leer.nextInt();
        return serviceSalones.porCodigo(codigo);

        // try {
        //     return serviceSalones.porCodigo(codigo);

        // } catch (SalonesNullException e) {
        //     System.out.println(e.getMessage());
        //     return null;
        // }
    }

    
    public static void modificarSalones() {
        h_Salones SaloneActual = buscarGetSalones();
        leer.nextLine();
        if (SaloneActual != null) {
            System.out.println();
            SaloneActual.toString();

            System.out.println("Modificar nombre del salón: si o no? ");
            String opcion = leer.nextLine();

            if (opcion.equalsIgnoreCase("si")) {
                System.out.println("Nombre del salón: ");
                String nuevoNombre = leer.nextLine();
                SaloneActual.setValor_salon(nuevoNombre);
                leer.nextLine();
            }
            System.out.println("Modificar capacidad del salón: si o no? ");
            opcion = leer.nextLine();

            if (opcion.equalsIgnoreCase("si")) {
                System.out.println("capacidad del salón: ");
                int capacidad = leer.nextInt();
                SaloneActual.setCapacidad_salon(capacidad);
                leer.nextLine();
            }
            System.out.println("Modificar piso edificio: si o no? ");
            opcion = leer.nextLine();

            if (opcion.equalsIgnoreCase("si")) {
                System.out.println("piso edificio: ");
                int piso_edificio = leer.nextInt();
                SaloneActual.setPiso_edificio(piso_edificio);
            }


            serviceSalones.editar(SaloneActual);
        }
    }

    public static void eliminarSalones() {       
        h_Salones Salone = buscarGetSalones();
        if (Salone != null) {
            serviceSalones.eliminar(Salone.getId_salon());
            System.out.println("El Salón se eliminó correctamente ");
        } else {
            System.out.println("Se presento un problema y no se puedo eliminar el Salon ");
        }

    }





}