package com.proyecto_universidad_java.services.Impl;

// import java.sql.Connection;
// import java.sql.PreparedStatement;
// import java.sql.ResultSet;
// import java.sql.SQLException;
// import java.sql.Statement;
// import java.util.ArrayList;
import java.util.List;

import com.proyecto_universidad_java.repository.Repository_c_Profesores;
import com.proyecto_universidad_java.repository.models.c_Profesores;
import com.proyecto_universidad_java.repository.models.m_Personas;
import com.proyecto_universidad_java.services.Service_c_Profesores;
// import com.universidad.utils.conexionpersistencia.conexionbdmysql.ConexionBDMysql;

public class Service_c_ProfesoresImpl implements Service_c_Profesores {
    private final Repository_c_Profesores crudRepository_c_Profesores;

    public Service_c_ProfesoresImpl(Repository_c_Profesores crudRepository_c_Profesores) {
        this.crudRepository_c_Profesores = crudRepository_c_Profesores;
    }

    // private Connection getConnection() throws SQLException {
    //     return ConexionBDMysql.getInstance();
    // }

    public List<c_Profesores> listar() {
        return this.crudRepository_c_Profesores.listar();
    }

    public List<m_Personas> toList() {
        return this.crudRepository_c_Profesores.toList();
    }

    public c_Profesores porCodigo(int codigo) {
        return this.crudRepository_c_Profesores.porCodigo(codigo);
        }    

    public void crear(c_Profesores obj){
        this.crudRepository_c_Profesores.crear(obj);
    }

    public void editar(c_Profesores obj){
        this.crudRepository_c_Profesores.editar(obj);
    }

    public void eliminar(int codigo){
        this.crudRepository_c_Profesores.eliminar(codigo);        
    }
}