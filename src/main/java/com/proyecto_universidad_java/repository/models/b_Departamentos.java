package com.proyecto_universidad_java.repository.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class b_Departamentos {
    private int id_facultad;
    private String nombre_facultad;

    public b_Departamentos(String nombre_facultad){
        this.nombre_facultad = nombre_facultad;
    }
}

// CREATE TABLE facultades (
//   id_facultad INT NOT NULL AUTO_INCREMENT,
//   nombre_facultad VARCHAR(255) NOT NULL,
//   PRIMARY KEY (id_facultad)
// );