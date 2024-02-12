package com.proyecto_universidad_java.repository.models;


import java.sql.Date;
import lombok.Data;


import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class m_Personas {
    private int id_persona;
    private String nombre_persona;
    private String apellido_persona;
    private int telefono;
    private Date fecha_nacimiento;
    private String genero;
    private String clase_documento;
    private int numero_documento;
    private int id_ciudad;
    private int id_direccion;

    public m_Personas(String nombre_persona, String apellido_persona, int telefono, Date fecha_nacimiento, String genero, String clase_documento, int numero_documento, int id_ciudad, int id_direccion){
        
        this.nombre_persona=nombre_persona;
        this.apellido_persona=apellido_persona;
        this.telefono=telefono;
        this.fecha_nacimiento=fecha_nacimiento;
        this.genero=genero;
        this.clase_documento=clase_documento;
        this.numero_documento=numero_documento;
        this.id_ciudad=id_ciudad;
        this.id_direccion=id_direccion;
    }
}

// CREATE TABLE personas (
//   id_persona INT NOT NULL AUTO_INCREMENT,
//   nombre_persona VARCHAR(255) NOT NULL,
//   apellido_persona VARCHAR(255) NOT NULL,
//   telefono INT,
//   fecha_nacimiento DATE NOT NULL, /*YYYY-MM-DD*/
//   genero ENUM('M', 'F') NOT NULL,
//   clase_documento ENUM('Cédula', 'Cédula de Extranjería', 'Número de Pasaporte', 'Tarjeta de Identidad') NOT NULL,
//   numero_documento INT NOT NULL,
//   id_ciudad INT NOT NULL,
//   id_direccion INT NOT NULL,
//   FOREIGN KEY (id_ciudad) REFERENCES ciudad (id),
//   FOREIGN KEY (id_direccion) REFERENCES direcciones (id),
//   PRIMARY KEY (id_persona)
// );