package com.proyecto_universidad_java.repository.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class j_Matriculas {
    private int id_registro;
    private int id_estudiante;
    private int id_periodo;
    private int id_materia;

    public j_Matriculas(int id_estudiante, int id_periodo, int id_materia){
        this.id_estudiante = id_estudiante;
        this.id_periodo = id_periodo;
        this.id_materia = id_materia;

    }
}

// CREATE TABLE registro (
//   id_registro INT NOT NULL AUTO_INCREMENT,
//   id_estudiante INT NOT NULL,
//   id_periodo INT NOT NULL,
//   id_materia INT NOT NULL,
//   PRIMARY KEY (id_registro),
//   FOREIGN KEY (id_estudiante) REFERENCES estudiante_carrera (id_estudiante),
//   FOREIGN KEY (id_periodo) REFERENCES periodo (id_periodo),
//   FOREIGN KEY (id_materia) REFERENCES materias (id_materia)
// );