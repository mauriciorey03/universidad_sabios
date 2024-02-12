package com.proyecto_universidad_java.services;

import java.util.List;

import com.proyecto_universidad_java.repository.models.o_Periodo;

public interface Service_o_Periodo {

    List<o_Periodo> listar();

    o_Periodo porCodigo(int codigo);

    void crear(o_Periodo periodo);

    void editar(o_Periodo periodo);

    void eliminar(int codigo);
    
    
}

