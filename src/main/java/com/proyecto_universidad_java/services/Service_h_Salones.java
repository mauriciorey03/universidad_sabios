package com.proyecto_universidad_java.services;

import java.util.List;

import com.proyecto_universidad_java.repository.models.h_Salones;

public interface Service_h_Salones {

    List<h_Salones> listar();

    h_Salones porCodigo(int codigo);

    void crear(h_Salones salon);

    void editar(h_Salones salon);

    void eliminar(int codigo);
    
    
}

