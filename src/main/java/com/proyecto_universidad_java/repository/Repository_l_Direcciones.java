package com.proyecto_universidad_java.repository;

import java.util.List;

import com.proyecto_universidad_java.repository.models.l_Direcciones;

public interface Repository_l_Direcciones {

    List<l_Direcciones> listar();

    l_Direcciones porCodigo(int codigo);

    void crear(l_Direcciones direccion);

    void editar(l_Direcciones direccion);

    void eliminar(int codigo);
    
    
}

