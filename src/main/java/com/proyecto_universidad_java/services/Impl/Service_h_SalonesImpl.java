package com.proyecto_universidad_java.services.Impl;

// import java.sql.Connection;
// import java.sql.PreparedStatement;
// import java.sql.ResultSet;
// import java.sql.SQLException;
// import java.sql.Statement;
// import java.util.ArrayList;
import java.util.List;

import com.proyecto_universidad_java.repository.Repository_h_Salones;
import com.proyecto_universidad_java.repository.models.h_Salones;
import com.proyecto_universidad_java.services.Service_h_Salones;
// import com.universidad.utils.conexionpersistencia.conexionbdmysql.ConexionBDMysql;

public class Service_h_SalonesImpl implements Service_h_Salones {
    private final Repository_h_Salones crudRepository_h_Salones;

    public Service_h_SalonesImpl(Repository_h_Salones crudRepository_h_Salones) {
        this.crudRepository_h_Salones = crudRepository_h_Salones;
    }

    // private Connection getConnection() throws SQLException {
    //     return ConexionBDMysql.getInstance();
    // }

    public List<h_Salones> listar() {
        return this.crudRepository_h_Salones.listar();
    }

    public h_Salones porCodigo(int codigo) {
        return this.crudRepository_h_Salones.porCodigo(codigo);
        }    

    public void crear(h_Salones obj){
        this.crudRepository_h_Salones.crear(obj);
    }

    public void editar(h_Salones obj){
        this.crudRepository_h_Salones.editar(obj);
    }

    public void eliminar(int codigo){
        this.crudRepository_h_Salones.eliminar(codigo);        
    }
}