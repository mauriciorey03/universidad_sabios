package com.proyecto_universidad_java.services;

import java.util.List;

import com.proyecto_universidad_java.repository.models.q_Horario;

public interface Service_q_Horario {

    List<q_Horario> listar();

    q_Horario porCodigo(int codigo);

    void crear(q_Horario horario);

    void editar(q_Horario horario);

    void eliminar(int codigo);
    
    
}

