package com.proyecto_universidad_java.repository.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class n_Edificios {
    private int id_edificio;
    private String nombre_edificio;
    private int pisos_edificios;

    public n_Edificios(String nombre_edificio, int pisos_edificios){
        this.nombre_edificio = nombre_edificio;
        this.pisos_edificios = pisos_edificios;
    }
}

// CREATE TABLE edificios (
//   id_edificio INT NOT NULL AUTO_INCREMENT,
//   nombre_edificio VARCHAR(255) NOT NULL,
//   pisos_edificio INT NOT NULL,
//   PRIMARY KEY (id_edificio)
// );