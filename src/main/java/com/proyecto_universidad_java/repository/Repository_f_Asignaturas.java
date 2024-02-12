package com.proyecto_universidad_java.repository;

import java.util.List;

import com.proyecto_universidad_java.repository.models.f_Asignaturas;

public interface Repository_f_Asignaturas {

    List<f_Asignaturas> listar();

    f_Asignaturas porCodigo(int codigo);

    void crear(f_Asignaturas asignatura);

    void editar(f_Asignaturas asignatura);

    void eliminar(int codigo);
    
    
}

