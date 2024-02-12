package com.proyecto_universidad_java.services;

import java.util.List;

import com.proyecto_universidad_java.repository.models.n_Edificios;

public interface Service_n_Edificios {

    List<n_Edificios> listar();

    n_Edificios porCodigo(int codigo);

    void crear(n_Edificios edificio);

    void editar(n_Edificios edificio);

    void eliminar(int codigo);
    
    
}

