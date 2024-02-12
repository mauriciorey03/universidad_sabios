package com.proyecto_universidad_java.repository.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class l_Direcciones {
    private int id;
    private String direccion_valor;

    public l_Direcciones(String direccion_valor){
        this.direccion_valor = direccion_valor;
    }
    public void print() {
        System.out.println("ID Dirección: " + getId()+ ", Dirección de valor: " + getDireccion_valor());
    }
}

// CREATE TABLE direcciones (
//   id INT NOT NULL AUTO_INCREMENT,
//   direccion_valor VARCHAR(255) NOT NULL,
//   PRIMARY KEY (id)
// );