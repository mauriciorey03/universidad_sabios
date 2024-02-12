package com.proyecto_universidad_java.repository;

import java.util.List;

import com.proyecto_universidad_java.repository.models.b_Departamentos;

public interface Repository_b_Departamentos {

    List<b_Departamentos> listar();

    b_Departamentos porCodigo(int codigo);

    void crear(b_Departamentos departamento);

    void editar(b_Departamentos departamento);

    void eliminar(int codigo);
    
    
}

