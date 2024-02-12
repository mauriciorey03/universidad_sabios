package com.proyecto_universidad_java.repository.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class g_Programas {
    private int id_programa;
    private String nombre_programa;
    private String categoria;

    public g_Programas(String nombre_programa, String categoria) {
        this.nombre_programa = nombre_programa;
        this.categoria = categoria;
    }
    public void print() {
        System.out.println("ID Programa: " + getId_programa()+ ", Nombre programa: " + getNombre_programa()+ ", Categoria: " + getCategoria());
    }
}

// CREATE TABLE carreras (
//   id_programa INT NOT NULL AUTO_INCREMENT,
//   nombre_programa VARCHAR(255) NOT NULL,
//   categoria ENUM('Pregrado', 'Posgrado') NOT NULL,
//   PRIMARY KEY (id_programa)
// );