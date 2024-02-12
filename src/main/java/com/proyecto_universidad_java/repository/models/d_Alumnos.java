package com.proyecto_universidad_java.repository.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class d_Alumnos {
    private int id_estudiante; 
    private int id_persona; 
    private int id_programa;
    
    public d_Alumnos(int id_persona, int id_programa) {
        this.id_persona = id_persona;
        this.id_programa = id_programa;
    }
}

// CREATE TABLE estudiante_carrera (
//   id_estudiante INT NOT NULL AUTO_INCREMENT,
//   id_persona INT NOT NULL,
//   id_programa INT NOT NULL,
//   PRIMARY KEY (id_estudiante),
//   FOREIGN KEY (id_persona) REFERENCES personas (id_persona),
//   FOREIGN KEY (id_programa) REFERENCES carreras (id_programa)
// );
