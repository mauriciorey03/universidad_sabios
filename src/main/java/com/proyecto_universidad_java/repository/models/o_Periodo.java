package com.proyecto_universidad_java.repository.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class o_Periodo {
    private int id_periodo;
    private int anio;
    private String semestre;

    public o_Periodo(String semestre, int anio){
        this.anio = anio;
        this.semestre = semestre;
    }
}

// CREATE TABLE periodo (
//   id_periodo INT NOT NULL AUTO_INCREMENT,
//   anio INT NOT NULL,
//   semestre ENUM('1', '2') NOT NULL,
//   PRIMARY KEY (id_periodo)
// );