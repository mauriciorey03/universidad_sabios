package com.proyecto_universidad_java.services;

import java.util.List;

import com.proyecto_universidad_java.repository.models.i_Tarifas;

public interface Service_i_Tarifas {

    List<i_Tarifas> listar();

    i_Tarifas porCodigo(int codigo);

    void crear(i_Tarifas tarifa);

    void editar(i_Tarifas tarifa);

    void eliminar(int codigo);
    
    
}

