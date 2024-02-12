package com.proyecto_universidad_java.repository;

import java.util.List;

import com.proyecto_universidad_java.repository.models.c_Profesores;

public interface Repository_c_Profesores {

    List<c_Profesores> listar();

    c_Profesores porCodigo(int codigo);

    void crear(c_Profesores profesor);

    void editar(c_Profesores profesor);

    void eliminar(int codigo);
    
    
}

