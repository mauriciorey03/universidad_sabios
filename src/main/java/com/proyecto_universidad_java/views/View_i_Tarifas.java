package com.proyecto_universidad_java.views;

import com.proyecto_universidad_java.repository.models.i_Tarifas;

public class View_i_Tarifas extends View_a_MainUniversidad {

    public static void startMenu() {

        int op = 0;

        do {

            op = mostrarMenu();
            System.out.print("\033[H\033[2J");
            System.out.flush();
            switch (op) {
                case 1:
                    crearTarifas();
                    break;
                case 2:
                    listarTarifas();
                    break;
                case 3:
                    buscarTarifas();
                    break;
                case 4:
                    //modificarTarifas();
                    break;
                case 5:
                    eliminarTarifas();
                    break;
                default:
                    System.out.println();
                    break;
            }

        } while (op >= 1 && op < 6);

    }

    public static int mostrarMenu() {
        System.out.println("----Menu--Tarifas----");
        System.out.println("1. Crear Tarifas.");
        System.out.println("2. Listar Tarifas.");
        System.out.println("3. Buscar Tarifas.");
        System.out.println("4. Modificar Tarifas.");
        System.out.println("5. Eliminar Tarifas.");
        System.out.println("6. Salir ");
        return leer.nextInt();
    }

    public static void crearTarifas() {
        leer.nextLine();
        System.out.print("Valor crédito:");
        double valor_credito = leer.nextDouble();
        System.out.print("id_programa: ");
        int id_programa = leer.nextInt();
        System.out.print("id_periodo: ");
        int id_periodo=leer.nextInt();
        serviceTarifas.crear(new i_Tarifas(valor_credito, id_programa,id_periodo));

    }

    public static void listarTarifas() {
        System.out.println("Lista de Tarifas");
        for (i_Tarifas Tarifa : serviceTarifas.listar()) {
            System.out.println(Tarifa.toString());
            System.out.println();
        }
    }

    public static void buscarTarifas() {
        System.out.println("Busqueda de Tarifas ");
        leer.nextLine();
        System.out.print("Codigo: ");
        int codigo = leer.nextInt();
        i_Tarifas Tarifa = serviceTarifas.porCodigo(codigo);
            System.out.println();
            System.out.println(Tarifa.toString());
        // try {
        //     Tarifas Tarifa = serviceTarifas.porCodigo(codigo);
        //     System.out.println();
        //     System.out.println(Tarifa.toString());
        // } catch (TarifasNullException e) {
        //     System.out.println(e.getMessage());
        // }
    }

    public static i_Tarifas buscarGetTarifas() {
        System.out.println("Busqueda de Tarifas ");
        leer.nextLine();
        System.out.print("Codigo: ");
        int codigo = leer.nextInt();
        return serviceTarifas.porCodigo(codigo);

        // try {
        //     return serviceTarifas.porCodigo(codigo);

        // } catch (TarifasNullException e) {
        //     System.out.println(e.getMessage());
        //     return null;
        // }
    }

    
    // public static void modificarTarifas() {
    //     Tarifas TarifaActual = buscarGetTarifas();
    //     leer.nextLine();
    //     if (TarifaActual != null) {
    //         System.out.println();
    //         TarifaActual.toString();

    //         System.out.println("Modificar nombre: si o no? ");
    //         String opcion = leer.nextLine();

    //         if (opcion.equalsIgnoreCase("si")) {
    //             System.out.println("Nombre: ");
    //             String nuevoNombre = leer.nextLine();
    //             TarifaActual.setNombre(nuevoNombre);
    //         }
    //         System.out.println("Modificar precio venta: si o no? ");
    //         opcion = leer.nextLine();

    //         if (opcion.equalsIgnoreCase("si")) {
    //             System.out.println("Precio venta: ");
    //             double precioVenta = leer.nextDouble();
    //             TarifaActual.setPrecioVenta(precioVenta);
    //         }
    //         System.out.println("Modificar precio compra: si o no? ");
    //         opcion = leer.nextLine();

    //         if (opcion.equalsIgnoreCase("si")) {
    //             System.out.println("Precio compra: ");
    //             double precioCompra = leer.nextDouble();
    //             TarifaActual.setPrecioCompra(precioCompra);
    //         }

    //         System.out.println("Descripción: si o no? ");
    //         opcion = leer.nextLine();

    //         if (opcion.equalsIgnoreCase("si")) {
    //             System.out.println("Descripción: ");
    //             String descripcion = leer.nextLine();
    //             TarifaActual.setDescripcion(descripcion);
    //         }

    //         serviceTarifas.editar(TarifaActual);
    //     }
    // }

    public static void eliminarTarifas() {       
        i_Tarifas Tarifa = buscarGetTarifas();
        if (Tarifa != null) {
            serviceTarifas.eliminar(Tarifa.getId_valor_matricula());
            System.out.println("El Tarifas se eliminó correctamente ");
        } else {
            System.out.println("Se presentó un problema y no se puedo eliminar el Tarifas ");
        }

    }





}