package com.proyecto_universidad_java.services;

import java.util.List;

import com.proyecto_universidad_java.repository.models.d_Alumnos;

public interface Service_d_Alumnos {

    List<d_Alumnos> listar();

    d_Alumnos porCodigo(int codigo);

    void crear(d_Alumnos alumno);

    void editar(d_Alumnos alumno);

    void eliminar(int codigo);
    
    
}

