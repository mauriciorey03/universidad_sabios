package com.proyecto_universidad_java.repository.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class h_Salones {
    private int id_salon;
    private String valor_salon;
    private int capacidad_salon;
    private int piso_edificio;

    public h_Salones(String valor_salon, int capacidad_salon, int piso_edificio) {
        this.valor_salon = valor_salon;
        this.capacidad_salon = capacidad_salon;
        this.piso_edificio = piso_edificio;
    }
    public void print() {
        System.out.println("ID Salón: " + getId_salon()+ ", Salón: " + getValor_salon()+ ", Capacidad del salón: " + getCapacidad_salon()+", Piso: "+getPiso_edificio());
    }
}

// CREATE TABLE salon (
//   id_salon INT NOT NULL AUTO_INCREMENT,
//   valor_salon VARCHAR(255) NOT NULL,
//   capacidad_salon INT NOT NULL,
//   piso_edificio INT NOT NULL,
//   PRIMARY KEY (id_salon),
//   FOREIGN KEY (piso_edificio) REFERENCES edificios (id_edificio)
// );