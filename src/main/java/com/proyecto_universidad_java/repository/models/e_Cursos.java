package com.proyecto_universidad_java.repository.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class e_Cursos {
    private int id_curso;
    private String nombre_curso;
    private String guia_curso;
    
    public e_Cursos(String nombre_curso, String guia_curso) {
        this.nombre_curso = nombre_curso;
        this.guia_curso = guia_curso;
    }
}

// CREATE TABLE curso_materia (
//   id_curso INT NOT NULL AUTO_INCREMENT,
//   nombre_curso VARCHAR(255) NOT NULL,
//   guia_curso TEXT NOT NULL,
//   PRIMARY KEY (id_curso)
// );