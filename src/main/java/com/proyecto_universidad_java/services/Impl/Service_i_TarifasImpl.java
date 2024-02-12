package com.proyecto_universidad_java.services.Impl;

// import java.sql.Connection;
// import java.sql.PreparedStatement;
// import java.sql.ResultSet;
// import java.sql.SQLException;
// import java.sql.Statement;
// import java.util.ArrayList;
import java.util.List;

import com.proyecto_universidad_java.repository.Repository_i_Tarifas;
import com.proyecto_universidad_java.repository.models.i_Tarifas;
import com.proyecto_universidad_java.services.Service_i_Tarifas;
// import com.universidad.utils.conexionpersistencia.conexionbdmysql.ConexionBDMysql;

public class Service_i_TarifasImpl implements Service_i_Tarifas {
    private final Repository_i_Tarifas crudRepository_i_Tarifas;

    public Service_i_TarifasImpl(Repository_i_Tarifas crudRepository_i_Tarifas) {
        this.crudRepository_i_Tarifas = crudRepository_i_Tarifas;
    }

    // private Connection getConnection() throws SQLException {
    //     return ConexionBDMysql.getInstance();
    // }

    public List<i_Tarifas> listar() {
        return this.crudRepository_i_Tarifas.listar();
    }

    public i_Tarifas porCodigo(int codigo) {
        return this.crudRepository_i_Tarifas.porCodigo(codigo);
        }    

    public void crear(i_Tarifas obj){
        this.crudRepository_i_Tarifas.crear(obj);
    }

    public void editar(i_Tarifas obj){
        this.crudRepository_i_Tarifas.editar(obj);
    }

    public void eliminar(int codigo){
        this.crudRepository_i_Tarifas.eliminar(codigo);        
    }
}