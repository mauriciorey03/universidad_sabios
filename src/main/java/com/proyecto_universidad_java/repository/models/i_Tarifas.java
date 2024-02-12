package com.proyecto_universidad_java.repository.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor


public class i_Tarifas {
    private int id_valor_matricula;
    private double valor_credito;
    private int id_programa;
    private int id_periodo;


    
    public i_Tarifas(double valor_credito, int id_programa,int id_periodo) {
        this.valor_credito = valor_credito;
        this.id_programa = id_programa;
        this.id_periodo = id_periodo;

    }
    public void print() {
        System.out.println("ID Tarifa: " + getId_valor_matricula()+ ", Valor créditos: " + getValor_credito()+ ", ID Programa: " + getId_programa()+", ID Periodo: "+getId_periodo());
    }
}

// CREATE TABLE valor_matricula (
//   id_valor_matricula INT NOT NULL AUTO_INCREMENT,
//   valor_credito DECIMAL(10,2) NOT NULL,
//   id_programa INT NOT NULL,
//   id_periodo INT NOT NULL,
//   PRIMARY KEY (id_valor_matricula),
//   FOREIGN KEY (id_programa) REFERENCES carreras (id_programa),
//   FOREIGN KEY (id_periodo) REFERENCES periodo (id_periodo)
// );