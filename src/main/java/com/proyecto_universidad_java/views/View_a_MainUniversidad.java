package com.proyecto_universidad_java.views;

import java.util.Scanner;

import com.proyecto_universidad_java.repository.impl.Repository_b_DepartamentosMysqlImpl;
import com.proyecto_universidad_java.repository.impl.Repository_c_ProfesoresMysqlImpl;
import com.proyecto_universidad_java.repository.impl.Repository_d_AlumnosMysqlImpl;
import com.proyecto_universidad_java.repository.impl.Repository_e_CursosMysqlImpl;
import com.proyecto_universidad_java.repository.impl.Repository_f_AsignaturasMysqlImpl;
import com.proyecto_universidad_java.repository.impl.Repository_g_ProgramasMysqlImpl;
import com.proyecto_universidad_java.repository.impl.Repository_h_SalonesMysqlImpl;
import com.proyecto_universidad_java.repository.impl.Repository_i_TarifasMysqlImpl;
import com.proyecto_universidad_java.repository.impl.Repository_j_MatriculasMysqlImpl;
import com.proyecto_universidad_java.repository.impl.Repository_l_DireccionesMysqlImpl;
import com.proyecto_universidad_java.repository.impl.Repository_m_PersonasMysqlImpl;
import com.proyecto_universidad_java.repository.impl.Repository_n_EdifciosMysqlImpl;
import com.proyecto_universidad_java.repository.impl.Repository_o_PeriodoMysqlImpl;
import com.proyecto_universidad_java.repository.impl.Repository_q_HorarioMysqlImpl;
import com.proyecto_universidad_java.services.Service_b_Departamentos;
import com.proyecto_universidad_java.services.Service_c_Profesores;
import com.proyecto_universidad_java.services.Service_d_Alumnos;
import com.proyecto_universidad_java.services.Service_e_Cursos;
import com.proyecto_universidad_java.services.Service_f_Asignaturas;
import com.proyecto_universidad_java.services.Service_g_Programas;
import com.proyecto_universidad_java.services.Service_h_Salones;
import com.proyecto_universidad_java.services.Service_i_Tarifas;
import com.proyecto_universidad_java.services.Service_j_Matriculas;
import com.proyecto_universidad_java.services.Service_l_Direcciones;
import com.proyecto_universidad_java.services.Service_m_Personas;
import com.proyecto_universidad_java.services.Service_n_Edificios;
import com.proyecto_universidad_java.services.Service_o_Periodo;
import com.proyecto_universidad_java.services.Service_q_Horario;
import com.proyecto_universidad_java.services.Impl.Service_b_DepartamentosImpl;
import com.proyecto_universidad_java.services.Impl.Service_c_ProfesoresImpl;
import com.proyecto_universidad_java.services.Impl.Service_d_AlumnosImpl;
import com.proyecto_universidad_java.services.Impl.Service_e_CursosImpl;
import com.proyecto_universidad_java.services.Impl.Service_f_AsignaturasImpl;
import com.proyecto_universidad_java.services.Impl.Service_g_ProgramasImpl;
import com.proyecto_universidad_java.services.Impl.Service_h_SalonesImpl;
import com.proyecto_universidad_java.services.Impl.Service_i_TarifasImpl;
import com.proyecto_universidad_java.services.Impl.Service_j_MatriculasImpl;
import com.proyecto_universidad_java.services.Impl.Service_l_DireccionesImpl;
import com.proyecto_universidad_java.services.Impl.Service_m_PersonasImpl;
import com.proyecto_universidad_java.services.Impl.Service_n_EdificiosImpl;
import com.proyecto_universidad_java.services.Impl.Service_o_PeriodoImpl;
import com.proyecto_universidad_java.services.Impl.Service_q_HorarioImpl;

public class View_a_MainUniversidad {

    public static final Service_b_Departamentos serviceDepartamento = new Service_b_DepartamentosImpl(
            new Repository_b_DepartamentosMysqlImpl());
    public static final Service_c_Profesores serviceProfesores = new Service_c_ProfesoresImpl(
            new Repository_c_ProfesoresMysqlImpl());
    public static final Service_d_Alumnos serviceAlumnos = new Service_d_AlumnosImpl(
            new Repository_d_AlumnosMysqlImpl());
    public static final Service_e_Cursos serviceCursos = new Service_e_CursosImpl(new Repository_e_CursosMysqlImpl());
    public static final Service_f_Asignaturas serviceAsignaturas = new Service_f_AsignaturasImpl(
            new Repository_f_AsignaturasMysqlImpl());
    public static final Service_g_Programas serviceProgramas = new Service_g_ProgramasImpl(
            new Repository_g_ProgramasMysqlImpl());
    public static final Service_h_Salones serviceSalones = new Service_h_SalonesImpl(
            new Repository_h_SalonesMysqlImpl());
    public static final Service_i_Tarifas serviceTarifas = new Service_i_TarifasImpl(
            new Repository_i_TarifasMysqlImpl());
    public static final Service_j_Matriculas serviceMatriculas = new Service_j_MatriculasImpl(
            new Repository_j_MatriculasMysqlImpl());
    public static final Service_l_Direcciones serviceDirecciones = new Service_l_DireccionesImpl(
            new Repository_l_DireccionesMysqlImpl());
    public static final Service_m_Personas Service_m_Personas = new Service_m_PersonasImpl(
            new Repository_m_PersonasMysqlImpl());
    public static final Service_n_Edificios serviceEdificios = new Service_n_EdificiosImpl(
            new Repository_n_EdifciosMysqlImpl());
    public static final Service_o_Periodo servicePeriodo = new Service_o_PeriodoImpl(
            new Repository_o_PeriodoMysqlImpl());
    public static final Service_q_Horario serviceHorario = new Service_q_HorarioImpl(
            new Repository_q_HorarioMysqlImpl());

    public static final Scanner leer = new Scanner(System.in);

    public static void main(String[] args) {

        int op = 0;

        do {

            op = menuMain();
            System.out.print("\033[H\033[2J");
            System.out.flush();

            switch (op) {
                case 1:
                    System.out.println("Opción 1 -- Departamentos\n");
                    View_b_Departamentos.startMenu();
                    break;
                case 2:
                    System.out.println("Opción 2 -- Profesores\n");
                    View_c_Profesores.startMenu();
                    break;
                case 3:
                    System.out.println("Opción 3 -- Alumnos\n");
                    View_d_Alumnos.startMenu();
                    break;
                case 4:
                    System.out.println("Opción 4 -- Cursos\n");
                    View_e_Cursos.startMenu();
                    break;
                case 5:
                    System.out.println("Opción 5 -- Asignaturas\n");
                    View_f_Asignaturas.startMenu();
                    break;
                case 6:
                    System.out.println("Opción 6 -- Departamentos\n");
                    View_g_Programas.startMenu();
                    break;
                case 7:
                    System.out.println("Opción 7 -- Salones\n");
                    View_h_Salones.startMenu();
                    break;
                case 8:
                    System.out.println("Opción 8 -- Tarifas\n");
                    View_i_Tarifas.startMenu();
                    break;
                case 9:
                    System.out.println("Opción 9 -- Departamentos\n");
                    View_j_Matriculas.startMenu();
                    break;
                default:
                    System.out.println("\nEl programa ha finalizado. \nHasta luego.");
                    break;
            }

        } while (op >= 1 && op < 10);

    }

    public static int menuMain() {
        System.out.println("-->>> Sistema de gestión de Universidad de los Sabios <<<--");
        System.out.println();
        System.out.println("1. Módulo de Departamentos");
        System.out.println("2. Módulo de Profesores");
        System.out.println("3. Módulo de Alumnos");
        System.out.println("4. Módulo de Cursos");
        System.out.println("5. Módulo de Asignaturas");
        System.out.println("6. Módulo de Programas");
        System.out.println("7. Módulo de Salones");
        System.out.println("8. Módulo de Tarifas");
        System.out.println("9. Módulo de Matriculas");
        System.out.println("10. Salir");
        System.out.println("\nEscriba el (#) número de la opción deseada:");

        return leer.nextInt();
    }
}
