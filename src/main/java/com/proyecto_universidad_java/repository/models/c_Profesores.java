package com.proyecto_universidad_java.repository.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class c_Profesores {
    private int id_profesor;
    private int id_persona;
    private int id_facultad;

    public c_Profesores(int id_persona, int id_facultad) {
        this.id_persona = id_persona;
        this.id_facultad = id_facultad;
    }
}

// CREATE TABLE profesores (
//   id_profesor INT NOT NULL AUTO_INCREMENT,
//   id_persona INT NOT NULL,
//   id_facultad INT NOT NULL,
//   PRIMARY KEY (id_profesor),
//   FOREIGN KEY (id_persona) REFERENCES personas (id_persona),
//   FOREIGN KEY (id_facultad) REFERENCES facultades (id_facultad)
// );