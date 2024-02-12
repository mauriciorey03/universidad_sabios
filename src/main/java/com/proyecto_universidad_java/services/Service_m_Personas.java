package com.proyecto_universidad_java.services;

import java.util.List;

import com.proyecto_universidad_java.repository.models.m_Personas;

public interface Service_m_Personas {

    List<m_Personas> listar();

    m_Personas porCodigo(int codigo);

    void crear(m_Personas persona);

    void editar(m_Personas persona);

    void eliminar(int codigo);
    
    
}

