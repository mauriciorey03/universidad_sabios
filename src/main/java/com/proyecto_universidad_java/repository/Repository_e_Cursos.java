package com.proyecto_universidad_java.repository;

import java.util.List;

import com.proyecto_universidad_java.repository.models.e_Cursos;

public interface Repository_e_Cursos {

    List<e_Cursos> listar();

    e_Cursos porCodigo(int codigo);

    void crear(e_Cursos curso);

    void editar(e_Cursos curso);

    void eliminar(int codigo);
    
    
}

