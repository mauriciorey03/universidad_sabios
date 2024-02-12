package com.proyecto_universidad_java.views;
// carpeta views
// import com.campusland.exceptiones.clienteexceptions.DepartamentosNullException;
// import com.campusland.respository.models.Departamentos;

import com.proyecto_universidad_java.repository.models.b_Departamentos;

public class View_b_Departamentos extends View_a_MainUniversidad {

    public static void startMenu() {

        int op = 0;

        do {

            op = mostrarMenu();
            System.out.print("\033[H\033[2J");
            System.out.flush();
            switch (op) {
                case 1:
                    crearDepartamentos();
                    break;
                case 2:
                    listarDepartamentos();
                    break;
                case 3:
                    buscarDepartamentos();
                    break;
                case 4:
                    modificarDepartamentos();
                    break;
                case 5:
                    eliminarDepartamentos();
                    break;
                default:
                    System.out.println();
                    break;
            }

        } while (op >= 1 && op < 6);

    }

    public static int mostrarMenu() {
        System.out.println("\n----Menu--Departamentos----");
        System.out.println("1. Crear Departamentos.");
        System.out.println("2. Listar Departamentos.");
        System.out.println("3. Buscar Departamentos.");
        System.out.println("4. Modificar Departamentos.");
        System.out.println("5. Eliminar Departamentos.");
        System.out.println("6. Salir ");
        return leer.nextInt();
    }

    public static void crearDepartamentos() {
        leer.nextLine();
        System.out.print("Nombre: ");
        String nombre = leer.nextLine();
        serviceDepartamento.crear(new b_Departamentos(nombre));

    }

    public static void listarDepartamentos() {
        System.out.println("\nLista de Departamentos");
        for (b_Departamentos departamento : serviceDepartamento.listar()) {
            // System.out.println(departamento.toString());
            departamento.print();
        }
    }

    public static void buscarDepartamentos() {
        System.out.println("Busqueda de Departamentos ");
        leer.nextLine();
        System.out.print("Codigo: ");
        int codigo = leer.nextInt();
        b_Departamentos departamento = serviceDepartamento.porCodigo(codigo);
            System.out.println();
            System.out.println(departamento.toString());
    }
    //     try {
    //         Departamentos departamento = serviceDepartamentos.porCodigo(codigo);
    //         System.out.println();
    //         System.out.println(departamento.toString());
    //     } catch (DepartamentosNullException e) {
    //         System.out.println(e.getMessage());
    //     }
    // }

    public static b_Departamentos buscarGetDepartamentos() {
        System.out.println("Busqueda de Departamentos ");
        leer.nextLine();
        System.out.print("Codigo: ");
        int codigo = leer.nextInt();
        return serviceDepartamento.porCodigo(codigo);

        // try {
        //     return serviceDepartamentos.porCodigo(codigo);

        // } catch (DepartamentosNullException e) {
        //     System.out.println(e.getMessage());
        //     return null;
        // }
    }

    
    public static void modificarDepartamentos() {
        b_Departamentos DepartamentoActual = buscarGetDepartamentos();
        leer.nextLine();
        if (DepartamentoActual != null) {
            System.out.println();
            DepartamentoActual.toString();

            System.out.println("Modificar nombre: si o no? ");
            String opcion = leer.nextLine();

            if (opcion.equalsIgnoreCase("si")) {
                System.out.println("Nombre de la facultad: ");
                String nuevoNombre = leer.nextLine();
                DepartamentoActual.setNombre_facultad(nuevoNombre);
            }
            serviceDepartamento.editar(DepartamentoActual);
        }
    }

    public static void eliminarDepartamentos() {       
        b_Departamentos departamento = buscarGetDepartamentos();
        if (departamento != null) {
            serviceDepartamento.eliminar(departamento.getId_facultad());
            System.out.println("El Departamento se elmino correctamente ");
        } else {
            System.out.println("Se presento un proplema y no se puedo eliminar el Departamentos ");
        }

    }





    }
