package com.proyecto_universidad_java.repository;

import java.util.List;

import com.proyecto_universidad_java.repository.models.p_Ciudad;

public interface Repository_p_Ciudad {

    List<p_Ciudad> listar();

    p_Ciudad porCodigo(int codigo);

    void crear(p_Ciudad ciudad);

    void editar(p_Ciudad ciudad);

    void eliminar(int codigo);
    
    
}

