package com.proyecto_universidad_java.repository.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class f_Asignaturas {
    private int id_materia;
    private String nombre_materia;
    private int creditos;
    private int cantidad_estudiantes;

    public f_Asignaturas(String nombre_materia, int creditos, int cantidad_estudiantes) {
        this.nombre_materia = nombre_materia;
        this.creditos = creditos;
        this.cantidad_estudiantes = cantidad_estudiantes;
    }
    public void print() {
        System.out.println("ID Materia: " + getId_materia()+ ", Nombre materia: " + getNombre_materia()+ ", Creditos: " + getCreditos()+", Cantidad estudiantes: "+getCantidad_estudiantes());
    }
}

// CREATE TABLE materias (
//   id_materia INT NOT NULL AUTO_INCREMENT,
//   nombre_materia VARCHAR(255) NOT NULL,
//   creditos INT NOT NULL,
//   cantidad_estudiantes INT NOT NULL,
//   PRIMARY KEY (id_materia)
// );