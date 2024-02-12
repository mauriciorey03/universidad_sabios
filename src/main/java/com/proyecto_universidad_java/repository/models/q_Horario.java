package com.proyecto_universidad_java.repository.models;

import java.sql.Time;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class q_Horario {
    private int id_horario;
    private String dia_clase;
    private Time hora_inicio;
    private Time hora_final;


    public q_Horario(String dia_clase, Time hora_inicio,Time hora_final){
        this.dia_clase = dia_clase;
        this.hora_inicio = hora_inicio;
        this.hora_final = hora_final;

    }
}

// CREATE TABLE horario (
//   id_horario INT NOT NULL AUTO_INCREMENT,
//   dia_clase VARCHAR(20) NOT NULL,
//   hora_inicio TIME NOT NULL,
//   hora_final TIME NOT NULL,
//   PRIMARY KEY (id_horario)
// );