package com.proyecto_universidad_java.services.Impl;

// import java.sql.Connection;
// import java.sql.PreparedStatement;
// import java.sql.ResultSet;
// import java.sql.SQLException;
// import java.sql.Statement;
// import java.util.ArrayList;
import java.util.List;

import com.proyecto_universidad_java.repository.Repository_n_Edificios;
import com.proyecto_universidad_java.repository.models.n_Edificios;
import com.proyecto_universidad_java.services.Service_n_Edificios;
// import com.universidad.utils.conexionpersistencia.conexionbdmysql.ConexionBDMysql;

public class Service_n_EdificiosImpl implements Service_n_Edificios {
    private final Repository_n_Edificios crudRepository_n_Edificios;

    public Service_n_EdificiosImpl(Repository_n_Edificios crudRepository_n_Edificios) {
        this.crudRepository_n_Edificios = crudRepository_n_Edificios;
    }

    // private Connection getConnection() throws SQLException {
    //     return ConexionBDMysql.getInstance();
    // }

    public List<n_Edificios> listar() {
        return this.crudRepository_n_Edificios.listar();
    }

    public n_Edificios porCodigo(int codigo) {
        return this.crudRepository_n_Edificios.porCodigo(codigo);
        }    

    public void crear(n_Edificios obj){
        this.crudRepository_n_Edificios.crear(obj);
    }

    public void editar(n_Edificios obj){
        this.crudRepository_n_Edificios.editar(obj);
    }

    public void eliminar(int codigo){
        this.crudRepository_n_Edificios.eliminar(codigo);        
    }
}