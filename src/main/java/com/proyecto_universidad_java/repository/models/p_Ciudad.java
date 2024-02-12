package com.proyecto_universidad_java.repository.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class p_Ciudad {
    private int id;
    private String nombre;

    public p_Ciudad(String nombre){
        this.nombre = nombre;
    }
    public void print() {
        System.out.println("ID Ciudad: " + getId()+ ", Nombre ciudad: " + getNombre());
    }
}

// CREATE TABLE ciudad (
//   id INT NOT NULL AUTO_INCREMENT,
//   nombre VARCHAR(255) NOT NULL,
//   PRIMARY KEY (id)
// );