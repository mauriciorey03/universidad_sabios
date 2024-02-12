package com.proyecto_universidad_java.services;

import java.util.List;

import com.proyecto_universidad_java.repository.models.c_Profesores;
import com.proyecto_universidad_java.repository.models.m_Personas;

public interface Service_c_Profesores {

    List<c_Profesores> listar();

    List<m_Personas> toList();


    c_Profesores porCodigo(int codigo);

    void crear(c_Profesores profesor);

    void editar(c_Profesores profesor);

    void eliminar(int codigo);
    
    
}

