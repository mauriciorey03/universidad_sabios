package com.proyecto_universidad_java.services.Impl;

// import java.sql.Connection;
// import java.sql.PreparedStatement;
// import java.sql.ResultSet;
// import java.sql.SQLException;
// import java.sql.Statement;
// import java.util.ArrayList;
import java.util.List;

import com.proyecto_universidad_java.repository.Repository_g_Programas;
import com.proyecto_universidad_java.repository.models.g_Programas;
import com.proyecto_universidad_java.services.Service_g_Programas;
// import com.universidad.utils.conexionpersistencia.conexionbdmysql.ConexionBDMysql;

public class Service_g_ProgramasImpl implements Service_g_Programas {
    private final Repository_g_Programas crudRepository_g_Programas;

    public Service_g_ProgramasImpl(Repository_g_Programas crudRepository_g_Programas) {
        this.crudRepository_g_Programas = crudRepository_g_Programas;
    }

    // private Connection getConnection() throws SQLException {
    //     return ConexionBDMysql.getInstance();
    // }

    public List<g_Programas> listar() {
        return this.crudRepository_g_Programas.listar();
    }

    public g_Programas porCodigo(int codigo) {
        return this.crudRepository_g_Programas.porCodigo(codigo);
        }    

    public void crear(g_Programas obj){
        this.crudRepository_g_Programas.crear(obj);
    }

    public void editar(g_Programas obj){
        this.crudRepository_g_Programas.editar(obj);
    }

    public void eliminar(int codigo){
        this.crudRepository_g_Programas.eliminar(codigo);        
    }
}