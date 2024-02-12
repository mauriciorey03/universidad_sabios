package com.proyecto_universidad_java.repository;

import java.util.List;

import com.proyecto_universidad_java.repository.models.j_Matriculas;

public interface Repository_j_Matriculas {

    List<j_Matriculas> listar();

    j_Matriculas porCodigo(int codigo);

    void crear(j_Matriculas matricula);

    void editar(j_Matriculas matricula);

    void eliminar(int codigo);
    
    
}

