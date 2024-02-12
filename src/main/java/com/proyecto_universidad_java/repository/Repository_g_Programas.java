package com.proyecto_universidad_java.repository;

import java.util.List;

import com.proyecto_universidad_java.repository.models.g_Programas;

public interface Repository_g_Programas {

    List<g_Programas> listar();

    g_Programas porCodigo(int codigo);

    void crear(g_Programas programa);

    void editar(g_Programas programa);

    void eliminar(int codigo);
    
    
}

